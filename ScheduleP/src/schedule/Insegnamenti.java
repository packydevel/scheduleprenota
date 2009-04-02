package schedule;

import java.util.LinkedHashMap;
import javax.swing.table.DefaultTableModel;
import schedule.database.dbInsegnamenti;

/** Insegnamenti
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class Insegnamenti {

    private String id;
    private String nome;
    private String annoAcc;
    private String id_docente;
    private LinkedHashMap hash;   

    /**Costruttore senza parametri
     * 
     */
    public Insegnamenti() {}
    
    /**Costruttore con quattro parametri
     * 
     * @param id id insegnamento
     * @param nome nome insegnamento 
     * @param annoAcc anno accademico
     * @param doc id docente associato
     */
    public Insegnamenti(String id, String nome, String annoAcc, String doc) {
        this.id = id;
        this.nome = nome;
        this.annoAcc = annoAcc;
        this.id_docente = doc;
    }

    /**Costruttore con id
     * 
     * @param id id insegnamento
     */
    public Insegnamenti(String id) {
        this.id = id;
    }        

    /**Restituisce l'anno accademico
     * 
     * @return annoAcc
     */
    public String getAnnoAcc() {
        return annoAcc;
    }

    /**imposta l'anno accademico
     * 
     * @param annoAcc
     */
    public void setAnnoAcc(String annoAcc) {
        this.annoAcc = annoAcc;
    }

    /**restituisce l'id insegnamento
     * 
     * @return id
     */
    public String getId() {
        return id;
    }

    /**imposta l'id insegnamento
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**restituisce il nome insegnamento
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**imposta il nome insegnamento
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**restituisce l'id docente
     * 
     * @return id_docente
     */
    public String getId_docente() {
        return id_docente;
    }

    /**imposta l'id docente
     * 
     * @param id_docente
     */
    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }
    
    /**Restituisce la LinkedHashMap nome-id
     * 
     * @return LinkedHashMap
     */
    public LinkedHashMap getHash() {
        return hash;
    }
    
    /**richiama il metodo di inserimento del datamapper
     * 
     */
    public void inserisci() {
        dbInsegnamenti ins = new dbInsegnamenti();
        ins.inserisci(this);
    }        
    
    /**richiama il metodo di aggiornamento del datamapper
     * 
     */
    public void aggiorna(){
        dbInsegnamenti ins = new dbInsegnamenti();
        ins.aggiorna(this);
    }
    
    /**restituisce il modello per la jtable della lista degli insegnamenti
     * 
     * @return tabella
     */
    public static DefaultTableModel modelloListaIns() {            
        dbInsegnamenti ins = new dbInsegnamenti();
        Object [][] righe = ins.listaInsegnamenti();
        String [] colonne = new String [] {"Id","Nome","Anno Accad","Docente"};
        DefaultTableModel tabella = new DefaultTableModel(righe,colonne) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
    } //end modello lista insegnamenti 
    
    /**restituisce un array di K nomi della LinkedHashMap
     * 
     * @param doc
     * @return Object[]
     */
    public Object[] hashNomi(String doc){
        Object[] array = null;
        dbInsegnamenti dbi = new dbInsegnamenti();
        hash = dbi.LinkedHashMap(doc);
        if (hash!=null)
            array = hash.keySet().toArray();
        else
            array = new Object[] {null};
        return array;
    }
    
    /**rihiama la funzione di eliminazione dal datamapper
     * 
     */
    public void elimina() {
        dbInsegnamenti ins = new dbInsegnamenti();
        ins.elimina(id);
    }    
    
}//end class