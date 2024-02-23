package java.org.exercise.singleton.DB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
/**
 * Questa classe rappresenta un'implementazione del pattern Singleton per la connessione al database.
 */
public class DBConnectionSingleton {

    /**
     * Logger per la registrazione dei messaggi di log.
     */
    private static final Logger log = LoggerFactory.getLogger(DBConnectionSingleton.class);

    /**
     * Istanzia un'unica istanza della classe.
     */
    private static DBConnectionSingleton instance;

    /**
     * Connessione al database.
     */
    private Connection connection;

    /**
     * URL del database.
     */
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_name";

    /**
     * Nome utente per l'accesso al database.
     */
    private static final String USERNAME = "root";

    /**
     * Password per l'accesso al database.
     */
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    /**
     * Costruttore privato per evitare la creazione diretta di istanze dalla classe esterna.
     */
    private DBConnectionSingleton() {
    }

    /**
     * Restituisce l'istanza unica della classe.
     *
     * @return L'istanza unica della classe.
     */
    public static synchronized DBConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DBConnectionSingleton();
        }
        return instance;
    }

    /**
     * Apre la connessione al database.
     */
    public void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                log.info(String.format("Connessione al DB: %s", DATABASE_URL));
            } else {
                log.info("La connessione al DB è già aperta");
            }
        } catch (SQLException e) {
            log.error("Errore nel creare la connessione al DB:", e);
        }
    }

    /**
     * Chiude la connessione al database.
     */
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                log.info(String.format("Disconnessione al DB: %s", DATABASE_URL));
            } else {
                log.info("La connessione al DB è già chiusa o non è stata aperta");
            }
        } catch (SQLException e) {
            log.error("Errore nella chiusura della connessione al DB:", e);
        }
    }

    /**
     * Esegue una query sul database.
     *
     * @param query La query da eseguire.
     * @param params I parametri della query.
     * @return Il risultato della query come un oggetto ResultSet.
     * @throws SQLException Se si verifica un errore durante l'esecuzione della query.
     */
    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connect();
            statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            log.error("Errore nell'esecuzione della query:", e);
            throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("Errore nella chiusura del ResultSet:", e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("Errore nella chiusura dello Statement:", e);
                }
            }
            disconnect();
        }
    }
}