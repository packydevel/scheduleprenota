package schedule.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import schedule.gui.panelAdmin.*;

/** JFrame Amministratore
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class AdminJF extends javax.swing.JFrame {
    
    //Costruttore Singleton
    private AdminJF(){
        initComponents();
    }
    
    /**restituisce l'istanza corrente (jframe) di adminjf
     * 
     * @return jframe
     */
    public static AdminJF getInstance() {
        if (jframe==null)
            jframe = new AdminJF();
        return jframe;
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jtpAdmin = new javax.swing.JTabbedPane();
        jpDocente = new javax.swing.JPanel();
        jpStruttureD = new javax.swing.JPanel();
        jpInsegnamenti = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpDocente.setLayout(new java.awt.GridLayout(1, 0));
        jplistadoc = new jpListaDocenti();
        jplistadoc.setModelListaDocenti(schedule.Docente.modelloListaDocCompleta());
        jpDocente.add(jplistadoc);
        jpsingolodoc = new jpSingoloDocente();
        jpDocente.add(jpsingolodoc);
        jtpAdmin.addTab("Docenti", jpDocente);

        jpStruttureD.setLayout(new java.awt.GridLayout(1, 0));
        jplistasd = new jpListaSD();
        jpStruttureD.add(jplistasd);

        jpsingolasd = new jpSingolaSD();
        jpStruttureD.add(jpsingolasd);
        jtpAdmin.addTab("Strutture Didattiche", jpStruttureD);

        jpInsegnamenti.setLayout(new java.awt.GridLayout(1, 0));
        jplistainsegn = new jpListaInsegnamenti();
        jpInsegnamenti.add(jplistainsegn);

        jpsingoloinsegn = new jpSingoloInsegnamento();
        jpInsegnamenti.add(jpsingoloinsegn);
        jtpAdmin.addTab("Insegnamenti", jpInsegnamenti);

        jMenu1.setText("Disconnetti");
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
            .addComponent(jtpAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        // Registra l'ascolto di un cambio di pannello
        jtpAdmin.addChangeListener(new ChangeListener() {
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
        jframe=null;
        new LoginJF().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked
                                   
    private void caricaTabella(int numerotab){
        if (numerotab==0) 
            jplistadoc.setModelListaDocenti(schedule.Docente.modelloListaDocCompleta());                                    
        else if (numerotab==1)
            jplistasd.setModelListaSD(schedule.StruttureD.modelloListaSD());
        else if (numerotab==2){
            jplistainsegn.setModelListaInsegn(schedule.Insegnamenti.modelloListaIns());
            jpSingoloInsegnamento jp = (jpSingoloInsegnamento) AdminJF.getInstance().getPannello(jpSingoloInsegnamento.class.getName());
            schedule.Docente doc = new schedule.Docente();
            jp.setComboModel(doc.elencoDoc());        
            jp.setHash(doc.getHashMap());
        }
    }        
    
    /**restituisce il pannello corrispondente alla stringa in input
     * 
     * @param pannello
     * @return jpanel
     */
    public JPanel getPannello(String pannello){
        JPanel jp = null;
        if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpListaDocenti"))
            jp = jplistadoc;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpSingoloDocente"))
            jp = jpsingolodoc;
        else if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpListaSD"))
            jp =  jplistasd;        
        else if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpSingolaSD"))
            jp =  jpsingolasd;        
        else if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpListaInsegnamenti"))
            jp =  jplistainsegn;        
        else if (pannello.equalsIgnoreCase("schedule.gui.panelAdmin.jpSingoloInsegnamento"))
            jp =  jpsingoloinsegn;        
        return jp;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jpDocente;
    private javax.swing.JPanel jpInsegnamenti;
    private javax.swing.JPanel jpStruttureD;
    private javax.swing.JTabbedPane jtpAdmin;
    // End of variables declaration//GEN-END:variables
    
    private jpListaDocenti jplistadoc;
    private jpSingoloDocente jpsingolodoc;
    private jpListaSD jplistasd;
    private jpSingolaSD jpsingolasd;
    private jpListaInsegnamenti jplistainsegn;
    private jpSingoloInsegnamento jpsingoloinsegn;
    private static AdminJF jframe;    
} // end class