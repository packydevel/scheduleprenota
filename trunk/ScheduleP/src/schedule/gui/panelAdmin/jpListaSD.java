package schedule.gui.panelAdmin;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import schedule.StruttureD;
import schedule.gui.AdminJF;
import schedule.utility.Common;

/** Pannello&tabella lista strutture didattiche
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpListaSD extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpListaSD */
    public jpListaSD() {
        initComponents();
        setVisible(true);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaSD = new javax.swing.JTable();
        jbModifica = new javax.swing.JButton();
        jbElimina = new javax.swing.JButton();

        jButton1.setText("Nuova"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jtListaSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaSDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListaSD);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModifica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbElimina))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbModifica)
                    .addComponent(jbElimina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JPanel jp = AdminJF.getInstance().getPannello(jpSingolaSD.class.getName());
        ((jpSingolaSD)jp).abilita("Nuova");
        jp.setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jtListaSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaSDMouseClicked
        int riga=jtListaSD.getSelectedRow();
        if (riga>-1) {
            schedule.StruttureD sd = new schedule.StruttureD(jtListaSD.getValueAt(riga, 0).toString());
            sd.datiStruttura();
            jpSingolaSD jpnsd = (jpSingolaSD) AdminJF.getInstance().getPannello(jpSingolaSD.class.getName());
            jpnsd.pulisciTipo();
            jpnsd.abilita("Leggi");
            jpnsd.popolaSD(sd);
            jpnsd.setVisible(true);            
        }
    }//GEN-LAST:event_jtListaSDMouseClicked

    private void jbModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaMouseClicked
        int riga=jtListaSD.getSelectedRow();
        if (riga>-1) {            
            schedule.StruttureD sd = new schedule.StruttureD(jtListaSD.getValueAt(riga, 0).toString());
            sd.datiStruttura();             
            jpSingolaSD jpnsd = (jpSingolaSD) AdminJF.getInstance().getPannello(jpSingolaSD.class.getName());
            jpnsd.abilita("Modifica");
            jpnsd.popolaSD(sd);
            jpnsd.setVisible(true);            
        }
}//GEN-LAST:event_jbModificaMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        if (jbElimina.isEnabled()){
            int riga=jtListaSD.getSelectedRow();
            if (riga>-1) {
                if (Common.confermaDelete()==0){
                    String idSD = jtListaSD.getValueAt(riga, 0).toString();
                    StruttureD sd = new StruttureD(idSD);
                    sd.eliminaStruttura();
                    AdminJF.getInstance().getPannello(jpSingoloDocente.class.getName()).setVisible(false);
                    setModelListaSD(schedule.StruttureD.modelloListaSD());
                }
            }
        }
    }//GEN-LAST:event_jbEliminaMouseClicked
    
    /**imposta il modello per la tabella listaSD
     * 
     * @param modello
     */
    public void setModelListaSD(DefaultTableModel modello){
        jtListaSD.setModel(modello);        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbModifica;
    private javax.swing.JTable jtListaSD;
    // End of variables declaration//GEN-END:variables

    /*public JTable getJtListaSD() {
        return jtListaSD;
    }*/
    
} //end class
