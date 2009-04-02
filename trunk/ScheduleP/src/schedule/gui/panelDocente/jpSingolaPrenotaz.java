package schedule.gui.panelDocente;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import schedule.Docente;
import schedule.Insegnamenti;
import schedule.Prenotaz;
import schedule.StruttureD;
import schedule.gui.DocenteJF;
import schedule.utility.Common;
import schedule.utility.Errori;

public class jpSingolaPrenotaz extends javax.swing.JPanel {
    
    /** Crea/inizializza il pannello jpSingolaPrenotaz */
    public jpSingolaPrenotaz() {
        initComponents();
        setVisible(false);
        Insegnamenti ins = new Insegnamenti();
        Object[] nomiIns= ins.hashNomi(DocenteJF.getDocente());
        StruttureD sd = new StruttureD();
        Object[] nomiSd= sd.hashNomi();
        if (nomiSd!=null){
            jcbAula.setModel(new javax.swing.DefaultComboBoxModel(nomiSd));
            hmAula = sd.getHash();
        }
        if (nomiIns!=null){
            jcbInsegnam.setModel(new javax.swing.DefaultComboBoxModel(nomiIns));        
            hmInsegn = ins.getHash();
        }
    }
    
    /**popola i campi con i dati della prenotazione
     * 
     * @param p PRenotaz
     */
    public void popolaCampi(Prenotaz p){
        jcbAula.setSelectedItem(p.getAula());   
        jcbGiorno.setSelectedItem(Common.dataStringa(Common.timestampToCalendar(p.getGiorno())));
        jcbInsegnam.setSelectedItem(p.getInsegn());
        jcbOraFine.setSelectedItem(String.valueOf(p.getOraF()));
        jcbOraInizio.setSelectedItem(String.valueOf(p.getOraI()));
        jtxtNote.setText(p.getNote());
        oldPrenot = p;
    }
    
    /**pulisci i campi
     * 
     */
    public void pulisci(){
        jcbAula.setSelectedItem(null);
        jcbGiorno.setSelectedItem(null);
        jcbInsegnam.setSelectedItem(null);
        jcbOraFine.setSelectedItem(null);
        jcbOraInizio.setSelectedItem(null);
        jtxtNote.setText(null);
    }
    
    /**esegue delle operazioni di abilita/disabilita in base allo stato ricevuto
     * 
     * @param stato "leggi" "nuova" "modifica"
     */
    public void stato(String stato){
        if (stato.equalsIgnoreCase("leggi")){
            abilitaCombo(false);
            jbModifica.setEnabled(true);
            jbPulisci.setEnabled(false);
            jbSalva.setEnabled(false);
            jbUpdate.setEnabled(false);
        } else if (stato.equalsIgnoreCase("nuova")){
            abilitaCombo(true);
            jbModifica.setEnabled(false);
            jbPulisci.setEnabled(true);
            jbSalva.setEnabled(true);
            jbUpdate.setEnabled(false);
        } else if (stato.equalsIgnoreCase("modifica")){
            abilitaCombo(true);
            jbModifica.setEnabled(false);
            jbPulisci.setEnabled(true);
            jbSalva.setEnabled(false);
            jbUpdate.setEnabled(true);
        }         
    }    
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbGiorno = new javax.swing.JComboBox();
        jcbOraInizio = new javax.swing.JComboBox();
        jcbOraFine = new javax.swing.JComboBox();
        jcbAula = new javax.swing.JComboBox();
        jcbInsegnam = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtNote = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jbSalva = new javax.swing.JButton();
        jbPulisci = new javax.swing.JButton();
        jbChiudi = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbModifica = new javax.swing.JButton();

        jLabel1.setText("Giorno *");

        jLabel2.setText("Ora inizio *");

        jLabel3.setText("Ora fine *");

        jLabel4.setText("Aula *");

        jLabel5.setText("Insegnamento *");

        jLabel6.setText("Note");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jcbGiorno.setModel(new javax.swing.DefaultComboBoxModel(generaGiorni()));

