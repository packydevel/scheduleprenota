package schedule.gui.panelAdmin;

import schedule.StruttureD;
import schedule.gui.AdminJF;
import schedule.utility.Errori;

/** Pannello singola struttura didattica per inserimento e modifica
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpSingolaSD extends javax.swing.JPanel {
    
    /** Crea/inizializza jpanel jpNuovaSD */
    public jpSingolaSD() {
        initComponents();
        setVisible(false);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel5 = new javax.swing.JLabel();
        jtxtID_s = new javax.swing.JTextField();
        jtxtNome_s = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtUbicazione = new javax.swing.JTextField();
        jtxtPosti = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jrbAula = new javax.swing.JRadioButton();
        jrbLaboratorio = new javax.swing.JRadioButton();
        jbChiudiNuovaSD = new javax.swing.JButton();
        jbPulisciNuovaSD = new javax.swing.JButton();
        jbSalvaSD = new javax.swing.JButton();
        jbUpdateSD = new javax.swing.JButton();

        jLabel5.setText("ID *"); // NOI18N

        jLabel9.setText("Nome *"); // NOI18N

        jLabel10.setText("Ubicazione *"); // NOI18N

        jLabel11.setText("Numero posti *"); // NOI18N

        jLabel12.setText("Tipo *"); // NOI18N

        jrbAula.setText("Aula"); // NOI18N
        jrbAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbAulaMouseClicked(evt);
            }
        });
        jrbAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrbAulaKeyPressed(evt);
            }
        });

        jrbLaboratorio.setText("Laboratorio"); // NOI18N
        jrbLaboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbLaboratorioMouseClicked(evt);
            }
        });
        jrbLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrbLaboratorioKeyPressed(evt);
            }
        });

        jbChiudiNuovaSD.setText("Chiudi"); // NOI18N
        jbChiudiNuovaSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiNuovaSDMouseClicked(evt);
            }
        });

        jbPulisciNuovaSD.setText("Pulisci"); // NOI18N
        jbPulisciNuovaSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPulisciNuovaSDMouseClicked(evt);
            }
        });

        jbSalvaSD.setText("Salva"); // NOI18N
        jbSalvaSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalvaSDMouseClicked(evt);
            }
        });

        jbUpdateSD.setText("Salva Modifiche"); // NOI18N
        jbUpdateSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateSDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbAula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbLaboratorio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtID_s, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jtxtNome_s, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jtxtUbicazione, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jtxtPosti, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbSalvaSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPulisciNuovaSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbChiudiNuovaSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdateSD)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtID_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtNome_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtUbicazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtPosti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jrbAula)
                    .addComponent(jrbLaboratorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvaSD)
                    .addComponent(jbPulisciNuovaSD)
                    .addComponent(jbChiudiNuovaSD)
                    .addComponent(jbUpdateSD))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jrbAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbAulaMouseClicked
        jrbLaboratorio.setSelected(false);
    }//GEN-LAST:event_jrbAulaMouseClicked

    private void jrbLaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbLaboratorioMouseClicked
        jrbAula.setSelected(false);
    }//GEN-LAST:event_jrbLaboratorioMouseClicked

    private void jbChiudiNuovaSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiNuovaSDMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jbChiudiNuovaSDMouseClicked

    private void jbPulisciNuovaSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciNuovaSDMouseClicked
        if (jbPulisciNuovaSD.isEnabled())
            pulisciNuovaSD();
    }//GEN-LAST:event_jbPulisciNuovaSDMouseClicked

    private void jbSalvaSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaSDMouseClicked
        if (jbSalvaSD.isEnabled()) {
            String id = jtxtID_s.getText();
            String nome = jtxtNome_s.getText();
            String ubicaz = jtxtUbicazione.getText();
            int tipo=-1;
            if (jrbAula.isSelected())
                tipo=1;
            else if (jrbLaboratorio.isSelected())
                tipo=0;
            
            Object numero = jtxtPosti.getText();
            if ((!id.equalsIgnoreCase("")) && (!nome.equalsIgnoreCase("")) && (!ubicaz.equalsIgnoreCase("")) &&
                        (!numero.equals("")) && (tipo>-1))  {
                int posti = 0;
                try {
                    posti = Integer.parseInt(numero.toString());
                    if (posti>0) {
                        schedule.StruttureD sd = new schedule.StruttureD(id,nome,ubicaz,posti,tipo);
                        sd.inserisciStruttura();
                        this.setVisible(false);
                        ((jpListaSD)AdminJF.getInstance().getPannello(jpListaSD.class.getName())).
                            setModelListaSD(schedule.StruttureD.modelloListaSD());
                    } else
                        Errori.segnalaEccezione("Si prega di compilare i campi");
                } catch(NumberFormatException nfe){
                    Errori.gestisciEccezione(nfe);
                }
            } else
                Errori.segnalaEccezione("Si prega di compilare i campi");
        }
    }//GEN-LAST:event_jbSalvaSDMouseClicked

    private void jbUpdateSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateSDMouseClicked
        if (jbUpdateSD.isEnabled()) {            
            String id = jtxtID_s.getText();
            String nome = jtxtNome_s.getText();
            String ubicaz = jtxtUbicazione.getText();
            int tipo=-1;
            if (jrbAula.isSelected())
                tipo=1;
            else if (jrbLaboratorio.isSelected())
                tipo=0;
            
            Object numero = jtxtPosti.getText();
            if ((!id.equalsIgnoreCase("")) && (!nome.equalsIgnoreCase("")) && (!ubicaz.equalsIgnoreCase("")) &&
                        (!numero.equals("")) && (tipo>-1))  {
                int posti = 0;
                try {
                    posti = Integer.parseInt(numero.toString());
                    if (posti>0) {
                    schedule.StruttureD sd = new schedule.StruttureD(id,nome,ubicaz,posti,tipo);
                    sd.aggiornaStruttura();
                    this.setVisible(false);
                    ((jpListaSD)AdminJF.getInstance().getPannello(jpListaSD.class.getName())).
                            setModelListaSD(schedule.StruttureD.modelloListaSD());
                } else
                        Errori.segnalaEccezione("Si prega di compilare i campi");
                } catch(NumberFormatException nfe){
                    Errori.gestisciEccezione(nfe);
                }
            } else
                Errori.segnalaEccezione("Si prega di compilare i campi");
        }
    }//GEN-LAST:event_jbUpdateSDMouseClicked

    private void jrbAulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrbAulaKeyPressed
        jrbLaboratorio.setSelected(false);
    }//GEN-LAST:event_jrbAulaKeyPressed

    private void jrbLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrbLaboratorioKeyPressed
        jrbAula.setSelected(false);
    }//GEN-LAST:event_jrbLaboratorioKeyPressed
    
    /**pulisci campi
     * 
     */
    public void pulisciNuovaSD(){
        if (jbSalvaSD.isEnabled())
            jtxtID_s.setText(null);
        jtxtNome_s.setText(null);
        jtxtPosti.setText(null);
        jtxtUbicazione.setText(null);
        jrbAula.setSelected(false);
        jrbLaboratorio.setSelected(false);
    }     
    
    /**abilita/disabilita oggetti
     * 
     * @param fase Nuova/Leggi/Modifica
     */
    public void abilita(String fase){
        if (fase.equalsIgnoreCase("Nuova")) {
            jtxtID_s.setEditable(true);
            abilitaCampi(true);
            jbSalvaSD.setEnabled(true);
            jbPulisciNuovaSD.setEnabled(true);
            jbUpdateSD.setEnabled(false);
            pulisciNuovaSD();                    
        } else if (fase.equalsIgnoreCase("Leggi")) {
            jtxtID_s.setEditable(false);
            abilitaCampi(false);
            jbSalvaSD.setEnabled(false);
            jbPulisciNuovaSD.setEnabled(false);
            jbUpdateSD.setEnabled(false);
        } else if (fase.equalsIgnoreCase("Modifica")) {
            jtxtID_s.setEditable(false);
            jbSalvaSD.setEnabled(false);
            abilitaCampi(true);            
            jbPulisciNuovaSD.setEnabled(true);
            jbUpdateSD.setEnabled(true);
        }
    }
    
    private void abilitaCampi(boolean abilita){        
        jtxtNome_s.setEditable(abilita);
        jtxtUbicazione.setEditable(abilita);
        jtxtPosti.setEditable(abilita);
        jrbAula.setEnabled(abilita);
        jrbLaboratorio.setEnabled(abilita);
    }
    
    /**popola campi
     * 
     * @param sd
     */
    public void popolaSD(StruttureD sd){
        jtxtID_s.setText(sd.getId());
        jtxtNome_s.setText(sd.getNome());
        jtxtUbicazione.setText(sd.getUbicazione());
        jtxtPosti.setText(String.valueOf(sd.getPosti()));
        if (sd.getTipo()==1)
            jrbAula.setSelected(true);
        else
            jrbLaboratorio.setSelected(true);
    }
    
    /**pulisci checkbox tipo struttura
     * 
     */
    public void pulisciTipo(){
        jrbAula.setSelected(false);
        jrbLaboratorio.setSelected(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbChiudiNuovaSD;
    private javax.swing.JButton jbPulisciNuovaSD;
    private javax.swing.JButton jbSalvaSD;
    private javax.swing.JButton jbUpdateSD;
    private javax.swing.JRadioButton jrbAula;
    private javax.swing.JRadioButton jrbLaboratorio;
    private javax.swing.JTextField jtxtID_s;
    private javax.swing.JTextField jtxtNome_s;
    private javax.swing.JTextField jtxtPosti;
    private javax.swing.JTextField jtxtUbicazione;
    // End of variables declaration//GEN-END:variables
    
}
