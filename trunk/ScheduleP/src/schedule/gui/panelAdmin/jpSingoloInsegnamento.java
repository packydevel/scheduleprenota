package schedule.gui.panelAdmin;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import javax.swing.ComboBoxModel;
import schedule.Insegnamenti;
import schedule.ProgrammaD;
import schedule.gui.AdminJF;
import schedule.utility.Errori;

/** Pannello singolo insegnamento per inserimento e modifica
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpSingoloInsegnamento extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpSingoloInsegnamento */
    public jpSingoloInsegnamento() {
        initComponents();
        setVisible(false);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel17 = new javax.swing.JLabel();
        jtxtId_Ins = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtxtNome_Ins = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbDocenti = new javax.swing.JComboBox();
        jbSalvaIns = new javax.swing.JButton();
        jbPulisciIns = new javax.swing.JButton();
        jbChiudiIns = new javax.swing.JButton();
        jbUpdateIns = new javax.swing.JButton();
        jcbAnno = new javax.swing.JComboBox();

        jLabel17.setText("ID *");

        jLabel22.setText("Nome *");

        jLabel23.setText("Anno accademico *");

        jLabel13.setText("Docente *");

        jbSalvaIns.setText("Salva");
        jbSalvaIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvaInsMouseClicked(evt);
            }
        });

        jbPulisciIns.setText("Pulisci");
        jbPulisciIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPulisciInsMouseClicked(evt);
            }
        });

        jbChiudiIns.setText("Chiudi");
        jbChiudiIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiInsMouseClicked(evt);
            }
        });

        jbUpdateIns.setText("Salva Modifiche");
        jbUpdateIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateInsMouseClicked(evt);
            }
        });

        jcbAnno.setModel(new javax.swing.DefaultComboBoxModel(generaAnniAcc()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbAnno, 0, 221, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtNome_Ins)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtxtId_Ins, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcbDocenti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvaIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPulisciIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbChiudiIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUpdateIns)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtxtId_Ins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jtxtNome_Ins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jcbAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcbDocenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvaIns)
                    .addComponent(jbPulisciIns)
                    .addComponent(jbChiudiIns)
                    .addComponent(jbUpdateIns)))
        );
    }//GEN-END:initComponents

    private void jbSalvaInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaInsMouseClicked
        if (jbSalvaIns.isEnabled()) {
            String id = jtxtId_Ins.getText();
            String nome = jtxtNome_Ins.getText();
            Object anno = jcbAnno.getSelectedItem();
            Object docente = jcbDocenti.getSelectedItem();
            if ((!id.equalsIgnoreCase("")) && (!nome.equalsIgnoreCase("")) && (anno!=null) && (docente!=null)) {                
                Insegnamenti insegn = new Insegnamenti(id, nome, anno.toString(), hash.get(docente).toString());
                insegn.inserisci();
                this.setVisible(false);
                ((jpListaInsegnamenti)AdminJF.getInstance().getPannello(jpListaInsegnamenti.class.getName())).
                        setModelListaInsegn(insegn.modelloListaIns());                 
            } else
                Errori.segnalaEccezione("Si prega di completare i campi");
        }
    }//GEN-LAST:event_jbSalvaInsMouseClicked

    private void jbPulisciInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciInsMouseClicked
        if (jbPulisciIns.isEnabled())
            pulisciCampi();
    }//GEN-LAST:event_jbPulisciInsMouseClicked

    private void jbChiudiInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiInsMouseClicked
        setVisible(false);
}//GEN-LAST:event_jbChiudiInsMouseClicked

    private void jbUpdateInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateInsMouseClicked
        if (jbUpdateIns.isEnabled()){
            String id = jtxtId_Ins.getText();
            String nome = jtxtNome_Ins.getText();
            Object anno = jcbAnno.getSelectedItem();
            Object docente = jcbDocenti.getSelectedItem();
            if ((!nome.equalsIgnoreCase("")) && (anno!=null) && (docente!=null)) {
                Insegnamenti insegn = new Insegnamenti(id, nome, anno.toString(), hash.get(docente).toString());
                insegn.aggiorna();
                if ((oldDocente!=null) && (oldDocente!=docente)){
                    ProgrammaD pd = new ProgrammaD(id);
                    pd.elimina();
                }
                this.setVisible(false);
                ((jpListaInsegnamenti)AdminJF.getInstance().getPannello(jpListaInsegnamenti.class.getName())).
                        setModelListaInsegn(schedule.Insegnamenti.modelloListaIns());                 
            } else
                Errori.segnalaEccezione("Si prega di completare i campi");
        }
}//GEN-LAST:event_jbUpdateInsMouseClicked
    
    /**pulisci i campi
     * 
     */
    public void pulisciCampi() {
        if (jbSalvaIns.isEnabled())
            jtxtId_Ins.setText(null);
        jtxtNome_Ins.setText(null);
        jcbAnno.setSelectedItem(null);
        jcbDocenti.setSelectedItem(null);
    }
    
    /**imposta il modello dei dati per la combobox
     * 
     * @param cbm
     */
    public void setComboModel(ComboBoxModel cbm){
        jcbDocenti.setModel(cbm);
    }        
    
    /**abilita/disabilita campi in base all'input
     * 
     * @param abilita Nuona/Leggi/Modifica
     */
    public void abilita(String abilita){
        if (abilita.equalsIgnoreCase("Nuova")){
            jbSalvaIns.setEnabled(true);
            jtxtId_Ins.setEditable(true);
            jtxtNome_Ins.setEditable(true);
            jcbAnno.setEnabled(true);            
            jcbDocenti.setEnabled(true);            
            jbPulisciIns.setEnabled(true);
            jbUpdateIns.setEnabled(false);
        }else if (abilita.equalsIgnoreCase("Leggi")){
            jtxtId_Ins.setEditable(false);
            jtxtNome_Ins.setEditable(false);
            jcbAnno.setEnabled(false);            
            jcbDocenti.setEnabled(false);
            jbSalvaIns.setEnabled(false);
            jbSalvaIns.setEnabled(false);
            jbPulisciIns.setEnabled(false);
            jbUpdateIns.setEnabled(false);
        }else if (abilita.equalsIgnoreCase("Modifica")){
            jtxtId_Ins.setEditable(false);
            jtxtNome_Ins.setEditable(true);
            jcbAnno.setEnabled(true);            
            jcbDocenti.setEnabled(true);
            jbSalvaIns.setEnabled(false);
            jbSalvaIns.setEnabled(false);
            jbPulisciIns.setEnabled(true);
            jbUpdateIns.setEnabled(true);
            oldDocente = jcbDocenti.getSelectedItem();
        }
    }
    
    /**popola campi
     * 
     * @param id
     * @param nome
     * @param anno
     * @param doc
     */
    public void popola(String id, String nome, Object anno, Object doc){
        jtxtId_Ins.setText(id);
        jtxtNome_Ins.setText(nome);
        jcbAnno.setSelectedItem(anno);
        jcbDocenti.setSelectedItem(doc);
    }
    
    /**imposta l'LinkedHashMap di appoggio per la ricerca dell'id docente
     * 
     * @param map
     */
    public void setHash(LinkedHashMap map){
        hash = map;
    }
    
    private String[] generaAnniAcc(){
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.YEAR, -2);
        String[] contenitore = new String[4];
        contenitore[0]=null;
        for (int i=1;i<4;i++){
            String anno = Integer.toString(gc.get(Calendar.YEAR))+"-";
            gc.add(Calendar.YEAR, 1);
            anno += Integer.toString(gc.get(Calendar.YEAR));
            contenitore[i] = anno;
        }
        return contenitore;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JButton jbChiudiIns;
    private javax.swing.JButton jbPulisciIns;
    private javax.swing.JButton jbSalvaIns;
    private javax.swing.JButton jbUpdateIns;
    private javax.swing.JComboBox jcbAnno;
    private javax.swing.JComboBox jcbDocenti;
    private javax.swing.JTextField jtxtId_Ins;
    private javax.swing.JTextField jtxtNome_Ins;
    // End of variables declaration//GEN-END:variables
    private LinkedHashMap hash;
    private Object oldDocente;
}//end class