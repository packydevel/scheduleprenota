package schedule.gui.panelDocente;

import javax.swing.table.DefaultTableModel;
import schedule.Orario;
import schedule.gui.DocenteJF;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Pannello/tabella lista orari ricevimento
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpListaOrari extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpListaOrari 
     * 
     */     
    public jpListaOrari() {
        initComponents();
        setVisible(true);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaOrari = new javax.swing.JTable();
        jbNuovo = new javax.swing.JButton();
        jbModifica = new javax.swing.JButton();
        jbElimina = new javax.swing.JButton();

        jScrollPane1.setViewportView(jtListaOrari);

        jbNuovo.setText("Nuovo");
        jbNuovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNuovoMouseClicked(evt);
            }
        });

        jbModifica.setText("Modifica");
        jbModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificaMouseClicked(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModifica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbElimina)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuovo)
                    .addComponent(jbModifica)
                    .addComponent(jbElimina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbNuovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNuovoMouseClicked
        jpSingoloOrario jp = (jpSingoloOrario) DocenteJF.getInstance().getPannello(jpSingoloOrario.class.getName());
        jp.abilita("Nuovo");
        jp.setVisible(true);                
    }//GEN-LAST:event_jbNuovoMouseClicked

    private void jbModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaMouseClicked
        int riga=jtListaOrari.getSelectedRow();
        if (riga>-1) {
            jpSingoloOrario jp = (jpSingoloOrario) DocenteJF.getInstance().getPannello(jpSingoloOrario.class.getName());
            jp.popola(jtListaOrari.getValueAt(riga, 0),jtListaOrari.getValueAt(riga, 1),jtListaOrari.getValueAt(riga, 2));
            jp.abilita("Modifica");
            jp.setVisible(true);
        }
    }//GEN-LAST:event_jbModificaMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        int riga=jtListaOrari.getSelectedRow();
        if (riga>-1) {
            int conferma = Common.confermaDelete();
            if (conferma==0) {
                Orario o = new Orario(DocenteJF.getDocente(),jtListaOrari.getValueAt(riga, 0).toString(),
                    Integer.parseInt(jtListaOrari.getValueAt(riga, 1).toString()),
                    Integer.parseInt(jtListaOrari.getValueAt(riga, 2).toString()));
                o.elimina();
                setModelListaOrari(Orario.modelloListaOrari(DocenteJF.getDocente()));
            }
        } else 
            Errori.segnalaEccezione("Selezionare rigo prima");
    }//GEN-LAST:event_jbEliminaMouseClicked

    /**imposta il modello per la tabella lista orari
     * 
     * @param model
     */
    public void setModelListaOrari(DefaultTableModel model) {
        jtListaOrari.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbModifica;
    private javax.swing.JButton jbNuovo;
    private javax.swing.JTable jtListaOrari;
    // End of variables declaration//GEN-END:variables
    
}//end class