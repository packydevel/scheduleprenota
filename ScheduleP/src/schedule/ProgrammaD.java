package schedule;

import javax.swing.table.DefaultTableModel;
import schedule.database.dbProgrammaD;

/** Programma didattico
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class ProgrammaD {
    private String id_insegn;
    private String testo;

    /**Costruttore con un parametro
     * 
     * @param id_ins id insegnamento
     */    
    public ProgrammaD(String id_ins) {
        this.id_insegn = id_ins;
    }    
    
    /**Costruttore con tutti i parametri
     * 
     * @param id_ins id insegnamento
     * @param testo testo del programma
     */    
    public ProgrammaD(String id_ins, String testo) {
        this.id_insegn = id_ins;
        this.testo = testo;
    }    
    
    /**Restituisce l'id insegnamento
     * 
     * @return id docente
     */
    public String getId_insegn() {
        return id_insegn;
    }

    /**imposta l'id insegnamento
     * 
     * @param id_ins
     */
    public void setId_ins(String id_ins) {
        this.id_insegn = id_ins;
    }

    /**restituisce il testo del programma didattico
     * 
     * @return testo
     */
    public String getTesto() {
        return testo;
    }

    /**imposta il testo del programma didattico
     * 
     * @param testo
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }
    
    /**restituisce il modello/lista dei programmi didattici per la tabella
     * 
     * @param id_doc id del docente
     * @return tabella
     */
    public static DefaultTableModel modelloListaPD(String id_doc) {
        dbProgrammaD pd = new dbProgrammaD();
        Object [][] righe = pd.listaProgrammi(id_doc);
        String [] colonne = new String [] {"Insegnamenti"};
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {java.lang.String.class};
            boolean[] canEdit = new boolean [] {false};

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
        dbProgrammaD dbpd = new dbProgrammaD();
        dbpd.inserisci(this);
    }
    
    /**richiama la funzione aggiorna del datamapper
     * 
     */
    public void aggiorna(){
        dbProgrammaD dbpd = new dbProgrammaD();
        dbpd.aggiorna(this);
    }
    
    /**richiama la funzione elimina del datamapper
     * 
     */
    public void elimina(){
        dbProgrammaD dbpd = new dbProgrammaD();
        dbpd.delete(this);
    }
    
    /**imposta il singolo programma didattico
     * 
     */
    public void singolo(){
        dbProgrammaD dbpd = new dbProgrammaD();
        testo = dbpd.testo(id_insegn);
    }
    
    /**restituisce il template consigliato del programma didattico
     * 
     * @return template
     */
    public static String template(){
        String template = "CORSO DI LAUREA IN:\r\n";
        template +="PROGRAMMA DELL'INSEGNAMENTO DI:\r\n";
        template +="DOCENTE:\r\n";
        template +="Nr. ORE LEZIONI FRONTALI:     Nr. CREDITI:\r\n";
        template +="Nr. ORE ESERCITAZIONI:        Nr. CREDITI:\r\n";
        template +="Nr. ORE LABORATORIO:          Nr. CREDITI:\r\n";
        template +="Nr. ORE STUDIO INDIVIDUALE:\r\n";
        template +="TOTALE CREDITI:\r\n";
        template +="PRE-REQUISITI:\r\n";
        template +="OBIETTIVI FORMATIVI:\r\n";
        template +="CONTENUTO:\r\n";
        template +="TESTO/I ADOTTATO/I:\r\n";
        template +="TESTO/I CONSIGLIATO/I:\r\n";
        template +="PROPEDEUTICITÀ OBBLIGATORIE:\r\n";
        template +="PROPEDEUTICITÀ CONSIGLIATE:\r\n";
        template +="PROVA SCRITTA (si/no):\r\n";
        template +="COLLOQUIO ORALE (si/no):\r\n";
        template +="PROVA DI LABORATORIO (si/no):\r\n";
        template +="PROVE DI ESONERO PARZIALE(si/no):\r\n";
        template +="NUMERO PROVE ESONERO(si/no):\r\n";
        template +="MODALITA' PROVE DI ESONERO (specificare se Prova scritta,Prova laboratorio, Colloquio orale, Altro):\r\n";
        template +="ANNO DI CORSO:\r\n";
        template +="SEMESTRE:\r\n";
        template +="DATA INIZIO LEZIONI:\r\n";
        template +="DATA FINE LEZIONI:";
        return template;
    }
} //end class
