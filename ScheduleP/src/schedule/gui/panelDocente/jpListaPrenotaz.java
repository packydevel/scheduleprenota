package schedule.gui.panelDocente;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import schedule.Docente;
import schedule.Prenotaz;
import schedule.StruttureD;
import schedule.gui.DocenteJF;
import schedule.utility.Common;
import schedule.utility.Errori;

public class jpListaPrenotaz extends javax.swing.JPanel {
    
    /** Crea/inizializza il pannello jpListaPrenotaz
     * 
     */
    public jpListaPrenotaz() {
        initComponents();        
        giorno = Common.giornoOdierno();
        jlDescrizione.setText(Common.dataStringa(giorno));
    }
    
    /**imposta il modello x la tabella lista prenotazioni
     * 
     * @param model
     */
    public void setModelListaPrenot(DefaultTableModel model){
        jtPrenotaz.setModel(model);
    }
    
    /**imposta il calendario
     * 
     * @param day giorno
     */
    public void setCalendario(String day){
        jlDescrizione.setText(day);        
        giorno = Common.stringaCalendar(day);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jbNuova = new javax.swing.JButton();
        jbElimina = new javax.swing.JButton();
        jbGiornoPrec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPrenotaz = new javax.swing.JTable();
        jbGiornoOdierno = new javax.swing.JButton();
        jbGiornoSucc = new javax.swing.JButton();
        jlDescrizione = new javax.swing.JLabel();
        jbSettimana = new javax.swing.JButton();
        jbMese = new javax.swing.JButton();
        jbSettimanaSucc = new javax.swing.JButton();
        jbMeseSucc = new javax.swing.JButton();

        jbNuova.setText("Nuova");
        jbNuova.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbNuovaMouseClicked(evt);
            }
        });

        jbElimina.setText("Elimina");
        jbElimina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEliminaMouseClicked(evt);
            }
        });

        jbGiornoPrec.setText("Giorno Precedente/i");
        jbGiornoPrec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbGiornoPrecMouseClicked(evt);
            }
        });

        jtPrenotaz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtPrenotaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPrenotazMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPrenotaz);

        jbGiornoOdierno.setText("Giorno Odierno");
        jbGiornoOdierno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbGiornoOdiernoMouseClicked(evt);
            }
        });

        jbGiornoSucc.setText("Giorno Successivo/i");
        jbGiornoSucc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbGiornoSuccMouseClicked(evt);
            }
        });

        jlDescrizione.setText("jLabel1");

        jbSettimana.setText("Settimana Corrente");
        jbSettimana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSettimanaMouseClicked(evt);
            }
        });

        jbMese.setText("Mese Corrente");
        jbMese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMeseMouseClicked(evt);
            }
        });

        jbSettimanaSucc.setText("Settimana Successiva");
        jbSettimanaSucc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSettimanaSuccMouseClicked(evt);
            }
        });

        jbMeseSucc.setText("Mese Successivo");
        jbMeseSucc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMeseSuccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuova)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbElimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDescrizione))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGiornoPrec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGiornoOdierno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGiornoSucc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSettimana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSettimanaSucc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbMese)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMeseSucc)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuova)
                    .addComponent(jbElimina)
                    .addComponent(jlDescrizione))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGiornoPrec)
                    .addComponent(jbGiornoOdierno)
                    .addComponent(jbGiornoSucc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSettimana)
                    .addComponent(jbSettimanaSucc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMese)
                    .addComponent(jbMeseSucc))
                .addGap(15, 15, 15))
        );
    }//GEN-END:initComponents

    private void jbNuovaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNuovaMouseClicked
        if (jbNuova.isEnabled()){            
            jpSingolaPrenotaz jpsp = (jpSingolaPrenotaz) DocenteJF.getInstance().getPannello(jpSingolaPrenotaz.class.getName());
            jpsp.pulisci();
            jpsp.stato("nuova");
            jpsp.setVisible(true);
        }
}//GEN-LAST:event_jbNuovaMouseClicked

    private void jbGiornoSuccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGiornoSuccMouseClicked
        if (jbGiornoSucc.isEnabled()){
            giorno.add(Calendar.DATE, 1);
            if (giorno.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
                giorno.add(Calendar.DATE, 1);
            popola(Common.calendarToTimestamp(giorno));                
        }
}//GEN-LAST:event_jbGiornoSuccMouseClicked

    private void jbGiornoOdiernoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGiornoOdiernoMouseClicked
        if (jbGiornoOdierno.isEnabled()){
            giorno =  Common.giornoOdierno();
            popola(Common.calendarToTimestamp(giorno));                
        }
    }//GEN-LAST:event_jbGiornoOdiernoMouseClicked

    private void jbGiornoPrecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGiornoPrecMouseClicked
        if (jbGiornoPrec.isEnabled()){
            GregorianCalendar temp = new GregorianCalendar();
            int diff = temp.get(Calendar.DAY_OF_YEAR) - giorno.get(Calendar.DAY_OF_YEAR);
            if ((temp.get(Calendar.YEAR) - giorno.get(Calendar.YEAR))!=0)
                diff+=365;
            if (diff<8){
                giorno.add(Calendar.DATE, -1);
                if (giorno.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
                    giorno.add(Calendar.DATE, -1);                                    
                popola(Common.calendarToTimestamp(giorno));                              
            } else
                Errori.segnalaEccezione("Non puoi andare indietro");
        }
    }//GEN-LAST:event_jbGiornoPrecMouseClicked

    private void jbEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminaMouseClicked
        if (jbElimina.isEnabled()){
            int riga = jtPrenotaz.getSelectedRow();
            if (riga>-1){
                int colonna = 0;
                GregorianCalendar gcGiorno = giorno;
                if (jtPrenotaz.getColumnCount()==5){
                    colonna++;
                    gcGiorno = Common.stringaCalendar(jtPrenotaz.getValueAt(riga, 0).toString());
                }
                if (gcGiorno.after(Common.giornoOdierno())){
                    Docente d = new Docente();                                        
                    String id_doc = d.cercaId(jtPrenotaz.getValueAt(riga, 3+colonna).toString());
                    if (id_doc.equalsIgnoreCase(DocenteJF.getDocente())){
                        if (Common.confermaDelete()==0){
                            int oraI = Integer.parseInt(jtPrenotaz.getValueAt(riga, 0+colonna).toString());
                            int oraF = Integer.parseInt(jtPrenotaz.getValueAt(riga, 1+colonna).toString());
                            StruttureD sd = new StruttureD();
                            String id_sd = sd.cercaId(jtPrenotaz.getValueAt(riga, 2+colonna).toString());
                            Timestamp tsGiorno = Common.calendarToTimestamp(gcGiorno);
                            Prenotaz p = new Prenotaz(tsGiorno, oraI, oraF, id_sd);
                            p.elimina();
                            if (jlDescrizione.getText().substring(0, 1).equalsIgnoreCase("g")){
                                setModelListaPrenot(Prenotaz.modellolistaSettMesi(inizio, fine));
                            } else
                                setModelListaPrenot(Prenotaz.modellolistaGiorno(tsGiorno));
                        }
                    } else 
                        Errori.segnalaEccezione("Non hai i permessi, in quanto non sei il creatore della prenotazione");
                } else
                    Errori.segnalaEccezione("Non puoi eliminare con una data minore o uguale all'odierna");            
            }
        }
}//GEN-LAST:event_jbEliminaMouseClicked

    private void jtPrenotazMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPrenotazMouseClicked
        int riga = jtPrenotaz.getSelectedRow();
            if (riga>-1){                
                int sposta = 0;
                String sGiorno = null;
                if (jtPrenotaz.getColumnName(0).equalsIgnoreCase("Giorno")){
                    sposta++;
                    sGiorno = jtPrenotaz.getValueAt(riga, 0).toString();
                } else
                    sGiorno = Common.dataStringa(giorno);
                int oraI = Integer.parseInt(jtPrenotaz.getValueAt(riga, sposta+0).toString());
                int oraF = Integer.parseInt(jtPrenotaz.getValueAt(riga, sposta+1).toString());
                StruttureD sd = new StruttureD();
                String id_sd = sd.cercaId(jtPrenotaz.getValueAt(riga, sposta+2).toString());
                Timestamp tGiorno = Common.calendarToTimestamp(Common.stringaCalendar(sGiorno));
                Prenotaz p = new Prenotaz(tGiorno, oraI, oraF, id_sd);
                p.singolo();
                p.setDoc(jtPrenotaz.getValueAt(riga, 3).toString());
                jpSingolaPrenotaz jpsp = (jpSingolaPrenotaz) DocenteJF.getInstance().getPannello(jpSingolaPrenotaz.class.getName());
                jpsp.popolaCampi(p);
                jpsp.stato("leggi");
                jpsp.setVisible(true);                
            }
    }//GEN-LAST:event_jtPrenotazMouseClicked

    private void jbSettimanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSettimanaMouseClicked
        if (jbSettimana.isEnabled()){
            GregorianCalendar calendar = Common.giornoOdierno();
            int diff = Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK);
            calendar.add(Calendar.DATE, diff);
            String begin = Common.dataStringa(calendar);
            inizio = Common.calendarToTimestamp(calendar);
            calendar.add(Calendar.DATE, 5);
            String end = Common.dataStringa(calendar);
            fine = Common.calendarToTimestamp(calendar);
            setModelListaPrenot(Prenotaz.modellolistaSettMesi(inizio, fine));
            jlDescrizione.setText("giorni dal " + begin + " al "+ end);
        }
    }//GEN-LAST:event_jbSettimanaMouseClicked

    private void jbMeseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMeseMouseClicked
        if (jbMese.isEnabled()){
            GregorianCalendar gcGiorno = Common.giornoOdierno();
            int anno = gcGiorno.get(Calendar.YEAR);
            int mese = gcGiorno.get(Calendar.MONTH)+1;
            int max = gcGiorno.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            String end = new String(max + "/" + mese + "/" + anno);
            fine = Common.calendarToTimestamp(Common.stringaCalendar(end));
            String begin = new String("1/" + mese + "/" + anno);
            inizio = Common.calendarToTimestamp(Common.stringaCalendar(begin));
            setModelListaPrenot(Prenotaz.modellolistaSettMesi(inizio, fine));
            jlDescrizione.setText("giorni dal " + begin + " al "+ end);
        }
    }//GEN-LAST:event_jbMeseMouseClicked

    private void jbSettimanaSuccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSettimanaSuccMouseClicked
        if (jbSettimana.isEnabled()){
            GregorianCalendar calendar = Common.giornoOdierno();
            int diff = Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK);
            calendar.add(Calendar.DATE, 7+diff);
            String begin = Common.dataStringa(calendar);
            inizio = Common.calendarToTimestamp(calendar);
            calendar.add(Calendar.DATE, 5);
            String end = Common.dataStringa(calendar);
            fine = Common.calendarToTimestamp(calendar);
            setModelListaPrenot(Prenotaz.modellolistaSettMesi(inizio, fine));
            jlDescrizione.setText("giorni dal " + begin + " al "+ end);
        }
}//GEN-LAST:event_jbSettimanaSuccMouseClicked

    private void jbMeseSuccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMeseSuccMouseClicked
        if (jbMese.isEnabled()){
            GregorianCalendar gcGiorno = Common.giornoOdierno();
            gcGiorno.add(Calendar.MONTH, 1);
            int anno = gcGiorno.get(Calendar.YEAR);
            int mese = gcGiorno.get(Calendar.MONTH)+1;
            int max = gcGiorno.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            String end = new String(max + "/" + mese + "/" + anno);
            fine = Common.calendarToTimestamp(Common.stringaCalendar(end));
            String begin = new String("1/" + mese + "/" + anno);
            inizio = Common.calendarToTimestamp(Common.stringaCalendar(begin));
            setModelListaPrenot(Prenotaz.modellolistaSettMesi(inizio, fine));
            jlDescrizione.setText("giorni dal " + begin + " al "+ end);
        }
}//GEN-LAST:event_jbMeseSuccMouseClicked
       
    private void popola(Timestamp day){        
        jlDescrizione.setText(Common.dataStringa(Common.timestampToCalendar(day)));
        setModelListaPrenot(Prenotaz.modellolistaGiorno(day));
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbElimina;
    private javax.swing.JButton jbGiornoOdierno;
    private javax.swing.JButton jbGiornoPrec;
    private javax.swing.JButton jbGiornoSucc;
    private javax.swing.JButton jbMese;
    private javax.swing.JButton jbMeseSucc;
    private javax.swing.JButton jbNuova;
    private javax.swing.JButton jbSettimana;
    private javax.swing.JButton jbSettimanaSucc;
    private javax.swing.JLabel jlDescrizione;
    private javax.swing.JTable jtPrenotaz;
    // End of variables declaration//GEN-END:variables
    private GregorianCalendar giorno;
    private Timestamp inizio;
    private Timestamp fine;
}