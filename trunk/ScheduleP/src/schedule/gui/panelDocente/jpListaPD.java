package schedule.gui.panelDocente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import schedule.ProgrammaD;
import schedule.gui.DocenteJF;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Pannello/tabella lista programmi didattici
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class jpListaPD extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpListaPD
     * 
     */     
    public jpListaPD() {
        initComponents();
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jbNuovo = new javax.swing.JButton();
        jbModifica = new javax.swing.JButton();
        jbElimina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaPD = new javax.swing.JTable();
        jbDownload = new javax.swing.JButton();

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

        jtListaPD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListaPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaPDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaPD);

        jbDownload.setText("Download Modulo Consigliato");
        jbDownload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDownloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jbDownload))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jbNuovo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbModifica)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbElimina))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuovo)
                    .addComponent(jbModifica)
                    .addComponent(jbElimina))
                .addGap(3, 3, 3)
                .addComponent(jbDownload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbNuovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNuovoMouseClicked
        DocenteJF.getInstance().getPannello(jpSingoloPD.class.getName()).setVisible(true);
        ((jpSingoloPD)DocenteJF.getInstance().getPannello(jpSingoloPD.class.getName())).abilita("Nuovo");
}//GEN-LAST:event_jbNuovoMouseClicked

    private void jbModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaMouseClicked
        int riga = jtListaPD.getSelectedRow();
        if (riga>-1) {
            jpSingoloPD jpspd = ((jpSingoloPD)DocenteJF.getInstance().getPannello(jpSingoloPD.class.getName()));            
            jpspd.popola(jtListaPD.getValueAt(riga, 0).toString());
            jpspd.abilita("Modifica");
            jpspd.setVisible(true);
        }
    }//GEN-LAST:event_jbModificaMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        int riga=jtListaPD.getSelectedRow();
        if (riga>-1) {
            int conferma = Common.confermaDelete();
            if (conferma==0) {
                ProgrammaD pd = new ProgrammaD(jpSingoloPD.getHashID().get(jtListaPD.getValueAt(riga, 0)).toString());
                pd.elimina();
                setModelListaPD(pd.modelloListaPD(DocenteJF.getDocente()));
                DocenteJF.getInstance().getPannello(jpSingoloPD.class.getName()).setVisible(false);              
            }
        } else 
            Errori.segnalaEccezione("Selezionare rigo prima");
    }//GEN-LAST:event_jbEliminaMouseClicked

    private void jbDownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDownloadMouseClicked
        String nomefile = System.getProperty("user.dir") + File.separator + "modulo.txt";
        try {
            File file = new File(nomefile);    
            if (file.exists())
                file.delete();
            if (file.createNewFile()) {
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write(ProgrammaD.template());
                out.close();
                Errori.segnalaEccezione("file salvato in " + nomefile);
            } 
        } catch (IOException ioe) {
            Errori.gestisciEccezione(ioe);
        }       
    }//GEN-LAST:event_jbDownloadMouseClicked

    private void jtListaPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaPDMouseClicked
        int riga = jtListaPD.getSelectedRow();
        if (riga>-1) {
            jpSingoloPD jpspd = ((jpSingoloPD)DocenteJF.getInstance().getPannello(jpSingoloPD.class.getName()));                        
            jpspd.popola(jtListaPD.getValueAt(riga, 0));
            jpspd.abilita("Leggi");
            jpspd.setVisible(true);
        }
    }//GEN-LAST:event_jtListaPDMouseClicked

    /**Imposta il modello per la tabella listaPD
     * 
     * @param model
     */    
    public void setModelListaPD(DefaultTableModel model){
        jtListaPD.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDownload;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbModifica;
    private javax.swing.JButton jbNuovo;
    private javax.swing.JTable jtListaPD;
    // End of variables declaration//GEN-END:variables
    
}//end class