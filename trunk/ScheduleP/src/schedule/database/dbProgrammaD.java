package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import schedule.ProgrammaD;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Programma didattico
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbProgrammaD {
    
    private Connection conn;
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbProgrammaD(){
        conn = dbConnessione.getConnection();
    }
    
    /**restituisce una matrice di oggetti contenente la lista dei programmi didattici
     * 
     * @param id_doc id docente
     * @return contenitore
     */
    public Object[][] listaProgrammi(String id_doc){
        Object [][] contenitore=null;
        String sql1 = "SELECT COUNT(*) ";
        sql1 += "FROM programmi WHERE id_ins IN (SELECT id FROM insegnamenti i WHERE id_docente=?)";
        String sql2 = "SELECT concat(i.nome, ' ', i.anno) AS lista ";
        sql2+="FROM programmi p, insegnamenti i ";
        sql2+="WHERE p.id_ins=i.id AND p.id_ins IN (SELECT id FROM insegnamenti i WHERE id_docente=?)";
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);
            Common.setParametri(prpstmt1, 1, id_doc, Types.VARCHAR);
            System.out.println(prpstmt1.toString());
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][1];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2); 
                Common.setParametri(prpstmt2, 1, id_doc, Types.VARCHAR);
                System.out.println(prpstmt2.toString());
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getObject(1);
                }
            }
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    } //end lista orari
    
    /**inserisci nuovo programma didattico
     * 
     * @param pd
     */
    public void inserisci(ProgrammaD pd){
        String sql = "INSERT INTO programmi VALUES (?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, pd.getId_insegn(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 2, pd.getTesto(), Types.VARCHAR);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end inserisci
        
    /**aggiorna il programma didattico
     * 
     * @param nuovo
     */ 
    public void aggiorna(ProgrammaD nuovo){
        String sql = "UPDATE programmi SET testo=? ";        
        sql+= "WHERE id_ins=?;";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, nuovo.getTesto(), Types.VARCHAR);                        
            Common.setParametri(prpstmt, 2, nuovo.getId_insegn(), Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end aggiorna 
    
    /**elimina il programma didattico
     * 
     * @param pd
     */
    public void delete(ProgrammaD pd){
        String sql = "DELETE FROM programmi WHERE id_ins=?;";        
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, pd.getId_insegn(), Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } // End delete
    
    /**restituisci il testo del programma relativo all'insegnamento
     * 
     * @param id id insegnamento
     * @return pd
     */
    public String testo(String id){
        String sql = "SELECT testo FROM programmi WHERE id_ins=?;";
        String testo = null;
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, id, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            ResultSet rs = prpstmt.executeQuery();
            while (rs.next())
                testo = rs.getString(1);
        } catch (SQLException sqle) {                        
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return testo;
    } //end singolo

}//end class
