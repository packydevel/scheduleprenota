package schedule.gui.panelDocente;

import schedule.Orario;
import schedule.gui.DocenteJF;
import schedule.utility.Errori;

/** Pannello inserimento/modifica singolo orario ricevimento
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class jpSingoloOrario extends javax.swing.JPanel {
    
    /** Creat/inizializza jpanel jpSingoloOrario */
    public jpSingoloOrario() {
        initComponents();
        setVisible(false);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jbSalva = new javax.swing.JButton();
        jbPulisci = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbChiudi = new javax.swing.JButton();
        jcbOraFine = new javax.swing.JComboBox();
        jcbOraInizio = new javax.swing.JComboBox();
        jcbGiorno = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jbUpdate.setText("Salva Modifiche");
        jbUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUpdateMouseClicked(evt);
            }
        });

        jbChiudi.setText("Chiudi");
        jbChiudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiMouseClicked(evt);
            }
        });

        jcbOraFine.setModel(new javax.swing.DefaultComboBoxModel(new String[] {null,"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jcbOraInizio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {null, "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));

        jcbGiorno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { null, "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato" }));

        jLabel1.setText("Giorno *");

        jLabel2.setText("Ora da *");

        jLabel3.setText("Ora a *");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbChiudi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPulisci))
                    .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcbOraInizio, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(jcbOraFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jcbGiorno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbOraInizio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbOraFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalva)
                    .addComponent(jbPulisci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbChiudi)
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jbSalvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaMouseClicked
        if (jbSalva.isEnabled()) {
            Object oraI = jcbOraInizio.getSelectedItem();
            Object oraF = jcbOraFine.getSelectedItem();            
            Object day = jcbGiorno.getSelectedItem();
            if ((day!=null) && (oraF!=null) && (oraI!=null)) {
                int ora1 = Integer.parseInt(oraI.toString());
                int ora2 = Integer.parseInt(oraF.toString());
                if (ora1<ora2){
                    Orario o = new Orario(DocenteJF.getDocente(),day.toString(),ora1,ora2);
                    if (!o.controlla(0,0)) {
                        o.inserisci();
                        ((jpListaOrari)DocenteJF.getInstance().getPannello(jpListaOrari.class.getName())).
                            setModelListaOrari(Orario.modelloListaOrari(DocenteJF.getDocente()));
                        setVisible(false);
                    }else
                    Errori.segnalaEccezione("Correggere gli orari immessi");                    
                } else
                    Errori.segnalaEccezione("Correggere gli orari immessi");
            } else 
                Errori.segnalaEccezione("si prega di completare/correggere i campi");
        }            
}//GEN-LAST:event_jbSalvaMouseClicked

    private void jbPulisciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciMouseClicked
        pulisci();
    }//GEN-LAST:event_jbPulisciMouseClicked

    private void jbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseClicked
        if (jbUpdate.isEnabled()){
            Object oraI = jcbOraInizio.getSelectedItem();
            Object oraF = jcbOraFine.getSelectedItem();            
            Object day = jcbGiorno.getSelectedItem();
            if ((day!=null) && (oraF!=null) && (oraI!=null)) {
                int ora1 = Integer.parseInt(oraI.toString());
                int ora2 = Integer.parseInt(oraF.toString());
                if (ora1<ora2){
                    Orario nuovo = new Orario(DocenteJF.getDocente(),day.toString(),ora1,ora2);
                    if (!nuovo.controlla(oldOra.getOraDa(),oldOra.getOraA())){
                        nuovo.aggiorna(oldOra);
                        ((jpListaOrari)DocenteJF.getInstance().getPannello(jpListaOrari.class.getName())).
                            setModelListaOrari(Orario.modelloListaOrari(DocenteJF.getDocente()));
                        setVisible(false);
                    } else
                        Errori.segnalaEccezione("Correggere gli orari immessi");
                } else
                    Errori.segnalaEccezione("Correggere gli orari immessi");
            } else 
                Errori.segnalaEccezione("si prega di completare/correggere i campi");
        }
    }//GEN-LAST:event_jbUpdateMouseClicked

    private void jbChiudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiMouseClicked
        setVisible(false);
    }//GEN-LAST:event_jbChiudiMouseClicked
    
    /**abilita/disabilita azioni/bottoni a seconda del valore in input
     * 
     * @param abilita Nuovo/Modifica
     */
    public void abilita(String abilita){
        if (abilita.equalsIgnoreCase("Nuovo")) {
            pulisci();
            jbSalva.setEnabled(true);
            jbUpdate.setEnabled(false);
            
        } else if (abilita.equalsIgnoreCase("Modifica")) {            
            jbSalva.setEnabled(false);
            jbUpdate.setEnabled(true);
        }
    }
    
    private void pulisci(){
        jcbGiorno.setSelectedItem(null);
        jcbOraFine.setSelectedItem(null);
        jcbOraFine.setSelectedItem(null);
    }
    
    /**popola i campi
     * 
     * @param g
     * @param o1
     * @param o2
     */
    public void popola(Object g, Object o1, Object o2){
        jcbGiorno.setSelectedItem(g);
        jcbOraInizio.setSelectedItem(o1);
        jcbOraFine.setSelectedItem(o2);
        oldOra = new Orario(DocenteJF.getDocente(),g.toString(),Integer.parseInt(o1.toString()),
                    Integer.parseInt(o2.toString()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbChiudi;
    private javax.swing.JButton jbPulisci;
    private javax.swing.JButton jbSalva;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbGiorno;
    private javax.swing.JComboBox jcbOraFine;
    private javax.swing.JComboBox jcbOraInizio;
    // End of variables declaration//GEN-END:variables
    private Orario oldOra;
}
