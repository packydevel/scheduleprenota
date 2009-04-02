package schedule;

import schedule.database.dbLogin;
import schedule.utility.DesEncrypter;

/** Gestisce l'accesso da parte degli utenti al sistema tramite login
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class Login {
    private String utente;
    private String password;
    private boolean abilitazione;

    /**Costruttore con parametro id utente
     * 
     * @param utente
     */
    public Login(String utente) {
        this.utente = utente;
    }
    
    /**Costruttore con parametri id utente e password associata
     * 
     * @param tUtente
     * @param tPass
     */
    public Login(String tUtente, String tPass) {
        this.setUtente(tUtente);
        DesEncrypter des = new DesEncrypter("schedule");
        this.setPassword(des.cripta(tPass));
    }

    /**Restituisce la password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    } //end 
    
    /**imposta la password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    } //end 

    /**Restituisce l'id utente
     * 
     * @return String utente
     */
    public String getUtente() {
        return utente;
    } //end 
    
    /**imposta l'id utente
     * 
     * @param utente
     */ 
    public void setUtente(String utente) {
        this.utente = utente;
    } //end 
    
    /**Restituisce l'abilitazione dell'utente per l'uso del sistema
     * 
     * @return boolean abilitazione
     */
    public boolean isAbilitazione() {
        return abilitazione;
    } //end 
    
    /**imposta l'abilitazione dell'id utente
     * 
     * @param abilitazione
     */
    public void setAbilitazione(boolean abilitazione) {
        this.abilitazione = abilitazione;
    } //end set   
    
    /**controlla l'esistenza di un utente con la relativa password
     * 
     * @return valore se l'utente esiste con quella pass
     */    
    public int login() {
        dbLogin logon = new dbLogin();        
        return logon.verificaUtente(utente, password);
    }//end login
    
    /**richiama il metodo inserimento dati del datamapper
     * 
     * @return codice d'errore -1 se c'e' errore sql
     */
    public int inserisci() {
        dbLogin logon = new dbLogin();
        return logon.inserisci(utente, password);
    }
    
    /**richiama il metodo che effettua l'aggiornamento della password dal datamapper
     * 
     */
    public void aggiornaPwd() {
        dbLogin logon = new dbLogin();
        logon.aggiornaPwd(utente, password);
    }
    
    /**richiama il metodo abilita utente del datamapper
     * 
     */    
    public void abilita() {
        dbLogin logon = new dbLogin();
        logon.abilitaUtente(utente);        
    }
    
    /**richiama il metodo disabilita utente del datamapper
     * 
     */
    public void disabilita() {
        dbLogin logon = new dbLogin();
        logon.disabilitaUtente(utente);        
    }
    
    /**Elimina il docente
     * 
     */
    public void elimina() {
        dbLogin logon = new dbLogin();
        logon.elimina(utente);
    }
    
} // end class
