package schedule.gui;

import java.awt.event.KeyEvent;
import schedule.Login;
import schedule.utility.Common;
import schedule.utility.Errori;

/** JFrame Login
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class LoginJF extends javax.swing.JFrame {
    
    /**Costruttore 
     * 
     */
    public LoginJF() {
        initComponents();
        setTitle("Login Schedule Prenota");
        Common.centraFrame(this);
    }
    
    //inizializza componenti
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jbOK = new javax.swing.JButton();
        jbPulisci = new javax.swing.JButton();
        jbChiudi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Benvenuto utente");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("immetti username e password per ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" l'autenticazione ed accesso al sistema");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jtxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtPasswordKeyPressed(evt);
            }
        });

        jbOK.setText("OK");
        jbOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbOKMouseClicked(evt);
            }
        });
        jbOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbOKKeyPressed(evt);
            }
        });

        jbPulisci.setText("Pulisci");
        jbPulisci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPulisciMouseClicked(evt);
            }
        });
        jbPulisci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbPulisciKeyPressed(evt);
            }
        });

        jbChiudi.setText("Chiudi");
        jbChiudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbChiudiMouseClicked(evt);
            }
        });
        jbChiudi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbChiudiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbPulisci)
                        .addGap(18, 18, 18)
                        .addComponent(jbChiudi))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbChiudi)
                    .addComponent(jbPulisci)
                    .addComponent(jbOK)))
        );

        pack();
    }//GEN-END:initComponents

    private void jbOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbOKMouseClicked
        bottoneOK();
    }//GEN-LAST:event_jbOKMouseClicked

    private void jbChiudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbChiudiMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jbChiudiMouseClicked

    private void jbPulisciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPulisciMouseClicked
        bottonePulisci();
}//GEN-LAST:event_jbPulisciMouseClicked

    private void jbOKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbOKKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //se il pulsante premuto = invio
            bottoneOK();
    }//GEN-LAST:event_jbOKKeyPressed

    private void jbPulisciKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbPulisciKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //se il pulsante premuto = invio
            bottonePulisci();
    }//GEN-LAST:event_jbPulisciKeyPressed

    private void jbChiudiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbChiudiKeyPressed
        System.exit(0);
    }//GEN-LAST:event_jbChiudiKeyPressed

    private void jtxtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) //se il pulsante premuto = invio
            bottoneOK();
    }//GEN-LAST:event_jtxtPasswordKeyPressed
    
    /**Programma principale da cui lanciare la GUI
     * 
     * @param args argomenti della riga di comando
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJF().setVisible(true);
            }
        });
    } //end main
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbChiudi;
    private javax.swing.JButton jbOK;
    private javax.swing.JButton jbPulisci;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
    
    private void bottoneOK(){        
        String utente = jtxtUsername.getText();
        String password = new String(jtxtPassword.getPassword());
        if ((!utente.equalsIgnoreCase("")) && (!password.equalsIgnoreCase(""))) {
            Login accesso = new Login(utente,password);                
            int errore=accesso.login();
            if (errore==0){
                if (utente.equalsIgnoreCase("admin")){
                    AdminJF.getInstance().setVisible(true);
                } else {
                    DocenteJF.getInstance(utente).setVisible(true);
                }
                this.setVisible(false);
            } else if (errore==1)
                Errori.segnalaEccezione("Utente e/o password sbagliata o utente non attivo");
        } else
            Errori.segnalaEccezione("Utente e/o password non immesso/a");            
    } //end bottoneOK
    
    //azioni associate al bottone pulisci
    private void bottonePulisci(){
        this.jtxtUsername.setText(null);
        this.jtxtPassword.setText(null);
        jtxtUsername.requestFocus();
    } //end bottonepulisci            
    
}// end class