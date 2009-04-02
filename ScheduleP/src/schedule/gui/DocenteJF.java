package schedule.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import schedule.Orario;
import schedule.Prenotaz;
import schedule.ProgrammaD;
import schedule.gui.panelDocente.*;
import schedule.utility.Common;

/** JFrame Docente
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class DocenteJF extends javax.swing.JFrame {
    private jpListaOrari jplistaorari;
    private jpSingoloOrario jpsingoloora;
    private jpSingoloDocente jpsingolodoc;
    private jpListaPD jplistapd;
    private jpSingoloPD jpsingolopd;
    private jpListaPrenotaz jplistaprenotaz;
    private jpSingolaPrenotaz jpsingolaprenotaz;
    private static String docente;
    private static DocenteJF jframe;        
    
    //Costruttore Singleton
    private DocenteJF(String utente) {
        docente=utente;
        this.setTitle("Benvenuto "+docente);
        initComponents();
    }
    
    /**restituisce l'istanza docentejf
     * 
     * @return jframe
     */
    public static DocenteJF getInstance() {
        return jframe;
    }
    
    /**restituisce l'istanza docente jf con in input l'id docente
     * 
     * @param utente
     * @return jframe
     */
    public static DocenteJF getInstance(String utente) {
        if (jframe==null)
            jframe = new DocenteJF(utente);
        return jframe;
    }

    /**restituisce l'id docente corrente
     * 
     * @return docente
     */
    public static String getDocente() {
        return docente;
    }        
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jtpDocente = new javax.swing.JTabbedPane();
        jpDatiPers = new javax.swing.JPanel();
        jpOrarioRic = new javax.swing.JPanel();
        jpProgrammaDid = new javax.swing.JPanel();
        jpPrenotazioni = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpsingolodoc = new jpSingoloDocente();
        jpDatiPers.add(jpsingolodoc);
        jpDatiPers.setLayout(new java.awt.GridLayout(1, 0));
        jtpDocente.addTab("Dati personali", jpDatiPers);

        jplistaorari = new jpListaOrari();
        jpOrarioRic.add(jplistaorari);
        jpsingoloora = new jpSingoloOrario();
        jpOrarioRic.add(jpsingoloora);
        jpOrarioRic.setLayout(new java.awt.GridLayout(1, 0));
        jtpDocente.addTab("Orario Ricevimento", jpOrarioRic);

        jplistapd = new jpListaPD();
        jpProgrammaDid.add(jplistapd);
        jpsingolopd = new jpSingoloPD();
        jpProgrammaDid.add(jpsingolopd);
        jpProgrammaDid.setLayout(new java.awt.GridLayout(1, 0));
        jtpDocente.addTab("Programma Didattico", jpProgrammaDid);

        jpPrenotazioni.setLayout(new java.awt.GridLayout(1, 0));
        jplistaprenotaz = new jpListaPrenotaz();
        jpPrenotazioni.add(jplistaprenotaz);
        jpsingolaprenotaz = new jpSingolaPrenotaz();
        jpPrenotazioni.add(jpsingolaprenotaz);
        jtpDocente.addTab("Prenotazioni", jpPrenotazioni);

        jMenu1.setText("Disconnetti"); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        // Registra l'ascolto di un cambio di pannello
        jtpDocente.addChangeListener(new ChangeListener() {
            // questo metodo viene chiamato ogni qualvolta ci sia un cambio di tabpanel
            public void stateChanged(ChangeEvent evt) {
                JTabbedPane temp = (JTabbedPane)evt.getSource();
                caricaTabella(temp.getSelectedIndex());
            }
        });

        pack();
    }//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        this.setVisible(false);
        jframe = null;
        new LoginJF().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked
           
    /**restituisce il pannello corrispondente alla stringa in input
     * 
     * @param pannello
     * @return jpanel
     */
    public JPanel getPannello(String pannello){
        JPanel jp = null;
        if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpListaOrari"))
            jp = jplistaorari;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpSingoloOrario"))
            jp = jpsingoloora;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpListaPD"))
            jp = jplistapd;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpSingoloPD"))
            jp = jpsingolopd;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpListaPrenotaz"))
            jp = jplistaprenotaz;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelDocente.jpSingolaPrenotaz"))
            jp = jpsingolaprenotaz;
        return jp;
    }
    
    private void caricaTabella(int numerotab){
        if (numerotab==1) 
            jplistaorari.setModelListaOrari(Orario.modelloListaOrari(DocenteJF.getDocente()));
        else if (numerotab==2) 
            jplistapd.setModelListaPD(ProgrammaD.modelloListaPD(DocenteJF.getDocente()));
        else if (numerotab==3) 
            jplistaprenotaz.setModelListaPrenot(Prenotaz.modellolistaGiorno(Common.calendarToTimestamp(Common.giornoOdierno())));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenu jMenu1;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JPanel jpDatiPers;
    javax.swing.JPanel jpOrarioRic;
    javax.swing.JPanel jpPrenotazioni;
    javax.swing.JPanel jpProgrammaDid;
    javax.swing.JTabbedPane jtpDocente;
    // End of variables declaration//GEN-END:variables
} //end class