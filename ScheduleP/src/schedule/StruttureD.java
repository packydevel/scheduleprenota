package schedule;

import java.util.LinkedHashMap;
import javax.swing.table.DefaultTableModel;
import schedule.database.dbStruttureD;

/** Strutture didattiche
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class StruttureD {
    
    private String id;
    private String nome;
    private String ubicazione;
    private int posti;
    private int tipo;
    private LinkedHashMap hash;

    /**Costruttore vuoto
     * 
     */
    public StruttureD() {}

    /**costruttore con id struttura
     * 
     * @param id
     */
    public StruttureD(String id) {
        this.id = id;
    }
    
    /**costruttore con tutti i parametri
     * 
     * @param id id struttura
     * @param nome
     * @param ubicazione
     * @param posti numero posti
     * @param tipo aula/laboratorio
     */
    public StruttureD(String id, String nome, String ubicazione, int posti, int tipo) {
        this.id = id;
        this.nome = nome;
        this.ubicazione = ubicazione;
        this.posti = posti;
        this.tipo = tipo;
    }

    /**restituisci l'id struttura didattica
     * 
     * @return id
     */
    public String getId() {
        return id;
    }

    /**imposta l'id struttura didattica
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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

    /**restituisce il numero di posti
     * 
     * @return posti
     */
    public int getPosti() {
        return posti;
    }

    /**imposta il numero di posti
     * 
     * @param posti
     */    
    public void setPosti(int posti) {
        this.posti = posti;
    }

    /**restituisce il tipo aula/laboratorio
     * 
     * @return tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**imposta il tipo aula/laboratorio
     * 
     * @param tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }   

    /**restituisce l'ubicazione della struttura
     * 
     * @return ubicazione
     */
    public String getUbicazione() {
        return ubicazione;
    }

    /**imposta l'ubicazione della struttura
     * 
     * @param ubicazione
     */
    public void setUbicazione(String ubicazione) {
        this.ubicazione = ubicazione;
    }

    /**Restituisce la LinkedHashMap nome-id
     * 
     * @return LinkedHashMap
     */
    public LinkedHashMap getHash() {
        return hash;
    }        
    
    /**richiama la funzione inserisci del datamapper
     * 
     */
    public void inserisciStruttura() {
        dbStruttureD sd = new dbStruttureD();
        sd.inserisciStruttura(this);
    }           
    
    /**preleva i dati di una singola struttura
     * 
     */
    public void datiStruttura(){
        dbStruttureD sd = new dbStruttureD();
        StruttureD tempSD = sd.singolo(id);
        this.setNome(tempSD.getNome());
        this.setUbicazione(tempSD.getUbicazione());
        this.setPosti(tempSD.getPosti());
        this.setTipo(tempSD.getTipo());
    }
    
    /**richiama la funzione aggiorna del datamapper
     * 
     */
    public void aggiornaStruttura() {
        dbStruttureD sd = new dbStruttureD();
        sd.aggiorna(this);
    }
    
    /**richiama la funzione elimina del datamapper
     * 
     */
    public void eliminaStruttura() {
        dbStruttureD sd = new dbStruttureD();
        sd.elimina(this.getId());
    }
    
    /**restituisce il modello/lista strutture didattiche per la tabella
     * 
     * @return tabella
     */
    public static DefaultTableModel modelloListaSD(){
        dbStruttureD sd = new dbStruttureD();
        Object [][] righe = sd.listaStrutture();
        String [] colonne = new String [] {"ID", "Nome"};
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
    } //end modelloListaSD
    
    /**restituisce un array di K nomi dalla LinkedHashMap
     * 
     * @return Object[]
     */
    public Object[] hashNomi(){
        Object[] array=null;
        dbStruttureD dbsd = new dbStruttureD();
        hash = dbsd.LinkedHashMap();
        if (hash!=null)
            array = hash.keySet().toArray();
        return array;
    }
    
    /**Ricerca l'id della struttura
     * 
     * @param nome
     * @return id
     */
    public String cercaId(String nome){
        dbStruttureD dbsd = new dbStruttureD();
        return dbsd.cercaID(nome);
    }
}//end class