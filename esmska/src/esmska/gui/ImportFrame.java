/*
 * ImportFrame.java
 *
 * Created on 18. srpen 2007, 23:11
 */

package esmska.gui;

import esmska.*;
import esmska.persistence.ContactParser;
import esmska.persistence.ContactParser;
import esmska.persistence.ContactParser;
import java.awt.CardLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;
import esmska.data.Contact;
import esmska.persistence.PersistenceManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Import contacts from external applications
 *
 * @author  ripper
 */
public class ImportFrame extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(ImportFrame.class.getName());
    private static final String RES = "/esmska/resources/";
    private CardLayout cardLayout;
    private SwingWorker<ArrayList<Contact>,Void> worker; //worker for background thread
    private TreeSet<Contact> contacts = PersistenceManager.getContacs();
    private MainFrame mainFrame;
    private String actualCard = "applicationPanel";
    
    /** Creates new form ImportFrame */
    public ImportFrame() {
        this.mainFrame = MainFrame.getInstance();
        initComponents();
        cardLayout = (CardLayout) cardPanel.getLayout();
        progressBar.setVisible(false);
        backButton.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appButtonGroup = new javax.swing.ButtonGroup();
        cardPanel = new javax.swing.JPanel();
        applicationPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kubikRadioButton = new javax.swing.JRadioButton();
        dreamcomSERadioButton = new javax.swing.JRadioButton();
        esmskaRadioButton = new javax.swing.JRadioButton();
        esmskaPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fileTextFieldEsmska = new javax.swing.JTextField();
        browseButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        kubikPanel = new javax.swing.JPanel();
        fileTextFieldKubik = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dreamcomSEPanel = new javax.swing.JPanel();
        fileTextFieldDreamcomSE = new javax.swing.JTextField();
        browseButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        resultsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        skipExistingCheckBox = new javax.swing.JCheckBox();
        nextButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Import kontaktů");
        setIconImage(new ImageIcon(getClass().getResource(RES + "contact-48.png")).getImage());

        cardPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setText("<html>\nImport kontaktů vám dovolí načíst vaše kontakty z jiné aplikace a zkopírovat je do Esmsky. V původní aplikaci zůstanou vaše kontakty nedotčeny.\n</html>");

        jLabel3.setText("Vyberte, ze které aplikace chcete importovat kontakty:");

        appButtonGroup.add(kubikRadioButton);
        kubikRadioButton.setText("Kubík SMS DreamCom");
        kubikRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        appButtonGroup.add(dreamcomSERadioButton);
        dreamcomSERadioButton.setText("DreamCom SE");
        dreamcomSERadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        appButtonGroup.add(esmskaRadioButton);
        esmskaRadioButton.setSelected(true);
        esmskaRadioButton.setText("Esmska");
        esmskaRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout applicationPanelLayout = new javax.swing.GroupLayout(applicationPanel);
        applicationPanel.setLayout(applicationPanelLayout);
        applicationPanelLayout.setHorizontalGroup(
            applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(applicationPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(esmskaRadioButton)
                            .addComponent(kubikRadioButton)
                            .addComponent(dreamcomSERadioButton))
                        .addGap(323, 323, 323)))
                .addContainerGap())
        );
        applicationPanelLayout.setVerticalGroup(
            applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(esmskaRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kubikRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dreamcomSERadioButton)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        cardPanel.add(applicationPanel, "applicationPanel");

        jLabel17.setText("<html>\nPro import kontaktů potřebujete mít nachystaný CSV soubor vytvořený pomocí funkce \"Exportovat kontakty\". Tento soubor zde vyberte.\n</html>");

        jLabel18.setText("Zvolte CSV soubor:");

        browseButton2.setMnemonic('r');
        browseButton2.setText("Procházet...");
        browseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButton2ActionPerformed(evt);
            }
        });

        jLabel19.setText("<html>\nSoubor bude prozkoumán a následně vám bude vypsán seznam kontaktů dostupných pro import. Žádné změny zatím nebudou provedeny.\n</html>");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/info.png"))); // NOI18N
        jLabel20.setText("<html>\nProgram předpokládá, že soubor je v kódování UTF-8.\n</html>");

        javax.swing.GroupLayout esmskaPanelLayout = new javax.swing.GroupLayout(esmskaPanel);
        esmskaPanel.setLayout(esmskaPanelLayout);
        esmskaPanelLayout.setHorizontalGroup(
            esmskaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(esmskaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(esmskaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, esmskaPanelLayout.createSequentialGroup()
                        .addComponent(fileTextFieldEsmska, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton2))
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        esmskaPanelLayout.setVerticalGroup(
            esmskaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(esmskaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(esmskaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton2)
                    .addComponent(fileTextFieldEsmska, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        cardPanel.add(esmskaPanel, "esmskaPanel");

        browseButton.setMnemonic('r');
        browseButton.setText("Procházet...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("<html>\nNejprve musíte exportovat kontakty z programu Kubík SMS DreamCom. Spusťte uvedený program, přejděte do adresáře kontaktů a pomocí pravého myšítka exportujte všechny své kontakty do CSV souboru. Tento soubor zde následně vyberte.\n</html>");

        jLabel5.setText("Zvolte CSV soubor:");

        jLabel6.setText("<html>\nSoubor bude prozkoumán a následně vám bude vypsán seznam kontaktů dostupných pro import. Žádné změny zatím nebudou provedeny.\n</html>");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/info.png"))); // NOI18N
        jLabel7.setText("<html>\nPokud budete mít problémy s importem, ověřte, zda nevyšla novější verze Esmsky, a zkuste to v ní.\n</html>");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/info.png"))); // NOI18N
        jLabel9.setText("<html>\nProgram předpokládá, že soubor je v kódování windows-1250 (výchozí kódování souborů pro české MS Windows).\n</html>");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/warning.png"))); // NOI18N
        jLabel15.setText("<html>\nBudou importovány pouze kontakty s operátory podporovanými Esmskou.\n</html>");

        javax.swing.GroupLayout kubikPanelLayout = new javax.swing.GroupLayout(kubikPanel);
        kubikPanel.setLayout(kubikPanelLayout);
        kubikPanelLayout.setHorizontalGroup(
            kubikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kubikPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kubikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kubikPanelLayout.createSequentialGroup()
                        .addComponent(fileTextFieldKubik, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        kubikPanelLayout.setVerticalGroup(
            kubikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kubikPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kubikPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileTextFieldKubik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        cardPanel.add(kubikPanel, "kubikPanel");

        browseButton1.setMnemonic('r');
        browseButton1.setText("Procházet...");
        browseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButton1ActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/info.png"))); // NOI18N
        jLabel13.setText("<html>\nPokud budete mít problémy s importem, ověřte, zda nevyšla novější verze Esmsky, a zkuste to v ní.\n</html>");

        jLabel10.setText("<html>\nNejprve musíte exportovat kontakty z programu DreamCom SE. Spusťte uvedený program, přejděte do adresáře kontaktů a pomocí pravého myšítka exportujte všechny své kontakty do CSV souboru. Tento soubor zde následně vyberte.\n</html>");

        jLabel11.setText("Zvolte CSV soubor:");

        jLabel12.setText("<html>\nSoubor bude prozkoumán a následně vám bude vypsán seznam kontaktů dostupných pro import. Žádné změny zatím nebudou provedeny.\n</html>");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/info.png"))); // NOI18N
        jLabel14.setText("<html>\nProgram předpokládá, že soubor je v kódování windows-1250 (výchozí kódování souborů pro české MS Windows).\n</html>");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/warning.png"))); // NOI18N
        jLabel16.setText("<html>\nBudou importovány pouze kontakty s operátory podporovanými Esmskou.\n</html>");

        javax.swing.GroupLayout dreamcomSEPanelLayout = new javax.swing.GroupLayout(dreamcomSEPanel);
        dreamcomSEPanel.setLayout(dreamcomSEPanelLayout);
        dreamcomSEPanelLayout.setHorizontalGroup(
            dreamcomSEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dreamcomSEPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dreamcomSEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dreamcomSEPanelLayout.createSequentialGroup()
                        .addComponent(fileTextFieldDreamcomSE, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton1))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        dreamcomSEPanelLayout.setVerticalGroup(
            dreamcomSEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dreamcomSEPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dreamcomSEPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton1)
                    .addComponent(fileTextFieldDreamcomSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        cardPanel.add(dreamcomSEPanel, "dreamcomSEPanel");

        jLabel1.setText("Byly nalezeny následující kontakty:");

        contactList.setModel(new DefaultListModel());
        contactList.setCellRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                JLabel label = (JLabel) comp;
                Contact c = (Contact) value;
                label.setText(c.getName() + " (" + c.getNumber() + ", " + c.getOperator() + ")");
                return label;
            }

        });
        jScrollPane1.setViewportView(contactList);

        jLabel8.setText("Pokud chcete tyto kontakty importovat, stiskněte Importovat.");

        skipExistingCheckBox.setSelected(true);
        skipExistingCheckBox.setText("Neimportovat již existující kontakty");
        skipExistingCheckBox.setToolTipText("<html>\nPokud budou v importovaném souboru nalezeny kontakty<br>\njiž v Esmsce existující, nezobrazí se ve výše uvedeném seznamu<br>\na nebudou importovány do adresáře Esmsky\n</html>");
        skipExistingCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        skipExistingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipExistingCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(skipExistingCheckBox))
                .addContainerGap())
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skipExistingCheckBox)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(109, 109, 109))
        );

        cardPanel.add(resultsPanel, "resultsPanel");

        nextButton.setMnemonic('p');
        nextButton.setText("Pokračovat");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        progressBar.setIndeterminate(true);
        progressBar.setString("Prosím čekejte...");
        progressBar.setStringPainted(true);

        backButton.setText("Zpět");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addContainerGap())
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, nextButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextButton)
                        .addComponent(backButton))
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, nextButton, progressBar});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //parsovani
        if (actualCard.equals("esmskaPanel") || actualCard.equals("kubikPanel") ||
                actualCard.equals("dreamcomSEPanel")) {
            
            backButton.setVisible(false);
            cardLayout.show(cardPanel, "applicationPanel");
            actualCard = "applicationPanel";
            return;
        }
        //vysledek
        if (actualCard.equals("resultsPanel")) {
            String nextCard = null;
            if (kubikRadioButton.isSelected())
                nextCard = "kubikPanel";
            else if (dreamcomSERadioButton.isSelected())
                nextCard = "dreamcomSEPanel";
            else if (esmskaRadioButton.isSelected())
                nextCard = "esmskaPanel";
            
            nextButton.setText("Pokračovat");
            nextButton.setIcon(null);
            
            cardLayout.show(cardPanel, nextCard);
            actualCard = nextCard;
        }
    }//GEN-LAST:event_backButtonActionPerformed
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        //uvodni panel
        if (actualCard.equals("applicationPanel")) {
            String nextCard = null;
            if (kubikRadioButton.isSelected())
                nextCard = "kubikPanel";
            else if (dreamcomSERadioButton.isSelected())
                nextCard = "dreamcomSEPanel";
            else if (esmskaRadioButton.isSelected())
                nextCard = "esmskaPanel";
            
            cardLayout.show(cardPanel, nextCard);
            actualCard = nextCard;
            backButton.setVisible(true);
            return;
        }
        //parsovani
        if (actualCard.equals("esmskaPanel") || actualCard.equals("kubikPanel") ||
                actualCard.equals("dreamcomSEPanel")) {
            
            ContactParser.ContactType type = null;
            String filename = null;
            if (actualCard.equals("esmskaPanel")) {
                type = ContactParser.ContactType.ESMSKA_FILE;
                filename = fileTextFieldEsmska.getText();
            } else if (actualCard.equals("kubikPanel")) {
                type = ContactParser.ContactType.KUBIK_DREAMCOM_FILE;
                filename = fileTextFieldKubik.getText();
            } else if (actualCard.equals("dreamcomSEPanel")) {
                type = ContactParser.ContactType.DREAMCOM_SE_FILE;
                filename = fileTextFieldDreamcomSE.getText();
            }
            
            File file = new File(filename);
            if (!(file.isFile() && file.canRead())) {
                JOptionPane.showMessageDialog(this, "Soubor " + file.getAbsolutePath() + " nelze přečíst!",
                        "Chyba při čtení souboru", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            progressBar.setVisible(true);
            nextButton.setEnabled(false);
            backButton.setEnabled(false);
            worker = new ContactParser(file, type);
            worker.addPropertyChangeListener(new ParseContactsFinishedListener());
            worker.execute();
            
            return;
        }
        //vysledek
        if (actualCard.equals("resultsPanel")) {
            DefaultListModel contactListModel = (DefaultListModel) contactList.getModel();
            ArrayList<Contact> newContacts = new ArrayList<Contact>();
            
            for (Object o : contactListModel.toArray())
                newContacts.add((Contact) o);
            
            mainFrame.importContacts(newContacts);
            
            this.setVisible(false);
            this.dispose();
            return;
        }
    }//GEN-LAST:event_nextButtonActionPerformed
    
    private void browseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButton2ActionPerformed
        String file = doBrowseButton();
        if (file != null) {
            fileTextFieldEsmska.setText(file);
        }
    }//GEN-LAST:event_browseButton2ActionPerformed
    
    private void browseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButton1ActionPerformed
        String file = doBrowseButton();
        if (file != null) {
            fileTextFieldDreamcomSE.setText(file);
        }
    }//GEN-LAST:event_browseButton1ActionPerformed
    
    private void skipExistingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipExistingCheckBoxActionPerformed
        if (skipExistingCheckBox.isSelected()) {
            removeExistingContacts();
        } else {
            DefaultListModel contactListModel = (DefaultListModel) contactList.getModel();
            contactListModel.clear();
            try {
                for (Contact c : worker.get())
                    contactListModel.addElement(c);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Problem getting new contacts", ex);
            }
        }
        
    }//GEN-LAST:event_skipExistingCheckBoxActionPerformed
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        String file = doBrowseButton();
        if (file != null) {
            fileTextFieldKubik.setText(file);
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    
    /** browse for file */
    private String doBrowseButton() {
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Zvolit");
        chooser.setDialogTitle("Vyberte soubor s exportovanými kontakty");
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".csv") || f.isDirectory();
            }
            public String getDescription() {
                return "CSV soubory (*.csv)";
            }
        });
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    /** remove contacts already present in contact list */
    private void removeExistingContacts() {
        DefaultListModel contactListModel = (DefaultListModel) contactList.getModel();
        Object[] imported = contactListModel.toArray();
        ArrayList<Object> skipped = new ArrayList<Object>();
        for (Object impor : imported) {
            for (Contact exist : contacts) {
                if (exist.compareTo((Contact) impor) == 0) {
                    skipped.add(impor);
                    break;
                }
            }
        }
        for (Object skip : skipped)
            contactListModel.removeElement(skip);
    }
    
    /** handle end of parsing contacts */
    private class ParseContactsFinishedListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            if (! "state".equals(evt.getPropertyName()))
                return;
            if (! SwingWorker.StateValue.DONE.equals(evt.getNewValue()))
                return;
            try {
                DefaultListModel contactListModel = (DefaultListModel) contactList.getModel();
                contactListModel.clear();
                for (Contact c : worker.get())
                    contactListModel.addElement(c);
                if (skipExistingCheckBox.isSelected())
                    removeExistingContacts();
                
                nextButton.setText("Importovat");
                nextButton.setIcon(new ImageIcon(
                        ImportFrame.class.getResource(RES + "contact-16.png")));
                cardLayout.show(cardPanel, "resultsPanel");
                actualCard = "resultsPanel";
            } catch (Exception ex) {
                logger.log(Level.WARNING, "Error while parsing file", ex);
                JOptionPane.showMessageDialog(ImportFrame.this, "Nastala chyba při zpracování souboru!",
                        "Chyba při zpracování souboru", JOptionPane.ERROR_MESSAGE);
            } finally {
                progressBar.setVisible(false);
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup appButtonGroup;
    private javax.swing.JPanel applicationPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browseButton1;
    private javax.swing.JButton browseButton2;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JList contactList;
    private javax.swing.JPanel dreamcomSEPanel;
    private javax.swing.JRadioButton dreamcomSERadioButton;
    private javax.swing.JPanel esmskaPanel;
    private javax.swing.JRadioButton esmskaRadioButton;
    private javax.swing.JTextField fileTextFieldDreamcomSE;
    private javax.swing.JTextField fileTextFieldEsmska;
    private javax.swing.JTextField fileTextFieldKubik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel kubikPanel;
    private javax.swing.JRadioButton kubikRadioButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JCheckBox skipExistingCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
