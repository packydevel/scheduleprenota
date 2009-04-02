package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import schedule.Docente;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Docente
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbDocente {
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbDocente(){
        conn = dbConnessione.getConnection();
    }
    
    private Connection conn;
    
    /**Inserisci Nuovo docente
     * 
     * @param doc classe docente
     * @return successo, true se salva, false se c'è errore
     */
    public boolean inserisciDocente(Docente doc) {        
        boolean successo=true;
        String sql = "INSERT INTO docente VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, doc.getUtente(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, doc.getCognome(), Types.VARCHAR);
            Common.setParametri(prpstmt, 3, doc.getNome(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 4, doc.getIndirizzo(), Types.VARCHAR);
            Common.setParametri(prpstmt, 5, doc.getCitta(), Types.VARCHAR);
            Common.setParametri(prpstmt, 6, doc.getTelUfficio(), Types.VARCHAR);
            Common.setParametri(prpstmt, 7, doc.getTelCasa(), Types.VARCHAR);
            Common.setParametri(prpstmt, 8, doc.getCellulare(), Types.VARCHAR);
            Common.setParametri(prpstmt, 9, doc.getDataNascita(), Types.VARCHAR);
            Common.setParametri(prpstmt, 10, doc.getLuogoNascita(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 11, doc.getEmail(), Types.VARCHAR);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            successo=false;
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            successo=false;
            Errori.gestisciEccezione(e);
        }
        return successo;
    }//end inserisciDocente
    
    /**Restituisce una matrice di oggetti per la lista docenti
     * 
     * @return contenitore
     */
    public Object[][] listaDocentiCompleta(){
        Object [][] contenitore=null;
        String sql1 = "SELECT COUNT(*) ";
        sql1 += "FROM docente d, login l WHERE l.utente=d.utente;";
        String sql2 = "SELECT d.utente, d.cognome, d.nome, l.abilitazione ";
        sql2 += "FROM docente d, login l WHERE l.utente=d.utente ORDER BY l.utente;";        
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][4];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
                System.out.println(prpstmt2.toString());            
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getObject(1);
                    contenitore[riga][1]=rs2.getObject(2);
                    contenitore[riga][2]=rs2.getObject(3);
                    contenitore[riga][3]=rs2.getObject(4);
                }
            } 
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    }//end listaDocenti    

    /**Restituisce una lista docenti ridotta sotto LinkedHashMap
     * 
     * @return contenitore
     */
    public LinkedHashMap mappaDocentiRidotta(){
        LinkedHashMap contenitore=new LinkedHashMap();
        try{                                                
            String sql2 = "SELECT concat(cognome, ' ', nome) as nomecompleto, d.utente ";
            sql2 += "FROM docente d, login l WHERE l.utente=d.utente AND l.abilitazione= 1 ";
            sql2 += "ORDER BY l.utente;";        
            PreparedStatement prpstmt2 = conn.prepareStatement(sql2);                            
            System.out.println(prpstmt2.toString());            
            ResultSet rs2 = prpstmt2.executeQuery();
            while (rs2.next())
                contenitore.put(rs2.getString(1), rs2.getString(2));                   
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    }//end listaDocentiRidotta

    /**restituisce i dati del singolo docente
     * 
     * @param utente
     * @return docente
     */
    public Docente singolo(String utente){
        String sql = "SELECT * FROM docente WHERE utente=?;";
        Docente doc = null;
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, utente, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            ResultSet rs = prpstmt.executeQuery();
            while (rs.next())
                doc = new schedule.Docente(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
        } catch (SQLException sqle) {                        
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return doc;
    } //end singolo
    
    /**aggiorna i dati di un docente
     * 
     * @param doc
     */
    public void update(Docente doc){
        String sql = "UPDATE docente SET cognome=?, nome=?, indirizzo=?, citta=?, telefono_U=?, ";
        sql+= "telefono_C=?, cellulare=?, data_nascita=?, luogo_nascita=?, email=? ";
        sql+= "WHERE utente=?;";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, doc.getCognome(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, doc.getNome(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 3, doc.getIndirizzo(), Types.VARCHAR);
            Common.setParametri(prpstmt, 4, doc.getCitta(), Types.VARCHAR);
            Common.setParametri(prpstmt, 5, doc.getTelUfficio(), Types.VARCHAR);
            Common.setParametri(prpstmt, 6, doc.getTelCasa(), Types.VARCHAR);
            Common.setParametri(prpstmt, 7, doc.getCellulare(), Types.VARCHAR);
            Common.setParametri(prpstmt, 8, doc.getDataNascita(), Types.VARCHAR);
            Common.setParametri(prpstmt, 9, doc.getLuogoNascita(), Types.VARCHAR);
            Common.setParametri(prpstmt, 10, doc.getEmail(), Types.VARCHAR);
            Common.setParametri(prpstmt, 11, doc.getUtente(), Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }//end updateDocente
    
    /**Cerca l'id del docente
     * 
     * @param nome dev'essere cognome + spazio + iniziale nome
     * @return id
     */
    public String cercaID(String nome){
        String sql = "SELECT utente FROM docente WHERE CONCAT(cognome, ' ', LEFT(nome,1))=?;";
        String id = null;
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, nome, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            ResultSet rs = prpstmt.executeQuery();
            while (rs.next())
                id = rs.getString(1);
        } catch (SQLException sqle) {                        
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return id;
    }
    
    /**Elimina il docente dal database
     * 
     * @param utente id docente
     */
    public void elimina(String utente) {
        String sql = "DELETE FROM docente WHERE utente=?;";
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, utente, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {                        
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }        
    }

}//end class