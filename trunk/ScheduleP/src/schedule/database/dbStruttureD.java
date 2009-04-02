package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedHashMap;
import schedule.StruttureD;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Strutture didattiche
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbStruttureD {
    
    private Connection conn;
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbStruttureD() {        
        conn = dbConnessione.getConnection();        
    }
    
    /**inserisci nuova struttura
     * 
     * @param sd
     */
    public void inserisciStruttura(StruttureD sd){        
        String sql = "INSERT INTO struttura VALUES (?,?,?,?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, sd.getId(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, sd.getNome(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 3, sd.getUbicazione(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 4, sd.getPosti(), Types.INTEGER);            
            Common.setParametri(prpstmt, 5, sd.getTipo(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }//end inserisciStruttura

    /**restituisce matrice di oggetti contenente lista strutture
     * 
     * @return contenitore
     */
    public Object[][] listaStrutture(){
        Object [][] contenitore;
        String sql1 = "SELECT COUNT(*) FROM struttura";
        String sql2 = "SELECT id, nome FROM struttura";        
        try{                        
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            //System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][2];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
                //System.out.println(prpstmt2.toString());            
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getObject(1);
                    contenitore[riga][1]=rs2.getObject(2);                    
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
    }//end listaStrutture
           
    /**restituisci la singola struttura
     * 
     * @param id
     * @return sd
     */
    public StruttureD singolo(String id){
        String sql = "SELECT * FROM struttura WHERE id=?;";
        StruttureD sd = null;
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, id, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            ResultSet rs = prpstmt.executeQuery();
            while (rs.next())
                sd = new StruttureD(id, rs.getString(2), 
                        rs.getString(3), rs.getInt(4),rs.getInt(5));
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
            return null;
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
            return null;
        }
        return sd;
    }
    
    /**aggiorna la struttura
     * 
     * @param sd
     */
    public void aggiorna(StruttureD sd) {        
        String sql = "UPDATE struttura SET nome= ?, ubicazione=?, " +
                "posti=?, tipo=? WHERE id = ?;";       
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, sd.getNome(), Types.VARCHAR);                       
            Common.setParametri(prpstmt, 2, sd.getUbicazione(), Types.VARCHAR);
            Common.setParametri(prpstmt, 3, sd.getPosti(), Types.INTEGER);
            Common.setParametri(prpstmt, 4, sd.getTipo(), Types.INTEGER);
            Common.setParametri(prpstmt, 5, sd.getId(), Types.VARCHAR);            
            prpstmt.execute();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }
    
    /**Elimina la struttura
     * 
     * @param id
     */
    public void elimina(String id) {        
        String sql = "DELETE FROM struttura WHERE id = ?;";       
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
    
    /**restituisce una LinkedHashMap K nome V id
     * 
     * @return hash
     */
    public LinkedHashMap LinkedHashMap() {
        LinkedHashMap hash = null;
        String sql1 = "SELECT COUNT(*) FROM struttura;";
        String sql2 = "SELECT nome, id FROM struttura";
        try{                        
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                hash = new LinkedHashMap();
                hash.put(null, null);
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
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
    
    /**Cerca l'id della struttura
     * 
     * @param nome 
     * @return id
     */
    public String cercaID(String nome){
        String sql = "SELECT id FROM struttura WHERE nome=?;";
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
    
} //end class