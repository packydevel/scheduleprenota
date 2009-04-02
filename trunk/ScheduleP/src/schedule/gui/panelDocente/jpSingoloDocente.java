package schedule.gui.panelDocente;

import schedule.Docente;
import schedule.gui.DocenteJF;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Pannello dati personali docente per lettura/modifica
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
        modificaDocente(false);
        caricaDatiDocente();
        setVisible(true);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jtxtCognome = new javax.swing.JTextField();
        jtxtNome = new javax.swing.JTextField();
        jtxtLuogoN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtCellulare = new javax.swing.JTextField();
        jtxtTelUfficio = new javax.swing.JTextField();
        jtxtTelCasa = new javax.swing.JTextField();
        jtxtCitta = new javax.swing.JTextField();
        jtxtIndirizzo = new javax.swing.JTextField();
        jbModificaDocente = new javax.swing.JButton();
        jbUpdateDocente = new javax.swing.JButton();
        jcbGiorno = new javax.swing.JComboBox();
        jcbMese = new javax.swing.JComboBox();
        jcbAnno = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();

        jLabel1.setText("Cognome"); // NOI18N

        jtxtCognome.setEditable(false);

        jtxtNome.setEditable(false);

        jtxtLuogoN.setEditable(false);

        jLabel2.setText("Nome"); // NOI18N

        jLabel5.setText("Data Nascita"); // NOI18N

        jLabel6.setText("Luogo nascita"); // NOI18N

        jLabel3.setText("Indirizzo"); // NOI18N

        jLabel4.setText("Città"); // NOI18N

        jLabel7.setText("Telefono Casa"); // NOI18N

        jLabel8.setText("Telefono Ufficio"); // NOI18N

        jLabel9.setText("Cellulare"); // NOI18N

        jtxtCellulare.setEditable(false);

        jtxtTelUfficio.setEditable(false);

        jtxtTelCasa.setEditable(false);

        jtxtCitta.setEditable(false);

        jtxtIndirizzo.setEditable(false);

        jbModificaDocente.setText("Modifica dati personali"); // NOI18N
        jbModificaDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificaDocenteMouseClicked(evt);
            }
        });

        jbUpdateDocente.setVisible(false);
        jbUpdateDocente.setText("Salva Modifiche"); // NOI18N
        jbUpdateDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateDocenteMouseClicked(evt);
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

        jLabel10.setText("Email");

        jtxtEmail.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbModificaDocente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbUpdateDocente)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtCitta))
                            .addComponent(jtxtTelCasa)
                            .addComponent(jtxtTelUfficio)
                            .addComponent(jtxtCellulare, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtIndirizzo)
                                    .addComponent(jtxtCognome)
                                    .addComponent(jtxtNome)
                                    .addComponent(jtxtLuogoN, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtLuogoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jtxtIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtTelCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jtxtTelUfficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jtxtCellulare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUpdateDocente)
                    .addComponent(jbModificaDocente))
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jbModificaDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaDocenteMouseClicked
        modificaDocente(true);
        jbModificaDocente.setVisible(false);
        jbUpdateDocente.setVisible(true);
    }//GEN-LAST:event_jbModificaDocenteMouseClicked

    private void jbUpdateDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateDocenteMouseClicked
        String nome = jtxtNome.getText();
        String cognome = jtxtCognome.getText();
        if ((!nome.equals("")) && (!cognome.equals(""))) {
            String data="";
            Object gg = jcbGiorno.getSelectedItem();
            Object mm = jcbMese.getSelectedItem();
            Object aa = jcbAnno.getSelectedItem();
            boolean controlla = Common.controllaData(gg, mm, aa);
            if (controlla)
                    data = gg.toString() + "/" + mm + "/" + aa;
            if (((gg==null) && (mm==null) && (aa==null)) || (controlla)){                                    
                Docente doc = new Docente(DocenteJF.getDocente(), cognome, nome, jtxtIndirizzo.getText(),
                        jtxtCitta.getText(), jtxtTelUfficio.getText(),jtxtTelCasa.getText(),jtxtCellulare.getText(),
                        data,jtxtLuogoN.getText(),jtxtEmail.getText());
                doc.aggiornaDoc();
                modificaDocente(false);
                jbModificaDocente.setVisible(true);
                jbUpdateDocente.setVisible(false);                            
            }  else 
                Errori.segnalaEccezione("Data non valida");   
        } else 
            Errori.segnalaEccezione("il cognome e/o il nome sono obbligatori");        
    }//GEN-LAST:event_jbUpdateDocenteMouseClicked
    
    private void modificaDocente(boolean enabled){
        jtxtCognome.setEditable(enabled);
        jtxtNome.setEditable(enabled);
        jtxtCellulare.setEditable(enabled);
        jtxtCitta.setEditable(enabled);
        jcbAnno.setEnabled(enabled);
        jcbGiorno.setEnabled(enabled);
        jcbMese.setEnabled(enabled);
        jtxtLuogoN.setEditable(enabled);
        jtxtIndirizzo.setEditable(enabled);
        jtxtTelCasa.setEditable(enabled);
        jtxtTelUfficio.setEditable(enabled);
        jtxtEmail.setEditable(enabled);
    }
    
    private void caricaDatiDocente(){        
        Docente doc = new Docente(DocenteJF.getDocente());
        doc.datidocente();
        jtxtCognome.setText(doc.getCognome());
        jtxtNome.setText(doc.getNome());
        jtxtCellulare.setText(doc.getCellulare());
        jtxtCitta.setText(doc.getCitta());
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
        jtxtLuogoN.setText(doc.getLuogoNascita());
        jtxtIndirizzo.setText(doc.getIndirizzo());
        jtxtTelCasa.setText(doc.getTelCasa());
        jtxtTelUfficio.setText(doc.getTelUfficio());
        jtxtEmail.setText(doc.getEmail());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbModificaDocente;
    private javax.swing.JButton jbUpdateDocente;
    private javax.swing.JComboBox jcbAnno;
    private javax.swing.JComboBox jcbGiorno;
    private javax.swing.JComboBox jcbMese;
    private javax.swing.JTextField jtxtCellulare;
    private javax.swing.JTextField jtxtCitta;
    private javax.swing.JTextField jtxtCognome;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtIndirizzo;
    private javax.swing.JTextField jtxtLuogoN;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JTextField jtxtTelCasa;
    private javax.swing.JTextField jtxtTelUfficio;
    // End of variables declaration//GEN-END:variables
    
} //end class