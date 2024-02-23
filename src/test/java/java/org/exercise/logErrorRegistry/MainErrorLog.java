package java.org.exercise.logErrorRegistry;

import java.org.exercise.logErrorRegistry.Observer.ConsoleErrorObserver;
import java.org.exercise.logErrorRegistry.Observer.ErrorObserver;
import java.org.exercise.logErrorRegistry.strategy.ExcelGenerator;

public class MainErrorLog {

    public static void main(String[] args) {
        ErrorLogger errorLogger = ErrorLogger.getInstance();
        ExcelGenerator excelGenerator = errorLogger.getExcelGenerator();
        ErrorObserver consoleErrorObserver = new ConsoleErrorObserver(excelGenerator);
        errorLogger.addObserver(consoleErrorObserver);

/**
 * Quando viene registrato un errore nella console,
 * chiama il metodo  logError()  dell' ErrorLogger  per registrare l'errore:
 */
        //errorLogger.logError("Errore durante l'esecuzione del processo", new Date());
    }
}
