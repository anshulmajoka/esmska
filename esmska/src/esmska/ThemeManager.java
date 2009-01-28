/*
 * ThemeManager.java
 *
 * Created on 24. srpen 2007, 23:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package esmska;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.PlasticTheme;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import javax.swing.JDialog;
import javax.swing.UIManager;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SkinInfo;
import esmska.data.Config;
import esmska.persistence.PersistenceManager;
import esmska.utils.JavaType;
import esmska.utils.Nullator;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager.LookAndFeelInfo;
import org.jvnet.lafwidget.LafWidget;
import org.jvnet.substance.skin.SaharaSkin;

/** Manage and set look and feel
 *
 * @author ripper
 */
public class ThemeManager {
    public enum LAF {
        SYSTEM, CROSSPLATFORM, GTK, JGOODIES, SUBSTANCE
    }

    private static final Logger logger = Logger.getLogger(ThemeManager.class.getName());
    private static LookAndFeelInfo[] installedLafs = UIManager.getInstalledLookAndFeels();

    static {
        //if Nimbus is available, let's replace Metal with it
        setNimbusAsCrossplatformLAF();
    }

    /** Disabled constructor */
    private ThemeManager() {
    }

    /** Set look and feel found in configuration. If it is not possible, use
     * the next best one.
     * @throws Throwable when chosen look and feel can't be set
     */
    public static void setLaF() throws Throwable {
        Config config = PersistenceManager.getConfig();
        ThemeManager.LAF laf = config.getLookAndFeel();

        //if selected LaF is not supported, then use a suggested one
        if (!isLaFSupported(laf)) {
            LAF newLaf = suggestBestLAF();
            logger.info("Look and feel '" + laf + "' is no longer supported on " +
                    "your system, selected a new one: " + newLaf);
            laf = newLaf;
            config.setLookAndFeel(laf);
        }

        //with most LaFs use system decorations
        setLaFDecorated(false);

        switch (laf) {
            case SYSTEM:
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                break;
            case CROSSPLATFORM:
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                break;
            case GTK:
                boolean found = false;
                for (LookAndFeelInfo lafInfo : installedLafs) {
                    if ("GTK+".equals(lafInfo.getName())) {
                        UIManager.setLookAndFeel(lafInfo.getClassName());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    //GTK requested and supported, but now we can't find it among installed LAFs
                    throw new IllegalStateException("GTK LaF requested, but not found");
                }
                break;
            case JGOODIES:
                String themeString = config.getLafJGoodiesTheme();
                PlasticTheme theme = null;
                for (Object o : PlasticLookAndFeel.getInstalledThemes()) {
                    PlasticTheme ptheme = (PlasticTheme) o;
                    if (ptheme.getName().equals(themeString)) {
                        theme = ptheme;
                        break;
                    }
                }
                PlasticLookAndFeel.setPlasticTheme(theme != null ? theme : new ExperienceBlue());
                UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
                break;
            case SUBSTANCE:
                String skinString = config.getLafSubstanceSkin();
                String skin = null;
                for (SkinInfo skinInfo : SubstanceLookAndFeel.getAllSkins().values()) {
                    if (skinInfo.getDisplayName().equals(skinString)) {
                        skin = skinInfo.getClassName();
                        break;
                    }
                }
                SubstanceLookAndFeel.setSkin(skin != null ? skin : new SaharaSkin().getClass().getName());
                //set Substance specific addons
                UIManager.put(LafWidget.TEXT_EDIT_CONTEXT_MENU, Boolean.TRUE);
                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
                //set LaF decorations
                setLaFDecorated(true);
                break;
            default:
                throw new IllegalArgumentException("Unknown LaF name");
        }

        logger.fine("New LaF set: " + UIManager.getLookAndFeel());
    }
    
    /** Returns whether GTK is current look and feel */
    public static boolean isGTKCurrentLaF() {
        LookAndFeel laf = UIManager.getLookAndFeel();
        return Nullator.isEqual(laf.getName(), "GTK look and feel");
    }

    /** Returns whether Aqua (Mac OS native) is current look and feel */
    public static boolean isAquaCurrentLaF() {
        LookAndFeel laf = UIManager.getLookAndFeel();
        return Nullator.isEqual(laf.getName(), "Mac OS X");
    }

    /** Returns whether Nimbus is current look and feel */
    public static boolean isNimbusCurrentLaF() {
        LookAndFeel laf = UIManager.getLookAndFeel();
        return Nullator.isEqual(laf.getName(), "Nimbus");
    }

    /** Returns whether Substance is current look and feel */
    public static boolean isSubstanceCurrentLaF() {
        LookAndFeel laf = UIManager.getLookAndFeel();
        return laf.getName() != null && laf.getName().startsWith("Substance");
    }
    
    /** Returns whether specified LaF is supported on current configuration
     * (operating system, java version, etc).
     */
    public static boolean isLaFSupported(LAF laf) {
        switch (laf) {
            case SYSTEM:
                //if system and crossplatform classnames are equal, then
                //there is no special "system" laf
                return !UIManager.getSystemLookAndFeelClassName().equals(
                        UIManager.getCrossPlatformLookAndFeelClassName());
            case CROSSPLATFORM:
                //always supported
                return true;
            case GTK:
                //only if installed
                for (LookAndFeelInfo lafInfo : installedLafs) {
                    if ("GTK+".equals(lafInfo.getName())) {
                        //and if different from system laf, because in that
                        //case there is no reason to display it twice
                        return !lafInfo.getClassName().equals(
                                UIManager.getSystemLookAndFeelClassName());
                    }
                }
                return false;
            case JGOODIES:
                //always supported
                return true;
            case SUBSTANCE:
                //always supported
                return true;
            default: 
                throw new IllegalArgumentException("Uknown LAF: " + laf);
        }
    }
    
    /** Propose the best LaF for current system, based on java type and
     * operating system. Useful for program first run.
     * @return the best LaF for this platform
     */
    public static LAF suggestBestLAF() {
        LAF laf = LAF.SUBSTANCE;

        //set system LaF on OpenJDK, because Substance throws exceptions
        if (JavaType.isOpenJDK()) {
            laf = LAF.SYSTEM;
        }
        //set system LaF on Apple, because Apple users are used to consistent look
        if (JavaType.isAppleJava()) {
            laf = LAF.SYSTEM;
        }

        //if the suggested LaF is not supported, suggest crossplatform LaF as a safe choice
        if (!isLaFSupported(laf)) {
            laf = LAF.CROSSPLATFORM;
        }

        logger.finer("Suggested LaF: " + laf);
        return laf;
    }


    /** If Nimbus LaF is available (from Java 6 Update 10), set it as the
     * default crossplatform LaF instead of Metal.
     */
    private static void setNimbusAsCrossplatformLAF() {
        for (LookAndFeelInfo lafInfo : installedLafs) {
            if ("Nimbus".equals(lafInfo.getName())) {
                System.setProperty("swing.crossplatformlaf", lafInfo.getClassName());
                return;
            }
        }
    }

    /** Set if frame and dialogs should be decorated by current LaF or by system
     */
    private static void setLaFDecorated(boolean decorated) {
        JFrame.setDefaultLookAndFeelDecorated(decorated);
        JDialog.setDefaultLookAndFeelDecorated(decorated);
    }
}
