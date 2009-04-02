
package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import schedule.Insegnamenti;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Insegnamenti
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbInsegnamenti {
    private Connection conn;
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbInsegnamenti(){        
        conn = dbConnessione.getConnection();            
    }
    
    /**Inserisci Nuovo insegnamento
     * 
     * @param ins
     */
    public void inserisci(Insegnamenti ins) {
        String sql = "INSERT INTO insegnamenti (id, nome, anno,id_docente) VALUES (?,?,?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, ins.getId(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, ins.getNome(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 3, ins.getAnnoAcc(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 4, ins.getId_docente(), Types.VARCHAR);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }        
    }//end inserisciInsegnamento
    
    /**aggiorna i dati di un insegnamento
     * 
     * @param insegn
     */
    public void aggiorna(Insegnamenti insegn) {        
        String sql = "UPDATE insegnamenti SET nome= ?, anno=?, id_docente=? WHERE id = ?;";       
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, insegn.getNome(), Types.VARCHAR);                       
            Common.setParametri(prpstmt, 2, insegn.getAnnoAcc(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 3, insegn.getId_docente(), Types.VARCHAR); 
            Common.setParametri(prpstmt, 4, insegn.getId(), Types.VARCHAR); 
            prpstmt.execute();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }
    
    /**restituisce una matrice di oggetti contentente la lista insegnamenti
     * 
     * @return contenitore
     */
    public Object[][] listaInsegnamenti() {
        Object [][] contenitore;
        String sql1 = "SELECT COUNT(*) FROM insegnamenti;";
        String sql2 = "SELECT i.id, i.nome, i.anno, concat(d.cognome, ' ', d.nome) as nomecompleto ";        
        sql2+= "FROM insegnamenti i LEFT JOIN docente d ON i.id_docente = d.utente  ";
        sql2+= "ORDER BY i.nome, i.anno;";
        try{                        
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            //System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][4];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getObject(1);
                    contenitore[riga][1]=rs2.getObject(2);
                    contenitore[riga][2]=rs2.getObject(3);
                    contenitore[riga][3]=rs2.getObject(4);
                }
            } else
                contenitore = null; //endif numeroR
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
            return null;
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
            return null;
        }
        return contenitore;
    }//end listaInsegnamenti
    
    /**restituisce un'LinkedHashMap K nome V id
     * 
     * @param doc id docente
     * @return hash
     */
    public LinkedHashMap LinkedHashMap(String doc) {
        LinkedHashMap hash = null;
        String sql1 = "SELECT COUNT(*) FROM insegnamenti ";
        if (doc!=null)
            sql1+="WHERE id_docente=?;";
        String sql2 = "SELECT CONCAT(nome, ' ', anno) AS completo, id FROM insegnamenti ";
        if (doc!=null)
            sql2+="WHERE id_docente=?;";
        try{                        
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            if (doc!=null)
                Common.setParametri(prpstmt1, 1, doc, Types.VARCHAR);                    
            System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                hash = new LinkedHashMap();
                hash.put(null, null);
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2); 
                if (doc!=null)
                    Common.setParametri(prpstmt2, 1, doc, Types.VARCHAR);                   
                System.out.println(prpstmt2.toString());            
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    hash.put(rs2.getObject(1), rs2.getObject(2));                    
                }
            } 
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return hash;
    }//end LinkedHashMap
    
    /**elimina dal database l'insegnamento
     * 
     * @param id dell'insegnamento da eliminare
     */
    public void elimina(String id) {
       String sql = "DELETE FROM insegnamenti WHERE id = ?;";       
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, id, Types.VARCHAR);                                   
            prpstmt.execute();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }
    
}//end class