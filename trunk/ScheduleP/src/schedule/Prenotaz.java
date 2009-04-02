
package schedule;

import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;
import schedule.database.dbPrenotaz;
import schedule.utility.Common;

/** Progetto Schedule Prenota
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class Prenotaz {
    
    private Timestamp giorno;
    private int oraI;
    private int oraF;
    private String aula;
    private String doc;
    private String insegn;
    private String note;

    /**Costruttore vuoto
     * 
     */
    public Prenotaz() {}
    
    /**Costruttore prenotazione con tutti i parametri
     * 
     * @param giorno
     * @param oraI
     * @param oraF
     * @param aula
     * @param doc
     * @param insegn
     * @param note
     */
    public Prenotaz(Timestamp giorno, int oraI, int oraF, String aula, String doc, String insegn, String note) {
        this.giorno = giorno;
        this.oraI = oraI;
        this.oraF = oraF;
        this.aula = aula;
        this.doc = doc;
        this.insegn = insegn;
        this.note = note;
    }

    /**Costruttore per impostare i campi per l'eliminazione
     * 
     * @param giorno
     * @param oraI
     * @param oraF
     * @param aula
     */
    public Prenotaz(Timestamp giorno, int oraI, int oraF, String aula) {
        this.giorno = giorno;
        this.oraI = oraI;
        this.oraF = oraF;
        this.aula = aula;
    }
    
    
    /** Restituisce l'id aula o il nome aula
     * 
     * @return aula
     */
    public String getAula() {
        return aula;
    }

    /**imposta l'id o nome aula
     * 
     * @param aula
     */
    public void setAula(String aula) {
        this.aula = aula;
    }

    /**restituisce id o nome docente
     * 
     * @return docente
     */
    public String getDoc() {
        return doc;
    }

    /**imposta l'id o nome docente
     * 
     * @param doc
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }

    /**restituisce il giorno
     * 
     * @return giorno
     */
    public Timestamp getGiorno() {
        return giorno;
    }

    /**imposta il giorno
     * 
     * @param giorno
     */
    public void setGiorno(Timestamp giorno) {
        this.giorno = giorno;
    }

    /**restituisce l'id o nome insegnamento
     * 
     * @return insegnamento
     */
    public String getInsegn() {
        return insegn;
    }

    /**imposta id o nome insegnamento
     * 
     * @param insegn
     */    
    public void setInsegn(String insegn) {
        this.insegn = insegn;
    }

    /**restituisce la nota
     * 
     * @return nota
     */
    public String getNote() {
        return note;
    }

    /**imposta le note
     * 
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**restituisce l'ora di fine
     * 
     * @return ora fine
     */
    public int getOraF() {
        return oraF;
    }

    /**imposta l'ora di fine
     * 
     * @param oraF
     */
    public void setOraF(int oraF) {
        this.oraF = oraF;
    }

    /**restituisce l'ora di inizio
     * 
     * @return ora inizio
     */
    public int getOraI() {
        return oraI;
    }

    /**imposta l'ora di inizio
     * 
     * @param oraI
     */
    public void setOraI(int oraI) {
        this.oraI = oraI;
    }
    
    /**richiama la funzione di salvataggio nuova prenotazione del datamapper
     * 
     */
    public void salva(){
        dbPrenotaz dbp = new dbPrenotaz();
        dbp.salva(this);
    }
    
    /**Restituisce il modello di tabella per lista giorno
     * 
     * @param day giorno per il quale si vuole cercare
     * @return modello
     */
    public static DefaultTableModel modellolistaGiorno(Timestamp day){
        dbPrenotaz dbp = new dbPrenotaz();
        Object[][] righe = dbp.listaGiorno(day);
        String [] colonne = new String [] {"Ora inizio", "Ora fine", "Aula", "Docente"};
        
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {java.lang.Object.class, java.lang.Object.class, 
                java.lang.Object.class, java.lang.Object.class};
            boolean[] canEdit = new boolean [] {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return tabella;
    }
    
    /**verifica l'indisponibilita' di un'aula
     * 
     * @param ora1
     * @param ora2
     * @return booleano inerente la non disponibilita'
     */
    public boolean aulaIndisponibile(int ora1, int ora2){        
        dbPrenotaz dbp = new dbPrenotaz();
        int [][] matrice = dbp.orariAula(aula, giorno, ora1, ora2);        
        return Common.controllaOrari(matrice, oraI, oraF);
    }
    
    /**richiama la funzione di eliminazione del datamapper
     * 
     */
    public void elimina(){
        dbPrenotaz dbp = new dbPrenotaz();
        dbp.elimina(this);
    }
    
    /**richiama la funzione di ricerca singola prenotazione
     * 
     */
    public void singolo(){
        dbPrenotaz dbp = new dbPrenotaz();
        String[] appoggio =dbp.singolo(this);
        setAula(appoggio[0]);
        setInsegn(appoggio[1]);
        setNote(appoggio[2]);        
    }
    
    /**richiama la funzione di aggiornamento della singola prenotazione
     * 
     * @param old vecchia prenotazione
     */
    public void aggiorna(Prenotaz old){
        dbPrenotaz dbp = new dbPrenotaz();
        dbp.update(this,old);
    }
    
    /**Restituisce il modello tabella per la lista relativa a settimana o mese 
     * 
     * @param inizio giorno di inizio
     * @param fine giorno di fine
     * @return modello
     */
    public static DefaultTableModel modellolistaSettMesi(Timestamp inizio, Timestamp fine){
        dbPrenotaz dbp = new dbPrenotaz();
        Object[][] righe = dbp.listaSettMese(inizio, fine);
        String [] colonne = new String [] {"Giorno", "Ora inizio", "Ora fine", "Aula", "Docente"};
        
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {java.lang.Object.class, java.lang.Object.class, 
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
            boolean[] canEdit = new boolean [] {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return tabella;
    }

}// end class