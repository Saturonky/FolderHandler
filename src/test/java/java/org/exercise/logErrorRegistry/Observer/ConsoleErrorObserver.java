package java.org.exercise.logErrorRegistry.Observer;

import java.org.exercise.logErrorRegistry.ErrorLogEntry;
import java.org.exercise.logErrorRegistry.strategy.ExcelGenerator;
import java.util.ArrayList;
import java.util.List;

public class ConsoleErrorObserver implements ErrorObserver {
    private List<ErrorLogEntry> errorLogs = new ArrayList<>();
    private ExcelGenerator excelGenerator;

    public ConsoleErrorObserver(ExcelGenerator excelGenerator) {
        this.excelGenerator = excelGenerator;
    }
    @Override
    public void update(ErrorLogEntry errorLogEntry) {
        errorLogs.add(errorLogEntry);
        excelGenerator.generetedExcel(errorLogs);
    }
}
