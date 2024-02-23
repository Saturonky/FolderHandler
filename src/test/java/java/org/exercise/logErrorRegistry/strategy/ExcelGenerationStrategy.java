package java.org.exercise.logErrorRegistry.strategy;

import java.org.exercise.logErrorRegistry.ErrorLogEntry;
import java.util.List;

public interface ExcelGenerationStrategy {
    void generateExcel(List<ErrorLogEntry> errorLogs);
}
