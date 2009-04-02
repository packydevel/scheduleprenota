package schedule.gui.panelAdmin;

import schedule.Docente;
import schedule.Login;
import schedule.gui.AdminJF;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Pannello singolo docente (lato amministratore) per inserimento e modifica
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpSingoloDocente extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpSingoloDocente
     * 
     */
    public jpSingoloDocente() {
        initComponents();
        setVisible(false);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jtxtUtente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtCognome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtLuogo = new javax.swing.JTextField();
        jtxtIndirizzo = new javax.swing.JTextField();
        jtxtCitta = new javax.swing.JTextField();
        jtxtCasa = new javax.swing.JTextField();
        jtxtUfficio = new javax.swing.JTextField();
        jtxtCellulare = new javax.swing.JTextField();
        jbSalva = new javax.swing.JButton();
        jbPulisci = new javax.swing.JButton();
        jbChiudiNDoc = new javax.swing.JButton();
        jtxtPassword = new javax.swing.JPasswordField();
        jcbGiorno = new javax.swing.JComboBox();
        jcbMese = new javax.swing.JComboBox();
        jcbAnno = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();

        jLabel1.setText("Utente *"); // NOI18N

        jLabel3.setText("Password *"); // NOI18N

        jLabel2.setText("Cognome *"); // NOI18N

        jLabel4.setText("Nome *"); // NOI18N

        jLabel5.setText("Data di nascita");

        jLabel6.setText("Luogo di nascita");

        jLabel7.setText("Indirizzo");

        jLabel8.setText("Città");

        jLabel9.setText("Telefono casa");

        jLabel10.setText("Telefono ufficio");

        jLabel11.setText("Cellulare");

        jbSalva.setText("Salva"); // NOI18N
        jbSalva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvaMouseClicked(evt);
            }
        });

        jbPulisci.setText("Pulisci"); // NOI18N
        jbPulisci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPulisciMouseClicked(evt);
            }
        });

        jbChiudiNDoc.setText("Chiudi"); // NOI18N
        jbChiudiNDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiNDocMouseClicked(evt);
            }
        });

        int maxG=32;
        String []giorno=new String[maxG];
        giorno[0]=null;
        for (int i=1;i<maxG; i++)
        giorno[i]=Integer.toString(i);
        jcbGiorno.setModel(new javax.swing.DefaultComboBoxModel(giorno));

        int maxM=13;
        String[] mese = new String[maxM];
        mese[0] = null;
        for (int i=1;i<maxM; i++)
        mese[i] = Integer.toString(i);
        jcbMese.setModel(new javax.swing.DefaultComboBoxModel(mese));

        int maxA=100;
        String[] anno = new String[maxA];
        anno[0] = null;
        for (int i=1;i<maxA; i++)
        anno[i] = Integer.toString(1910+i);
        jcbAnno.setModel(new javax.swing.DefaultComboBoxModel(anno));

        jLabel13.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalva)
                        .addGap(6, 6, 6)
                        .addComponent(jbPulisci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbChiudiNDoc))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtUtente, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtCognome, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtLuogo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtIndirizzo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtCitta, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtCasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtCellulare, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jtxtUfficio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtUfficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtCellulare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalva)
                    .addComponent(jbPulisci)
                    .addComponent(jbChiudiNDoc))
                .addGap(24, 24, 24))
        );
    }//GEN-END:initComponents

    private void jbSalvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaMouseClicked
        if (jbSalva.isEnabled()) {
            String utente = jtxtUtente.getText();
            String password = new String(jtxtPassword.getPassword());
            String cognome = jtxtCognome.getText();
            String nome = jtxtNome.getText();
            if ((!utente.equalsIgnoreCase("")) && (!password.equalsIgnoreCase("")) &&
                    (!cognome.equalsIgnoreCase("")) && (!nome.equalsIgnoreCase(""))) {
                String data="";
                Object gg = jcbGiorno.getSelectedItem();
                Object mm = jcbMese.getSelectedItem();
                Object aa = jcbAnno.getSelectedItem();
                boolean controlla = Common.controllaData(gg, mm, aa);
                if (controlla)
                    data = gg.toString() + "/" + mm + "/" + aa;                            
                if (((gg==null) && (mm==null) && (aa==null)) || (controlla)){                                    
                    Login accesso = new Login(utente,new String(password));                
                    if (accesso.inserisci()!=-1){                    
                        String luogo = jtxtLuogo.getText();
                        String indirizzo = jtxtIndirizzo.getText();
                        String citta = jtxtCitta.getText();
                        String casa = jtxtCasa.getText();
                        String ufficio = jtxtUfficio.getText();
                        String cell = jtxtCellulare.getText();
                        String email = jtxtEmail.getText();
                        Docente doc = new Docente(utente, cognome, nome, indirizzo, 
                                citta, ufficio, casa, cell, data, luogo, email);
                        if (doc.inserisciDocente()) {
                            this.setVisible(false);
                            ((jpListaDocenti)AdminJF.getInstance().getPannello(jpListaDocenti.class.getName())).
                                setModelListaDocenti(schedule.Docente.modelloListaDocCompleta());
                        } else
                            accesso.elimina();  
                    }                    
                } else 
                    Errori.segnalaEccezione("data non valida.");
            } else
                Errori.segnalaEccezione("Si prega di completare i primi 4 campi");
        }
    }//GEN-LAST:event_jbSalvaMouseClicked

    private void jbPulisciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciMouseClicked
        if (jbPulisci.isEnabled())
            pulisciCampi();
    }//GEN-LAST:event_jbPulisciMouseClicked

    private void jbChiudiNDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiNDocMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jbChiudiNDocMouseClicked

    /**imposta i campi del docente
     * 
     * @param doc
     */
    public void setLabel(Docente doc){
        jtxtUtente.setText(doc.getUtente());
        jtxtCognome.setText(doc.getCognome());
        jtxtNome.setText(doc.getNome());
        String data = doc.getDataNascita();
        if (data!=null){
            String[] temp = data.split("/");
            if (temp.length==3){
                jcbAnno.setSelectedItem(temp[2]);
                jcbGiorno.setSelectedItem(temp[0]);
                jcbMese.setSelectedItem(temp[1]);
            } else {
                jcbAnno.setSelectedItem(null);
                jcbGiorno.setSelectedItem(null);
                jcbMese.setSelectedItem(null);
            }
        } else {
            jcbAnno.setSelectedItem(null);
            jcbGiorno.setSelectedItem(null);
            jcbMese.setSelectedItem(null);
        }
        jtxtLuogo.setText(doc.getLuogoNascita());
        jtxtIndirizzo.setText(doc.getIndirizzo());
        jtxtCitta.setText(doc.getCitta());
        jtxtCasa.setText(doc.getTelCasa());
        jtxtUfficio.setText(doc.getTelUfficio());
        jtxtCellulare.setText(doc.getCellulare());
        jtxtEmail.setText(doc.getEmail());
    }
    
    /**abilita/disabilita i campi del docente
     * 
     * @param abilita
     */
    public void setAbilita(boolean abilita){
        jtxtCognome.setEditable(abilita);
        jtxtNome.setEditable(abilita);
        jcbAnno.setEnabled(abilita);
        jcbGiorno.setEnabled(abilita);
        jcbMese.setEnabled(abilita);
        jtxtLuogo.setEditable(abilita);
        jtxtIndirizzo.setEditable(abilita);
        jtxtCitta.setEditable(abilita);
        jtxtCasa.setEditable(abilita);
        jtxtUfficio.setEditable(abilita);
        jtxtCellulare.setEditable(abilita);
        jtxtEmail.setEditable(abilita);
    }
    
    /**abilita/disabilita i campi utente e password
     * 
     * @param abilita
     */
    public void setAbilitaUP(boolean abilita){
        jtxtPassword.setEditable(abilita);
        jtxtUtente.setEditable(abilita);
    }
    
    /**abilita/disabilita i bottoni
     * 
     * @param abilita
     */
    public void setAbilitaB(boolean abilita){
        jbSalva.setEnabled(abilita);
        jbPulisci.setEnabled(abilita);
    }
    
    /**pulisci i campi
     * 
     */
    public void pulisciCampi(){
        jtxtCognome.setText(null);
        jtxtNome.setText(null);
        jtxtPassword.setText(null);
        jtxtUtente.setText(null);
        jcbAnno.setSelectedItem(null);
        jcbGiorno.setSelectedItem(null);
        jcbMese.setSelectedItem(null);
        jtxtLuogo.setText(null);
        jtxtIndirizzo.setText(null);
        jtxtCitta.setText(null);
        jtxtCasa.setText(null);
        jtxtUfficio.setText(null);
        jtxtCellulare.setText(null);
        jtxtEmail.setText(null);
        jtxtUtente.requestFocus();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbChiudiNDoc;
    private javax.swing.JButton jbPulisci;
    private javax.swing.JButton jbSalva;
    private javax.swing.JComboBox jcbAnno;
    private javax.swing.JComboBox jcbGiorno;
    private javax.swing.JComboBox jcbMese;
    private javax.swing.JTextField jtxtCasa;
    private javax.swing.JTextField jtxtCellulare;
    private javax.swing.JTextField jtxtCitta;
    private javax.swing.JTextField jtxtCognome;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtIndirizzo;
    private javax.swing.JTextField jtxtLuogo;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUfficio;
    private javax.swing.JTextField jtxtUtente;
    // End of variables declaration//GEN-END:variables
    
}//end class