        jcbOraInizio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {null, "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));

        jcbOraFine.setModel(new javax.swing.DefaultComboBoxModel(new String[] {null,"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jcbAula.setModel(new javax.swing.DefaultComboBoxModel());

        jcbInsegnam.setModel(new javax.swing.DefaultComboBoxModel());

        jtxtNote.setColumns(20);
        jtxtNote.setRows(5);
        jScrollPane1.setViewportView(jtxtNote);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbOraInizio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbOraFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbInsegnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jcbGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOraInizio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOraFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbInsegnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        jbModifica.setText("Modifica");
        jbModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbModifica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbUpdate))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPulisci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbChiudi)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalva)
                    .addComponent(jbPulisci)
                    .addComponent(jbChiudi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModifica)
                    .addComponent(jbUpdate))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jbChiudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiMouseClicked
        setVisible(false);
    }//GEN-LAST:event_jbChiudiMouseClicked

    private void jbSalvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvaMouseClicked
        if (jbSalva.isEnabled()){                                    
            Object giorno = jcbGiorno.getSelectedItem();
            Object ora1 = jcbOraInizio.getSelectedItem();
            Object ora2 = jcbOraFine.getSelectedItem();
            Object aula = jcbAula.getSelectedItem();            
            Object insegn = jcbInsegnam.getSelectedItem();
            if ((giorno!=null) && (ora1!=null) && (ora2!=null) && (aula!=null) && (insegn!=null)){
                int orai=0;
                int oraf=0;
                try {
                    orai=Integer.parseInt(ora1.toString());
                    oraf=Integer.parseInt(ora2.toString());
                }catch (NumberFormatException nfe) {
                    Errori.gestisciEccezione(nfe);
                }
                if (oraf>orai){                    
                    Timestamp day = Common.calendarToTimestamp(Common.stringaCalendar(giorno.toString()));
                    Prenotaz p = new Prenotaz(day, orai, oraf, hmAula.get(aula).toString(),
                            DocenteJF.getDocente(),hmInsegn.get(insegn).toString(),jtxtNote.getText());
                    if (!p.aulaIndisponibile(0,0)) {
                        p.salva();
                        jpListaPrenotaz jp = ((jpListaPrenotaz)DocenteJF.getInstance().getPannello(jpListaPrenotaz.class.getName()));
                        jp.setModelListaPrenot(Prenotaz.modellolistaGiorno(day));
                        jp.setCalendario(Common.dataStringa(Common.timestampToCalendar(day)));
                        setVisible(false);
                    } else
                        Errori.segnalaEccezione("controllare gli orari che si vogliono immettere per l'aula e il giorno di riferimento");
                } else
                    Errori.segnalaEccezione("L'ora di fine dev'essere maggiore dell'ora di inizio");
            } else 
                Errori.segnalaEccezione("Si prega di completare i campi");
        }            
    }//GEN-LAST:event_jbSalvaMouseClicked

    private void jbPulisciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciMouseClicked
        if (jbPulisci.isEnabled()){
            pulisci();
        }            
    }//GEN-LAST:event_jbPulisciMouseClicked

    private void jbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUpdateMouseClicked
        if (jbUpdate.isEnabled()){
            Object giorno = jcbGiorno.getSelectedItem();
            Object ora1 = jcbOraInizio.getSelectedItem();
            Object ora2 = jcbOraFine.getSelectedItem();
            Object aula = jcbAula.getSelectedItem();
            Object insegn = jcbInsegnam.getSelectedItem();
            if ((giorno!=null) && (ora1!=null) && (ora2!=null) && (aula!=null) && (insegn!=null)){
                int orai=0;
                int oraf=0;
                try {
                    orai=Integer.parseInt(ora1.toString());
                    oraf=Integer.parseInt(ora2.toString());
                }catch (NumberFormatException nfe) {
                    Errori.gestisciEccezione(nfe);
                }
                if (oraf>orai){                    
                    Timestamp day = Common.calendarToTimestamp(Common.stringaCalendar(giorno.toString()));
                    Prenotaz p = new Prenotaz(day, orai, oraf, hmAula.get(aula).toString(),
                            DocenteJF.getDocente(),hmInsegn.get(insegn).toString(),jtxtNote.getText());
                    if (!p.aulaIndisponibile(oldPrenot.getOraI(), oldPrenot.getOraF())) {
                        StruttureD sd = new StruttureD();
                        String id = sd.cercaId(oldPrenot.getAula());
                        oldPrenot.setAula(id);
                        p.aggiorna(oldPrenot);
                        jpListaPrenotaz jp = ((jpListaPrenotaz)DocenteJF.getInstance().getPannello(jpListaPrenotaz.class.getName()));
                        jp.setModelListaPrenot(Prenotaz.modellolistaGiorno(day));
                        jp.setCalendario(Common.dataStringa(Common.timestampToCalendar(day)));
                        setVisible(false);
                    } else
                        Errori.segnalaEccezione("controllare gli orari che si vogliono immettere per l'aula e il giorno di riferimento");
                } else
                    Errori.segnalaEccezione("L'ora di fine dev'essere maggiore dell'ora di inizio");
            } else 
                Errori.segnalaEccezione("Si prega di completare i campi");
        }                                
    }//GEN-LAST:event_jbUpdateMouseClicked

    private void jbModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificaMouseClicked
        if (jbModifica.isEnabled()){                       
            GregorianCalendar giorno = Common.stringaCalendar(jcbGiorno.getSelectedItem().toString());
            if (giorno.after(Common.giornoOdierno())){
                Docente d = new Docente();
                String id_doc = d.cercaId(oldPrenot.getDoc());
                if (id_doc.equalsIgnoreCase(DocenteJF.getDocente())){
                    stato("modifica");
                } else 
                    Errori.segnalaEccezione("Non hai i permessi, in quanto non sei il creatore della prenotazione");
            } else
                Errori.segnalaEccezione("Non puoi modificare una prenotazione con una data minore o uguale all'odierna");                        
        }        
    }//GEN-LAST:event_jbModificaMouseClicked
           
    private Object[] generaGiorni(){
        GregorianCalendar cal = new GregorianCalendar();
        ArrayList al = new ArrayList();
        al.add(null);
        for (int i=0; i<65; i++){
            cal.add(Calendar.DATE, 1);
            if (cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY)
                al.add(Common.dataStringa(cal));
        }
        return al.toArray();
    }    
    
    private void abilitaCombo(boolean stato){
        jcbAula.setEnabled(stato);
        jcbGiorno.setEnabled(stato);
        jcbInsegnam.setEnabled(stato);
        jcbOraFine.setEnabled(stato);
        jcbOraInizio.setEnabled(stato);
        jtxtNote.setEnabled(stato);
    }        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbChiudi;
    private javax.swing.JButton jbModifica;
    private javax.swing.JButton jbPulisci;
    private javax.swing.JButton jbSalva;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbAula;
    private javax.swing.JComboBox jcbGiorno;
    private javax.swing.JComboBox jcbInsegnam;
    private javax.swing.JComboBox jcbOraFine;
    private javax.swing.JComboBox jcbOraInizio;
    private javax.swing.JTextArea jtxtNote;
    // End of variables declaration//GEN-END:variables
    private LinkedHashMap hmAula;
    private LinkedHashMap hmInsegn;
    private Prenotaz oldPrenot;
}