package java.org.exercise.logErrorRegistry;

import java.org.exercise.logErrorRegistry.Observer.ErrorObserver;
import java.org.exercise.logErrorRegistry.factory.ApachePOIExcelFactory;
import java.org.exercise.logErrorRegistry.factory.ExcelFactory;
import java.org.exercise.logErrorRegistry.strategy.ApachePOIExcelGenerationStrategy;
import java.org.exercise.logErrorRegistry.strategy.ExcelGenerationStrategy;
import java.org.exercise.logErrorRegistry.strategy.ExcelGenerator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La classe ErrorLogger è responsabile per la registrazione degli errori e la notifica degli osservatori.
 * Mantiene una lista di voci di log degli errori e fornisce metodi per aggiungere osservatori, registrare errori
 * e recuperare i log degli errori.
 */
public class ErrorLogger {
    private static ErrorLogger instance;
    private List<ErrorLogEntry> errorLogs = new ArrayList<>();
    private List<ErrorObserver> observers = new ArrayList<>();

    private ExcelGenerator excelGenerator;

    /**
     * Costruttore privato per evitare l'istanziazione diretta.
     * Inizializza l'ExcelGenerator utilizzando l'ApachePOIExcelFactory.
     */
    private ErrorLogger() {
        ExcelFactory excelFactory = new ApachePOIExcelFactory();
        ExcelGenerationStrategy excelGenerationStrategy = new ApachePOIExcelGenerationStrategy(excelFactory);
        excelGenerator = new ExcelGenerator(excelGenerationStrategy);
    }

    /**
     * Restituisce l'istanza singleton di ErrorLogger.
     *
     * @return L'istanza di ErrorLogger.
     */
    public static synchronized ErrorLogger getInstance() {
        if (instance == null) {
            instance = new ErrorLogger();
        }
        return instance;
    }

    /**
     * Aggiunge un osservatore alla lista degli osservatori.
     *
     * @param observer L'osservatore da aggiungere.
     */
    public void addObserver(ErrorObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifica tutti gli osservatori con la voce di log dell'errore specificata.
     *
     * @param errorLogEntry La voce di log dell'errore da notificare.
     */
    private void notifyObservers(ErrorLogEntry errorLogEntry) {
        for (ErrorObserver observer : observers) {
            observer.update(errorLogEntry);
        }
    }

    /**
     * Registra un errore con il messaggio di errore e il timestamp specificati.
     * Crea una ErrorLogEntry e la aggiunge ai log degli errori.
     * Notifica tutti gli osservatori con la voce di log dell'errore.
     *
     * @param errorMessage Il messaggio di errore.
     * @param timestamp    Il timestamp dell'errore.
     */
    public void logError(String errorMessage, Date timestamp) {
        ErrorLogEntry errorLogEntry = new ErrorLogEntry.Builder()
                .setErrorMessage(errorMessage)
                .setTimestamp(timestamp)
                .build();

        errorLogs.add(errorLogEntry);
        notifyObservers(errorLogEntry);
    }

    // Altri metodi per gestire i log degli errori

    /**
     * Restituisce la lista delle voci di log degli errori.
     *
     * @return La lista delle voci di log degli errori.
     */
    public List<ErrorLogEntry> getErrorLogs() {
        return errorLogs;
    }

    /**
     * Restituisce l'istanza di ExcelGenerator associata all'ErrorLogger.
     *
     * @return L'istanza di ExcelGenerator.
     */
    public ExcelGenerator getExcelGenerator() {
        return excelGenerator;
    }
}
