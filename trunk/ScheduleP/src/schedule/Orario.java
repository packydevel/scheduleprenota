package schedule;

import javax.swing.table.DefaultTableModel;
import schedule.database.dbOrario;
import schedule.utility.Common;

/** Orario Ricevimento
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class Orario {
    private String giorno;
    private int oraDa;
    private int oraA;
    private static String id_doc;
    
    /**Costruttore con tutti i parametri
     * 
     * @param id id docente
     * @param giorno
     * @param oraDa 
     * @param oraA
     */
    public Orario(String id, String giorno, int oraDa, int oraA) {
        id_doc = id;
        this.giorno = giorno;
        this.oraDa = oraDa;
        this.oraA = oraA;
    }
       
    /**restituisce il giorno
     * 
     * @return giorno
     */
    public String getGiorno() {
        return giorno;
    }

    /**imposta il giorno
     * 
     * @param giorno
     */
    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    /**restituisce l'id docente
     * 
     * @return id_doc
     */
    public String getId_doc() {
        return id_doc;
    }

    /**imposta l'id docente
     * 
     * @param id_doc
     */
    public void setId_doc(String id_doc) {
        this.id_doc = id_doc;
    }

    /**restituisce l'ora di fine
     * 
     * @return oraA
     */
    public int getOraA() {
        return oraA;
    }
    
    /**imposta l'ora di fine
     * 
     * @param oraA
     */
    public void setOraA(int oraA) {
        this.oraA = oraA;
    }

    /**restituisce l'ora di inizio
     * 
     * @return oraDa
     */
    public int getOraDa() {
        return oraDa;
    }

    /**imposta l'ora di inizio
     * 
     * @param oraDa
     */
    public void setOraDa(int oraDa) {
        this.oraDa = oraDa;
    }
    
    /**restituisce il modello/lista orari per la tabella 
     * 
     * @param id id del docente
     * @return modello tabella
     */
    public static DefaultTableModel modelloListaOrari(String id) {
        dbOrario ora = new dbOrario();
        id_doc = id;
        Object [][] righe = ora.listaOrari(id_doc);
        String [] colonne = new String [] {"Giorno", "Ora", "Ora"};
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return tabella;
    }

    /**richiama la funzione inserisci del datamapper
     * 
     */
    public void inserisci(){
        dbOrario dbo = new dbOrario();
        dbo.inserisci(this);
    }
    
    /**richiama la funzione aggiorna del datamapper
     * 
     * @param old vecchio orario 
     */
    public void aggiorna(Orario old){
        dbOrario dbo = new dbOrario();
        dbo.aggiorna(this,old);
    }
    
    /**richiama la funzione elimina del datamapper
     * 
     */
    public void elimina(){
        dbOrario dbo = new dbOrario();
        dbo.delete(this);
    }
    
    /**controllo di coerenza degli orari
     * @param iniz orario di inizio da escludere, 0 x niente
     * @param fine orario di fine da escludere, 0 x niente
     * @return true se l'orario che si vuole immettere non e' corretto
     */
    public boolean controlla(int iniz, int fine){
        dbOrario dbo = new dbOrario();
        int [][] orari = dbo.orari(id_doc, giorno, iniz, fine);
        return Common.controllaOrari(orari, oraDa, oraA);        
    }
} //end class
