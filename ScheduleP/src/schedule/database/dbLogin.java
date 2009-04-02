package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import schedule.utility.Common;
import schedule.utility.Errori;

/** DataMapper Login
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbLogin {

    private Connection conn;
    
    /**Costruttore, recupera l'oggetto connessione
     * 
     */
    public dbLogin() {
        conn = dbConnessione.getConnection(); 
    }    
    
    /**Verifica esistenza ed abilitazione dell'utente per il login
     * 
     * @param user utente
     * @param pwd password
     * @return codice successo/errore
     */
    public int verificaUtente (String user, String pwd) {
        int errore=-1;        
        if (conn!=null) {
            String sql = "SELECT 1 FROM login ";
            sql += "WHERE utente = ? AND pwd = ? AND abilitazione = 1;";        
            try{                                                
                PreparedStatement prpstmt = conn.prepareStatement(sql);
                Common.setParametri(prpstmt, 1, user, Types.VARCHAR);
                Common.setParametri(prpstmt, 2, pwd, Types.VARCHAR);                        
                ResultSet rs = prpstmt.executeQuery();
                if (rs.next())
                    errore=0;
                else
                    errore=1;            
            } catch (SQLException sqle) {
                errore=2;
                Errori.gestisciEccezione(sqle);
            } catch (Exception e) {
                errore=2;
                Errori.gestisciEccezione(e);
            }
        }
        return errore;
    }//end verificaUtente
    
    /**inserisci i dati per la login del docente
     * 
     * @param user 
     * @param pwd
     * @return errore 0 se successo -1 se errore sql
     */
    public int inserisci(String user, String pwd){        
        String sql = "INSERT INTO login VALUES (?, ?, 1);";        
        int err = 0;
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, user, Types.VARCHAR);
            Common.setParametri(prpstmt, 2, pwd, Types.VARCHAR);                       
            System.out.println(prpstmt.toString());        
            prpstmt.executeUpdate();            
        } catch (SQLException sqle) {            
            Errori.gestisciEccezione(sqle);
            err = -1;
        } catch (Exception e) {            
            Errori.gestisciEccezione(e);
        }        
        return err;
    }
    
    /**Aggiorna la password
     * 
     * @param user utente
     * @param pwd nuova password     
     */
    public void aggiornaPwd (String user, String pwd) {
        String sql = "UPDATE login SET pwd= ? WHERE utente = ?;";       
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, pwd, Types.VARCHAR);                       
            Common.setParametri(prpstmt, 2, user, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.executeUpdate();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }// end aggiornaPwd
    
    /**abilita la login dell'utente
     * 
     * @param user
     */
    public void abilitaUtente (String user){        
        String sql = "UPDATE login SET abilitazione=1 WHERE utente = ?;";       
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, user, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.executeUpdate();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }// end aggiornaPwd
    
    /**disabilita la login dell'utente
     * 
     * @param user
     */
    public void disabilitaUtente (String user) {
        String sql = "UPDATE login SET abilitazione=0 WHERE utente = ?;";       
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, user, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.executeUpdate();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }// end aggiornaPwd
    
    /**Elimina il docente dal database
     * 
     * @param utente id docente
     */
    public void elimina(String utente) {
        String sql = "DELETE FROM login WHERE utente = ?;";
        try{                        
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, utente, Types.VARCHAR);
            System.out.println(prpstmt.toString());            
            prpstmt.executeUpdate();
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }
    
} //end class