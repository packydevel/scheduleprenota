package schedule.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import schedule.Prenotaz;
import schedule.utility.Common;
import schedule.utility.Errori;

/** Progetto Schedule Orario
 *
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbPrenotaz {
    private Connection conn;

    /**Costruttore
     * ecupera la connessione
     */
    public dbPrenotaz(){
        conn = dbConnessione.getConnection();
    }
    
    /**Salva la prenotazione
     * 
     * @param p Prenotaz
     */
    public void salva(Prenotaz p){
        String sql = "INSERT INTO prenotazioni VALUES (?,?,?,?,?,?,?);";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, p.getAula(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, p.getDoc(), Types.VARCHAR);
            Common.setParametri(prpstmt, 3, p.getGiorno(), Types.TIMESTAMP);            
            Common.setParametri(prpstmt, 4, p.getOraI(), Types.INTEGER);
            Common.setParametri(prpstmt, 5, p.getOraF(), Types.INTEGER);
            Common.setParametri(prpstmt, 6, p.getInsegn(), Types.VARCHAR);
            Common.setParametri(prpstmt, 7, p.getNote(), Types.VARCHAR);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    }
        
    /**Restituisce la lista prenotazioni x giorno d'input
     * 
     * @param giorno 
     * @return matrice
     */
    public Object[][] listaGiorno(Timestamp giorno){
        Object [][] contenitore=null;
        String sql1 = "SELECT COUNT(*) FROM prenotazioni WHERE giorno=?;";
        String sql2 = "SELECT p.orada, p.oraa, s.nome, CONCAT(d.cognome, ' ', LEFT(d.nome,1)) AS doc ";
        sql2 += "FROM prenotazioni p, struttura s, docente d ";        
        sql2 += "WHERE p.id_sd=s.id AND p.id_doc=d.utente AND p.giorno=? ORDER BY p.orada;";
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            Common.setParametri(prpstmt1, 1, giorno, Types.TIMESTAMP);
            System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][4];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
                Common.setParametri(prpstmt2, 1, giorno, Types.TIMESTAMP);
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
    }//end listaGiorno 

    /** restituisce la matrice degli orari per il giorno con eventuale esclusione oraria 
     * 
     * @param id aula
     * @param giorno
     * @param i orario di inizio da escludere, 0 x niente
     * @param f orario di fine da escludere, 0 x niente
     * @return contenitore, matrice quadrata con gli orari gia' registrati per il giorno in input
     */
    public int[][] orariAula (String id, Timestamp giorno, int i, int f){
        int[][] contenitore=null;
        String sql1 = "SELECT COUNT(*) ";
        sql1 += "FROM prenotazioni WHERE id_sd=? AND giorno=? AND NOT(orada=? and oraa=?);";
        String sql2 = "SELECT orada, oraa ";
        sql2 += "FROM prenotazioni WHERE id_sd=? AND giorno=? AND NOT(orada=? and oraa=?) ";
        sql2+= "ORDER BY orada;";        
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);
            Common.setParametri(prpstmt1, 1, id, Types.VARCHAR);
            Common.setParametri(prpstmt1, 2, giorno, Types.TIMESTAMP);
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
                Common.setParametri(prpstmt2, 2, giorno, Types.TIMESTAMP);
                Common.setParametri(prpstmt2, 3, i, Types.INTEGER);
                Common.setParametri(prpstmt2, 4, f, Types.INTEGER);
                System.out.println(prpstmt2.toString()); 
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;
                    contenitore[riga][0]=rs2.getInt(1);
                    contenitore[riga][1]=rs2.getInt(2);
                }
            } 
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    }//end orari
    
    /**elimina la prenotazione
     * 
     * @param p Prenotaz
     */
    public void elimina(Prenotaz p){
        String sql = "DELETE FROM prenotazioni WHERE id_sd=? AND giorno=? AND orada=? AND oraa=?;";        
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, p.getAula(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, p.getGiorno(), Types.TIMESTAMP);
            Common.setParametri(prpstmt, 3, p.getOraI(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, p.getOraF(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end elimina
    
    /**ricerca la singola prenotazione
     * 
     * @param p Prenotaz
     * @return array contenente i dati mancanti
     */
    public String[] singolo(Prenotaz p){
        String sql = "SELECT s.nome, CONCAT(i.nome,' ',i.anno) AS ins, p.note FROM prenotazioni p, struttura s, insegnamenti i ";
        sql += "WHERE id_sd=? AND giorno=? AND orada=? AND oraa=? AND p.id_sd=s.id AND i.id=p.id_ins;";        
        String [] temp = new String[3];
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);
            Common.setParametri(prpstmt, 1, p.getAula(), Types.VARCHAR);
            Common.setParametri(prpstmt, 2, p.getGiorno(), Types.TIMESTAMP);
            Common.setParametri(prpstmt, 3, p.getOraI(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, p.getOraF(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            ResultSet rs = prpstmt.executeQuery();
                while (rs.next()) {
                    temp[0]=rs.getString(1);
                    temp[1]=rs.getString(2);
                    temp[2]=rs.getString(3);
                }
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return temp;
    } //end singolo    

    /**effettua l'aggiornamento di una prenotazione
     * 
     * @param nuovo
     * @param vecchio
     */
    public void update(Prenotaz nuovo, Prenotaz vecchio){
        String sql = "UPDATE prenotazioni SET "; 
        sql+="giorno=?, orada=?, oraa=?, id_sd=?, id_doc=?, id_ins=?, note=? "; 
        sql+= "WHERE id_sd=? AND giorno=? AND orada=? AND oraa=?;";
        try{                                    
            PreparedStatement prpstmt = conn.prepareStatement(sql);            
            Common.setParametri(prpstmt, 1, nuovo.getGiorno(), Types.TIMESTAMP);
            Common.setParametri(prpstmt, 2, nuovo.getOraI(), Types.INTEGER);            
            Common.setParametri(prpstmt, 3, nuovo.getOraF(), Types.INTEGER);            
            Common.setParametri(prpstmt, 4, nuovo.getAula(), Types.VARCHAR);
            Common.setParametri(prpstmt, 5, nuovo.getDoc(), Types.VARCHAR);
            Common.setParametri(prpstmt, 6, nuovo.getInsegn(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 7, nuovo.getNote(), Types.VARCHAR);            
            Common.setParametri(prpstmt, 8, vecchio.getAula(), Types.VARCHAR);
            Common.setParametri(prpstmt, 9, vecchio.getGiorno(), Types.TIMESTAMP);
            Common.setParametri(prpstmt, 10, vecchio.getOraI(), Types.INTEGER);            
            Common.setParametri(prpstmt, 11, vecchio.getOraF(), Types.INTEGER);            
            System.out.println(prpstmt.toString());            
            prpstmt.execute();            
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
    } //end update
    
    /**Restituisce la matrice della lista settimanale o mensile
     * 
     * @param inizio giorno
     * @param fine giorno
     * @return matrice
     */
    public Object [][] listaSettMese(Timestamp inizio, Timestamp fine){
        Object [][] contenitore=null;
        String sql1 = "SELECT COUNT(*) FROM prenotazioni ";
        sql1+="WHERE giorno>=? AND giorno<=?;";
        String sql2 = "SELECT p.giorno, p. orada, p.oraa, s.nome, CONCAT(d.cognome, ' ', LEFT(d.nome,1)) as doc ";
        sql2+="FROM prenotazioni p, struttura s, docente d ";
        sql2+="WHERE p.giorno>=? AND p.giorno<=? AND s.id=p.id_sd AND d.utente=p.id_doc ";
        sql2+="ORDER BY p.giorno, p.orada";
        try{                                    
            PreparedStatement prpstmt1 = conn.prepareStatement(sql1);            
            Common.setParametri(prpstmt1, 1, inizio, Types.TIMESTAMP);
            Common.setParametri(prpstmt1, 2, fine, Types.TIMESTAMP);
            System.out.println(prpstmt1.toString());            
            ResultSet rs1 = prpstmt1.executeQuery();
            int riga=-1;      
            rs1.next();
            int numeroR = rs1.getInt(1);
            if (numeroR>0) {
                contenitore = new Object[numeroR][5];
                PreparedStatement prpstmt2 = conn.prepareStatement(sql2);            
                Common.setParametri(prpstmt2, 1, inizio, Types.TIMESTAMP);
                Common.setParametri(prpstmt2, 2, fine, Types.TIMESTAMP);
                System.out.println(prpstmt2.toString());            
                ResultSet rs2 = prpstmt2.executeQuery();
                while (rs2.next()) {
                    riga++;                    
                    contenitore[riga][0]=Common.dataStringa(Common.timestampToCalendar(rs2.getTimestamp(1)));
                    contenitore[riga][1]=rs2.getObject(2);
                    contenitore[riga][2]=rs2.getObject(3);
                    contenitore[riga][3]=rs2.getObject(4);
                    contenitore[riga][4]=rs2.getObject(5);
                }
            } 
        } catch (SQLException sqle) {
            Errori.gestisciEccezione(sqle);
        } catch (Exception e) {
            Errori.gestisciEccezione(e);
        }
        return contenitore;
    }
} //end class