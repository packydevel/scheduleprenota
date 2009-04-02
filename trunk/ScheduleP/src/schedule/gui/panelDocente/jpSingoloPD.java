package schedule.gui.panelDocente;

import java.util.LinkedHashMap;
import javax.swing.DefaultComboBoxModel;
import schedule.Insegnamenti;
import schedule.ProgrammaD;
import schedule.gui.DocenteJF;
import schedule.utility.Errori;

/** Pannello inserimento/modifica singolo programma didattico
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpSingoloPD extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpSingoloPD */
    public jpSingoloPD() {
        initComponents();        
        setVisible(false);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtTesto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jbSalva = new javax.swing.JButton();
        jbPulisci = new javax.swing.JButton();
        jbChiudi = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbTemplate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jcbInsegnam = new javax.swing.JComboBox();

        jLabel2.setText("Programma");

        jtxtTesto.setColumns(20);
        jtxtTesto.setRows(5);
        jScrollPane1.setViewportView(jtxtTesto);

        jLabel3.setText("Didattico");

        jbSalva.setText("Salva");
        jbSalva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvaMouseClicked(evt);
            }
        });

        jbPulisci.setText("Pulisci");
        jbPulisci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPulisciMouseClicked(evt);
            }
        });

        jbChiudi.setText("Chiudi");
        jbChiudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiMouseClicked(evt);
            }
        });

        jbUpdate.setText("Salva Modifiche");
        jbUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateMouseClicked(evt);
            }
        });

        jbTemplate.setText("Aggiungi Template");
        jbTemplate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbTemplateMouseClicked(evt);
            }
        });

        jLabel4.setText("Insegnamento *");

        Insegnamenti ins = new Insegnamenti();
        jcbInsegnam.setModel(new DefaultComboBoxModel(ins.hashNomi(DocenteJF.getDocente())) );
        hash = ins.getHash();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbInsegnam, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPulisci, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbChiudi)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbInsegnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jbSalva)
                    .addComponent(jbUpdate)
                    .addComponent(jbTemplate)
                    .addComponent(jbPulisci)
                    .addComponent(jbChiudi))
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jbChiudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiMouseClicked
        setVisible(false);
}//GEN-LAST:event_jbChiudiMouseClicked

    private void jbPulisciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciMouseClicked
        if (jbPulisci.isEnabled())
            pulisci();
    }//GEN-LAST:event_jbPulisciMouseClicked

    private void jbSalvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaMouseClicked
        if (jbSalva.isEnabled()) {
            Object ins = jcbInsegnam.getSelectedItem();
            if (ins!=null){
                ProgrammaD pd = new ProgrammaD(hash.get(ins).toString(), jtxtTesto.getText());
                pd.inserisci();
                ((jpListaPD)DocenteJF.getInstance().getPannello(jpListaPD.class.getName())).
                        setModelListaPD(ProgrammaD.modelloListaPD(DocenteJF.getDocente()));
                setVisible(false);
            } else 
                Errori.segnalaEccezione("si prega di completare i campi");
        }
}//GEN-LAST:event_jbSalvaMouseClicked

    private void jbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseClicked
        if (jbUpdate.isEnabled()) {
            String id_ins = hash.get(jcbInsegnam.getSelectedItem()).toString();                    
            ProgrammaD pd = new ProgrammaD(id_ins ,jtxtTesto.getText());
            pd.aggiorna();
            setVisible(false);            
        }
    }//GEN-LAST:event_jbUpdateMouseClicked

    private void jbTemplateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTemplateMouseClicked
        if (jbTemplate.isEnabled())
            jtxtTesto.setText(ProgrammaD.template());        
    }//GEN-LAST:event_jbTemplateMouseClicked
    
    /**abilita/disabilita azioni/bottoni a seconda del valore in input
     * 
     * @param abilita Nuovo/Modifica/Leggi
     */
    public void abilita(String abilita){
        if (abilita.equalsIgnoreCase("Nuovo")) {
            pulisci();
            jtxtTesto.setEditable(true);            
            jbSalva.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbPulisci.setEnabled(true);
            jbTemplate.setEnabled(true);
            jcbInsegnam.setEnabled(true);
        } else if (abilita.equalsIgnoreCase("Modifica")) {            
            jbSalva.setEnabled(false);
            jbUpdate.setEnabled(true);
            jbPulisci.setEnabled(true);
            jtxtTesto.setEditable(true);
            jbTemplate.setEnabled(true);
            jcbInsegnam.setEnabled(false);
        } else if (abilita.equalsIgnoreCase("Leggi")) {            
            jbSalva.setEnabled(false);
            jbUpdate.setEnabled(false);
            jbPulisci.setEnabled(false);
            jtxtTesto.setEditable(false);
            jbTemplate.setEnabled(false);
            jcbInsegnam.setEnabled(false);
        }
    }
    
    /**popola i campi
     * 
     * @param valore stringa insegnamento
     */
    public void popola(Object valore){
        ProgrammaD pd = new ProgrammaD(hash.get(valore).toString());
        pd.singolo();
        jcbInsegnam.setSelectedItem(valore);
        jtxtTesto.setText(pd.getTesto());        
    }
    
    private void pulisci(){
        jtxtTesto.setText(null);
        jcbInsegnam.setSelectedItem(null);
    }
    
    /**restituisce l'LinkedHashMap attuale degli insegnamenti e relativi id
     * 
     * @return LinkedHashMap
     */
    protected static LinkedHashMap getHashID(){
        return hash;
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbChiudi;
    private javax.swing.JButton jbPulisci;
    private javax.swing.JButton jbSalva;
    private javax.swing.JButton jbTemplate;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbInsegnam;
    private javax.swing.JTextArea jtxtTesto;
    // End of variables declaration//GEN-END:variables
    //private ProgrammaD oldpd;
    private static LinkedHashMap hash;
} //end class