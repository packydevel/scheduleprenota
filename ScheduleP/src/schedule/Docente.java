package schedule;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.table.DefaultTableModel;
import schedule.database.dbDocente;
import schedule.utility.ArrayListComboBoxModel;

/** Docente
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class Docente {
    private String cognome;
    private String nome;
    private String utente;
    private String indirizzo;
    private String citta;
    private String telUfficio;
    private String telCasa;
    private String cellulare;
    private String dataNascita;
    private String luogoNascita;
    private String email;
    private LinkedHashMap hash; 
        
    /**Costruttore docente vuoto
     * 
     */
    public Docente() { }
    
    /**Costruttore Docente con id utente
     * 
     * @param utente id utente
     */
    public Docente(String utente) {
        this.utente = utente;
    }
    
    /**Costruttore docente con i tre parametri obbligatori
     * 
     * @param utente id utente
     * @param cognome cognome docente
     * @param nome nome docente
     */
    public Docente(String utente, String cognome, String nome) {
        this.utente = utente;
        this.cognome = cognome;
        this.nome = nome;       
    }
    
    /**Costruttore Docente con tutti i parametri
     * 
     * Crea un oggetto docente con tutti i parametri
     * 
     * @param utente id docente
     * @param cognome cognome
     * @param nome nome
     * @param indirizzo indirizzo residenza
     * @param citta citta' residenza
     * @param telUfficio telefono ufficio
     * @param telCasa telefono casa
     * @param cellulare cellulare
     * @param dataNascita datadi nascita
     * @param luogoNascita luogo di nascita
     * @param eMail email
     */
    public Docente(String utente, String cognome, String nome, String indirizzo, 
            String citta, String telUfficio, String telCasa, String cellulare, 
            String dataNascita, String luogoNascita, String eMail) {
        this.cognome = cognome;
        this.nome = nome;
        this.utente = utente;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.telUfficio = telUfficio;
        this.telCasa = telCasa;
        this.cellulare = cellulare;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.email = eMail;
    }

    /**restituisce la stringa cellulare
     * 
     * @return cellulare 
     */
    public String getCellulare() {
        return cellulare;
    }
    
    /**imposta la stringa cellulare
     * 
     * @param cellulare cellulare
     */
    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
    
    /**restituisce la stringa citta
     * 
     * @return citta
     */
    public String getCitta() {
        return citta;
    }
    
    /** imposta la stringa citta
     * 
     * @param citta citta
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**restituisce la strnga data di nascita
     * 
     * @return dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /** imposta la data di nascita
     * 
     * @param dataNascita data di nascita
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**restituisce l'indirizzo
     * 
     * @return indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }
    
    /**imposta l'indirizzo
     * 
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**restituisce il luogo di nascita
     * 
     * @return luogoNascita
     */
    public String getLuogoNascita() {
        return luogoNascita;
    }

    /**imposta il luogo di nascita
     * 
     * @param luogoNascita
     */
    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    /**restituisce il telefono di casa
     * 
     * @return telCasa
     */
    public String getTelCasa() {
        return telCasa;
    }

    /**imposta il telefono di casa
     * 
     * @param telCasa
     */
    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    /**restituisce il telefono d'ufficio
     * 
     * @return telUfficio
     */
    public String getTelUfficio() {
        return telUfficio;
    }
    
    /**imposta il telefono d'ufficio
     * 
     * @param telUfficio
     */
    public void setTelUfficio(String telUfficio) {
        this.telUfficio = telUfficio;
    }    
    
    /**restituisce l'id docente/utente
     * 
     * @return utente
     */
    public String getUtente() {
        return utente;
    }

    /**imposta l'id utente/docente
     * 
     * @param utente
     */
    public void setUtente(String utente) {
        this.utente = utente;
    }

    /**restituisce il cognome
     * 
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**imposta il cognome
     * 
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**restituisce il nome
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**imposta il nome
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**Restituisce la stringa email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**imposta l'email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**Restituisce la LinkedHashMap relativa alla coppia di valori docente (cognome nome, id)
     * 
     * @return hash
     */
    public LinkedHashMap getHashMap(){
        return hash;
    }
    
    /**richiama la funzione di inserimento docente del datamapper
     * 
     * @return booleano se salva oppure no 
     */
    public boolean inserisciDocente(){
        dbDocente doc = new dbDocente();
        return doc.inserisciDocente(this);
    }     
    
    /**richiama la funzione di ricerca per i dati di un singolo docente e imposta l'oggetto con i dati trovati
     * 
     */
    public void datidocente() {
        dbDocente doc = new dbDocente();
        setDoc(doc.singolo(utente));        
    }
    
    /**Richiama la funzione che crea l'elenco dei docenti, e lo trasforma restituendolo sotto forma di DefaultTableModel
     * cioe' un modello di default per una visualizzazione tabellare
     * 
     * @return tabella
     */
    public static DefaultTableModel modelloListaDocCompleta() {
        dbDocente doc = new dbDocente();
        Object [][] righe = doc.listaDocentiCompleta();
        String [] colonne = new String [] {"Utente", "Cognome", "Nome", "Abilitato"};
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return tabella;
    }
    
    /**richiama una lista ridotta dei docenti e la trasforma in un modello per la combolist
     * 
     * @return modello
     */
    public schedule.utility.ArrayListComboBoxModel elencoDoc(){
        dbDocente doc = new dbDocente();
        hash = doc.mappaDocentiRidotta();
        ArrayListComboBoxModel modello = new ArrayListComboBoxModel(new ArrayList(hash.keySet()));   
        return modello;        
    }
    
    /**richiama la funzione di aggiornamento dati docente del datamapper
     * 
     */
    public void aggiornaDoc(){
        dbDocente doc = new dbDocente();
        doc.update(this);
    }
    
    /**Restituisce l'id docente tramite ricerca
     * 
     * @param nome
     * @return id docente
     */
    public String cercaId(String nome){
        dbDocente dbd = new dbDocente();
        return dbd.cercaID(nome);
    }
    
    //imposta tutti i valori del docente corrente da un docente d'appoggio
    private void setDoc(Docente doc){
        this.cognome = doc.getCognome();
        this.nome = doc.getNome();
        this.indirizzo = doc.getIndirizzo();
        this.citta = doc.getCitta();
        this.telUfficio = doc.getTelUfficio();
        this.telCasa = doc.getTelCasa();
        this.cellulare = doc.getCellulare();
        this.dataNascita = doc.getDataNascita();
        this.luogoNascita = doc.getLuogoNascita();
        this.email = doc.getEmail();
    } //end setDoc
    
    /**richiama la funzione di eliminazione docente
     * 
     */
    public void elimina() {
        dbDocente dbdoc = new dbDocente();
        dbdoc.elimina(utente);
    }
    
}//end class