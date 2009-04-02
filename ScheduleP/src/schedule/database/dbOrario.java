package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import schedule.Orario;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Orario ricevimento
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbOrario {
    
    private Connection conn;
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbOrario(){
        conn = dbConnessione.getConnection();
    }
    
    /**restituisce matrice di oggetti contentente lista orari
     * 
     * @param id
     * @return contenitore
     */
    public Object[][] listaOrari(String id){
        Object [][] contenitore;
        String sql1 = "SELECT COUNT(*) ";
        sql1 += "FROM orario WHERE id_doc=?";
        String sql2 = "SELECT giorno, ora_da, ora_a ";
        sql2 += "FROM orario WHERE id_doc=?;";        
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);
            Common.setParametri(prpstmt1, 1, id, Types.VARCHAR);
            System.out.println(prpstmt1.toString()); 
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][3];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2); 
                Common.setParametri(prpstmt2, 1, id, Types.VARCHAR);
                System.out.println(prpstmt2.toString()); 
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getObject(1);
                    contenitore[riga][1]=rs2.getObject(2);
                    contenitore[riga][2]=rs2.getObject(3);
                }
            } else
                contenitore = null; //endif numeroR
        } catch (SQLException sqle) {
            contenitore = null;
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            contenitore = null;
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    } //end lista orari
    
    /**inserisci nuovo orario
     * 
     * @param o
     */
    public void inserisci(Orario o){
        String sql = "INSERT INTO orario VALUES (?,?,?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, o.getId_doc(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, o.getGiorno(), Types.VARCHAR);
            Common.setParametri(prpstmt, 3, o.getOraDa(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, o.getOraA(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end inserisci
    
    /**aggiorna l'orario
     * 
     * @param nuovo
     * @param vecchio
     */
    public void aggiorna(Orario nuovo, Orario vecchio){
        String sql = "UPDATE orario SET giorno=?, ora_da=?, ora_a=? ";        
        sql+= "WHERE id_doc=? AND giorno=? AND ora_da=? AND ora_a=?;";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, nuovo.getGiorno(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, nuovo.getOraDa(), Types.INTEGER);            
            Common.setParametri(prpstmt, 3, nuovo.getOraA(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, nuovo.getId_doc(), Types.VARCHAR);
            Common.setParametri(prpstmt, 5, vecchio.getGiorno(), Types.VARCHAR);
            Common.setParametri(prpstmt, 6, vecchio.getOraDa(), Types.INTEGER);            
            Common.setParametri(prpstmt, 7, vecchio.getOraA(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end aggiorna
    
    /**elimina l'orario
     * 
     * @param o
     */
    public void delete(Orario o){
        String sql = "DELETE FROM orario WHERE id_doc=? AND giorno=? AND ora_da=? AND ora_a=?;";        
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, o.getId_doc(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, o.getGiorno(), Types.VARCHAR);
            Common.setParametri(prpstmt, 3, o.getOraDa(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, o.getOraA(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } // End delete
    
    /** restituisce la matrice degli orari per il giorno in input con eventuale esclusione oraria 
     * 
     * @param id
     * @param giorno
     * @param i orario di inizio da escludere, 0 x niente
     * @param f orario di fine da escludere, 0 x niente
     * @return contenitore, matrice quadrata con gli orari gia' registrati per il giorno in input
     */
    public int[][] orari (String id, String giorno, int i, int f){
        int[][] contenitore;
        String sql1 = "SELECT COUNT(*) ";
        sql1 += "FROM orario WHERE id_doc=? AND giorno=? AND NOT(ora_da=? and ora_a=?);";
        String sql2 = "SELECT ora_da, ora_a ";
        sql2 += "FROM orario WHERE id_doc=? AND giorno=? AND NOT(ora_da=? and ora_a=?) ";
        sql2+= "ORDER BY ora_da;";        
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);
            Common.setParametri(prpstmt1, 1, id, Types.VARCHAR);
            Common.setParametri(prpstmt1, 2, giorno, Types.VARCHAR);
            Common.setParametri(prpstmt1, 3, i, Types.INTEGER);
            Common.setParametri(prpstmt1, 4, f, Types.INTEGER);
            System.out.println(prpstmt1.toString()); 
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new int[numeroR][2];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2); 
                Common.setParametri(prpstmt2, 1, id, Types.VARCHAR);
                Common.setParametri(prpstmt2, 2, giorno, Types.VARCHAR);
                Common.setParametri(prpstmt2, 3, i, Types.INTEGER);
                Common.setParametri(prpstmt2, 4, f, Types.INTEGER);
                System.out.println(prpstmt2.toString()); 
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getInt(1);
                    contenitore[riga][1]=rs2.getInt(2);
                }
            } else
                contenitore = null; //endif numeroR
        } catch (SQLException sqle) {
            contenitore = null;
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            contenitore = null;
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    }//end orari
    
} //end class