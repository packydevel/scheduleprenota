package schedule.gui.panelAdmin;

import javax.swing.table.DefaultTableModel;
import schedule.Insegnamenti;
import schedule.gui.AdminJF;
import schedule.utility.Common;

/** Pannello&tabella lista insegnamenti
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpListaInsegnamenti extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpListaInsegnamenti */
    public jpListaInsegnamenti() {
        initComponents();
        setVisible(true);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane3 = new javax.swing.JScrollPane();
        jtListaInsegn = new javax.swing.JTable();
        jbNuovoInsegn = new javax.swing.JButton();
        jbModificaInsegn = new javax.swing.JButton();
        jbElimina = new javax.swing.JButton();

        jtListaInsegn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaInsegnMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtListaInsegn);

        jbNuovoInsegn.setText("Nuovo"); // NOI18N
        jbNuovoInsegn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNuovoInsegnMouseClicked(evt);
            }
        });

        jbModificaInsegn.setText("Modifica");
        jbModificaInsegn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificaInsegnMouseClicked(evt);
            }
        });

        jbElimina.setText("Elimina");
        jbElimina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEliminaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuovoInsegn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificaInsegn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbElimina))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuovoInsegn)
                    .addComponent(jbModificaInsegn)
                    .addComponent(jbElimina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbNuovoInsegnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNuovoInsegnMouseClicked
        jpSingoloInsegnamento jp = (jpSingoloInsegnamento) AdminJF.getInstance().getPannello(jpSingoloInsegnamento.class.getName());
        jp.abilita("Nuova");
        jp.pulisciCampi();        
        jp.setVisible(true);        
    }//GEN-LAST:event_jbNuovoInsegnMouseClicked

    private void jbModificaInsegnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaInsegnMouseClicked
        comune(false);            
    }//GEN-LAST:event_jbModificaInsegnMouseClicked

    private void jtListaInsegnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaInsegnMouseClicked
        comune(true);            
    }//GEN-LAST:event_jtListaInsegnMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        if (jbElimina.isEnabled()){
            int riga=jtListaInsegn.getSelectedRow();
            if (riga>-1) {
                if (Common.confermaDelete()==0){
                    String idIns = jtListaInsegn.getValueAt(riga, 0).toString();
                    Insegnamenti insegn = new Insegnamenti(idIns);
                    insegn.elimina();
                    AdminJF.getInstance().getPannello(jpSingoloDocente.class.getName()).setVisible(false);                    
                    setModelListaInsegn(insegn.modelloListaIns());                 
                }
            }
        }
}//GEN-LAST:event_jbEliminaMouseClicked
    
    private void comune(boolean leggi) {
        int riga =jtListaInsegn.getSelectedRow();
        if (riga>-1) {
            jpSingoloInsegnamento jp = (jpSingoloInsegnamento) AdminJF.getInstance().
                    getPannello(jpSingoloInsegnamento.class.getName());
            jp.pulisciCampi();
            jp.popola((String)jtListaInsegn.getValueAt(riga, 0),
                    (String)jtListaInsegn.getValueAt(riga, 1),
                    jtListaInsegn.getValueAt(riga, 2),
                    jtListaInsegn.getValueAt(riga, 3));
            if (leggi)
                jp.abilita("Leggi");
            else {
                jp.abilita("Modifica");
            }
            jp.setVisible(true);                
        }//end if riga
    }
    
    /**Imposta il modello di dati per la tabella insegnamenti
     * 
     * @param modello DefaultTableModel
     */
    public void setModelListaInsegn(DefaultTableModel modello){
        jtListaInsegn.setModel(modello);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbModificaInsegn;
    private javax.swing.JButton jbNuovoInsegn;
    private javax.swing.JTable jtListaInsegn;
    // End of variables declaration//GEN-END:variables
}