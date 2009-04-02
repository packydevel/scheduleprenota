package schedule.utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/** Metodi comuni raccolti in un'unico oggetto
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */
public class Common {
    
    /**Imposta i parametri e i tipi per l'sql
     * 
     * @param stmt preparedStatement 
     * @param indice
     * @param valore
     * @param tipo
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public static void setParametri(PreparedStatement stmt, int indice, 
                                    Object valore, int tipo) throws SQLException, Exception {
        if (valore == null)
          stmt.setNull(indice, tipo);
        else {
          if (tipo == Types.VARCHAR)
            stmt.setString(indice, (String)valore);          
          else if (tipo == Types.INTEGER)
            stmt.setLong(indice, ((Integer) valore).intValue());          
          else if (tipo == Types.TIMESTAMP)
            stmt.setTimestamp(indice, ((Timestamp) valore)); 
          else
            throw new Exception("Tipo di dato non gestito");
        } //end else valore == null
    } //end setParametri
    
    /**Centra il frame rispetto lo schermo
     * 
     * @param frame finestra da centrare
     */
    public static void centraFrame(Window frame) {
        Dimension frameSize = frame.getSize();
        frame.setSize(frameSize);
        frame.setLocation(
            (Toolkit.getDefaultToolkit().getScreenSize().width
                - frameSize.width) / 2,
            (Toolkit.getDefaultToolkit().getScreenSize().height
                - frameSize.height) / 2);
    }// end centraFrame
            
    /**controlla la validita' della data e restituisce true/false
     * 
     * @param gg
     * @param mm
     * @param aa
     * @return booleano
     */
    public static boolean controllaData(Object gg, Object mm, Object aa) {       
        boolean controlla=false;
        try {
            int g = Integer.parseInt(gg.toString());
            int m = Integer.parseInt(mm.toString());
            int a = Integer.parseInt(aa.toString());
            GregorianCalendar cal = new GregorianCalendar (a, m-1, g);
            cal.setLenient (false);        
            cal.get (Calendar.DATE);
            controlla= true;
        } catch(NumberFormatException nfe){              
        } catch(NullPointerException npe){              
        } catch (IllegalArgumentException e) {}
        return controlla;
    } //end controllaData
    
    /**richiama la funzione conferma cancellazione e restituisce il valore corrispondente al tasto premuto
     * 
     * @return valore intero
     */
    public static int confermaDelete(){
        return JOptionPane.showConfirmDialog(null, "Vuoi eliminare il rigo selezionato?",
            "Eliminazione Record", JOptionPane.YES_NO_OPTION);
    }
    
    /**Restituisce la data in formato stringa
     * 
     * @param cal GregorianCalendar
     * @return Stringa gg/mm/aaaa
     */
    public static String dataStringa(GregorianCalendar cal){
        return cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
    }
    
    /**Restituisce la stringa in formato GregorianCalendar
     * 
     * @param day stringa gg/mm/aaaa
     * @return gregorian calendar
     */
    public static GregorianCalendar stringaCalendar(String day){
        String[] temp = day.split("/");
        return new GregorianCalendar(Integer.parseInt(temp[2]),
                (Integer.parseInt(temp[1])-1), Integer.parseInt(temp[0]));
    }
    
    /**Restituisce il giorno odierno
     * se domenica restituisce lunedì
     * @return gregoriancalendar
     */
    public static GregorianCalendar giornoOdierno(){
        GregorianCalendar temp = new GregorianCalendar();
        if (temp.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
            temp.add(Calendar.DATE, 1);
        return new GregorianCalendar(temp.get(Calendar.YEAR),temp.get(Calendar.MONTH),
                temp.get(Calendar.DAY_OF_MONTH));
    }
    
    /**controlla se gli orari di inizio fine intervallo coincidano con gli orari presenti nella matrice
     * 
     * @param matrice
     * @param inizio
     * @param fine
     * @return true se trova corrispondenze d'intervallo, false in caso contrario
     */
    public static boolean controllaOrari(int[][] matrice, int inizio, int fine){
        boolean esiste = false;        
        if (matrice!=null){
            int lunghezza = matrice.length;
            if (lunghezza>0) {
                for (int i=0; i<lunghezza; i++){
                    if ((matrice[i][0]>=inizio) && (matrice[i][0]<fine)){
                        esiste = true;
                        break;
                    }
                    if ((matrice[i][1]>inizio) && (matrice[i][1]<=fine)){
                        esiste = true;
                        break;
                    }
                }
            }
        }
        return esiste;
    }
    
    /**Conversione da GregorianCalendar a Timestamp
     * 
     * @param gc Gregorian calendar
     * @return tempo in millisecondi
     */
    public static Timestamp calendarToTimestamp(GregorianCalendar gc){
        return new Timestamp(gc.getTimeInMillis());
    }
    
    /**Conversione da Timestamp a GregorianCalendar
     * 
     * @param time
     * @return gregorian calendar
     */
    public static GregorianCalendar timestampToCalendar(Timestamp time){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(time.getTime());
        return gc;
    }
        
} //end class