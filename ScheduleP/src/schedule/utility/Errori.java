package schedule.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/** Gestione messaggi d'errore
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class Errori {
    
    /**Gestisce/visualizza l'eccezione ClassNotFoundException
     * 
     * @param cnfe ClassNotFoundException
     */
    public static void gestisciEccezione(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
        visualizza(cnfe.getMessage()); 
    }

    /**Gestisce/visualizza l'eccezione Exception
     * 
     * @param e Exception
     */
    public static void gestisciEccezione(Exception e) {
        e.printStackTrace();
        visualizza(e.getMessage()); 
    }
    
    /**Gestisce/visualizza l'eccezione NumberFormatException
     * 
     * @param nfe NumberFormatException
     */
    public static void gestisciEccezione(NumberFormatException nfe) {
        nfe.printStackTrace();
        visualizza("immettere un valore numerico e non una stringa"); 
    }
        
    /**Gestisce/visualizza l'eccezione SQLException
     * 
     * @param sqle SQLException
     */
    public static void gestisciEccezione(SQLException sqle) {
        boolean chiudi = false;
        sqle.printStackTrace();
        String messaggioErrore = sqle.toString();
        String primaparte = messaggioErrore.substring(0,32);
        System.out.println("1 "+primaparte);
        String messaggioDaVisualizzare = null;       
        if (primaparte.equalsIgnoreCase("com.mysql.jdbc.exceptions.jdbc4.")) {
            String secondaparte = messaggioErrore.substring(32);            
            if (secondaparte.substring(0,23).equalsIgnoreCase("CommunicationsException"))
                messaggioDaVisualizzare = "Errore di connessione al server";
            else if (secondaparte.substring(0,36).equalsIgnoreCase("MySQLNonTransientConnectionException")){
                messaggioDaVisualizzare ="L'applicazione sarà chiusa a causa di problemi col database";
                chiudi=true;
            } else if (secondaparte.substring(0,42).equalsIgnoreCase("MySQLIntegrityConstraintViolationException"))          
                messaggioDaVisualizzare = "Violazione Integrita' referenziale" ;
        } else if (primaparte.equalsIgnoreCase("com.mysql.jdbc.MysqlDataTruncati")) {
            String secondaparte = messaggioErrore.substring(36);
            System.out.println(secondaparte.substring(0,41));
            if (secondaparte.substring(0,41).equalsIgnoreCase("Data truncation: Data too long for column"))
                messaggioDaVisualizzare = "Dati in input troppo estesi";
        }
        visualizza(messaggioDaVisualizzare); 
        if (chiudi)
            System.exit(1);
    }
    
    /**Gestisce/visualizza l'eccezione IOException
     * 
     * @param ioe IOException
     */
    public static void gestisciEccezione(IOException ioe) {
        ioe.printStackTrace();
        visualizza(ioe.getMessage()); 
    }
    
    /**Gestisce/visualizza l'eccezione FileNotFoundException
     * 
     * @param fnfe FileNotFoundException
     */
    public static void gestisciEccezione(FileNotFoundException fnfe) {
        fnfe.printStackTrace();        
        String messaggioErrore = fnfe.getMessage();
        String percorso = System.getProperty("user.dir") + File.separator;        
        String primaparte = messaggioErrore.substring(percorso.length());        
        String messaggioDaVisualizzare = null;       
        if (primaparte.substring(0,19).equalsIgnoreCase("database.properties"))
            messaggioDaVisualizzare = "Manca il file di configurazione database nella root del progetto";
        else
            messaggioDaVisualizzare = messaggioErrore;
        visualizza(messaggioDaVisualizzare); 
    }
    
    /**Segnala/visualizza l'eccezione con un messaggio d'errore
     * 
     * @param messaggio
     */
    public static void segnalaEccezione(String messaggio){
        visualizza(messaggio);
    }
    
    private static void visualizza(String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio);
    }
    
}//end class
