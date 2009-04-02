package schedule.database;

import java.io.File;
import schedule.utility.DesEncrypter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import schedule.utility.Errori;

/** Connessione al database
 * 
 * @author id_gruppo = 23
 * @author 467644 Luca Mignogna
 * @author 465401 Francesco Cafarelli 
 * @author 462866 Luca Lo Mele
 * @author 467643 Elia Russo 
 */

public class dbConnessione {
    //driver mysql
    final private String DRIVER_CLASS_NAME_MYSQL = "org.gjt.mm.mysql.Driver";    
    //Uniform Resource Identifier
    private String uri;
    //identificativo server 
    private String server;
    //nome basedati
    private String database;
    //porta
    private String porta;
    //username accesso db
    private String utente;
    //password per l'user
    private String password;
    //verifica che la password x l'accesso al db sia criptata
    private String criptata;
    //oggetto connessione
    private static Connection conn;

    private dbConnessione(){
        conn = null;
        try {
            //leggi la configurazione del database
            leggiConfigurazioneDB();
            //carico il driver JDBC MYSQL
            Class.forName(DRIVER_CLASS_NAME_MYSQL);
            //creo l'url JDBC per la connessione
            String url = uri + server + ":" + porta + "/" + database;
            System.out.println(url);
            conn = DriverManager.getConnection(url, utente, password);
        } catch (ClassNotFoundException cnfe) {Errori.gestisciEccezione(cnfe);}
        catch (SQLException sqle) {Errori.gestisciEccezione(sqle);}
        catch (FileNotFoundException fnfe) {Errori.gestisciEccezione(fnfe);}
        catch (IOException ioe) {Errori.gestisciEccezione(ioe);} 
        catch (Exception e) {Errori.gestisciEccezione(e);} 
    }

    /**Restituisce l'oggetto connessione
     * 
     * @return connessione
     */
    public static Connection getConnection() {
        if (conn == null) 
            new dbConnessione();
        return conn;
    }

    /**Chiude la connessione
     * 
     */
    public static void closeConnection() throws SQLException {
        conn.close();
    }
    
    //legge il file contenente le informazioni sul database
    private void leggiConfigurazioneDB() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        //directory di lavoro
        String file = System.getProperty("user.dir") + File.separator + "database.properties";
        //il percorso e' la root di base del progetto
        properties.load(new FileInputStream(file));
        //DBMS = properties.getProperty("DBMS");
        uri = properties.getProperty("URI");
        server = properties.getProperty("SERVER");
        porta = properties.getProperty("PORT");
        database = properties.getProperty("DATABASE");
        utente = properties.getProperty("USER");
        criptata = properties.getProperty("CRYPT");
        password = properties.getProperty("PASSWORD");
        if (criptata.equalsIgnoreCase("true")) {
            DesEncrypter des = new DesEncrypter("mysql");
            password = des.decripta(password);            
        }
    }//end leggiconfig
    
}//end class