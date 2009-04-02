package schedule.gui.panelAdmin;

import javax.swing.table.DefaultTableModel;
import schedule.Docente;
import schedule.Login;
import schedule.gui.AdminJF;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Pannello&Tabella lista Docenti
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpListaDocenti extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpListaDocenti */
    public jpListaDocenti() {
        initComponents();
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jbNuovo = new javax.swing.JButton();
        jbDisabilita = new javax.swing.JButton();
        jbAbilita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoc = new javax.swing.JTable();
        jbElimina = new javax.swing.JButton();

        jbNuovo.setText("Nuovo"); // NOI18N
        jbNuovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNuovoMouseClicked(evt);
            }
        });

        jbDisabilita.setText("Disabilita"); // NOI18N
        jbDisabilita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDisabilitaMouseClicked(evt);
            }
        });

        jbAbilita.setText("Abilita"); // NOI18N
        jbAbilita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAbilitaMouseClicked(evt);
            }
        });

        jtListadoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoc);

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
                        .addComponent(jbNuovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDisabilita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAbilita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbElimina))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuovo)
                    .addComponent(jbDisabilita)
                    .addComponent(jbAbilita)
                    .addComponent(jbElimina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbNuovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNuovoMouseClicked
        jpSingoloDocente jp = (jpSingoloDocente)AdminJF.getInstance().getPannello(jpSingoloDocente.class.getName());
        jp.pulisciCampi();
        jp.setAbilita(true);
        jp.setAbilitaUP(true);
        jp.setAbilitaB(true);
        jp.setVisible(true);
        
    }//GEN-LAST:event_jbNuovoMouseClicked

    //disabilita il docente
    private void jbDisabilitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDisabilitaMouseClicked
        int riga=jtListadoc.getSelectedRow();
        if (riga>-1) {
            if (jtListadoc.getValueAt(riga, 3)==(Object)false)
                Errori.segnalaEccezione("non puoi disabilitare il docente");
            else {
                schedule.Login log = new schedule.Login(jtListadoc.getValueAt(riga, 0).toString());
                log.disabilita();
                jtListadoc.setModel(schedule.Docente.modelloListaDocCompleta());
            }
        }
    }//GEN-LAST:event_jbDisabilitaMouseClicked

    //abilita il docente
    private void jbAbilitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAbilitaMouseClicked
        int riga=jtListadoc.getSelectedRow();
        if (riga>-1) {
            if (jtListadoc.getValueAt(riga, 3)==(Object)true)
                Errori.segnalaEccezione("non puoi abilitare il docente");
            else {
                schedule.Login log = new schedule.Login(jtListadoc.getValueAt(riga, 0).toString());
                log.abilita();
                jtListadoc.setModel(schedule.Docente.modelloListaDocCompleta());
            }
        }
    }//GEN-LAST:event_jbAbilitaMouseClicked

    private void jtListadocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadocMouseClicked
        int riga=jtListadoc.getSelectedRow();
        if (riga>-1) {
            schedule.Docente doc = new schedule.Docente(jtListadoc.getValueAt(riga, 0).toString());
            doc.datidocente();                        
            jpSingoloDocente jp = ((jpSingoloDocente)AdminJF.getInstance().getPannello(jpSingoloDocente.class.getName()));                        
            jp.setLabel(doc);
            jp.setAbilita(false);
            jp.setAbilitaUP(false);
            jp.setAbilitaB(false);
            jp.setVisible(true);
        }
    }//GEN-LAST:event_jtListadocMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        if (jbElimina.isEnabled()){
            int riga=jtListadoc.getSelectedRow();
            if (riga>-1) {
                if (Common.confermaDelete()==0){
                    String utente = jtListadoc.getValueAt(riga, 0).toString();
                    Docente doc = new Docente(utente);
                    Login log = new Login(utente);
                    log.elimina();
                    doc.elimina();
                    AdminJF.getInstance().getPannello(jpSingoloDocente.class.getName()).setVisible(false);
                    jtListadoc.setModel(schedule.Docente.modelloListaDocCompleta());
                }
            }
        }
    }//GEN-LAST:event_jbEliminaMouseClicked
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAbilita;
    private javax.swing.JButton jbDisabilita;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbNuovo;
    private javax.swing.JTable jtListadoc;
    // End of variables declaration//GEN-END:variables
    
    /**imposta il modello e i dati per la tabella lista docentii
     * 
     * @param modello
     */
    public void setModelListaDocenti(DefaultTableModel modello){
        jtListadoc.setModel(modello);        
    }
    
}//end class
