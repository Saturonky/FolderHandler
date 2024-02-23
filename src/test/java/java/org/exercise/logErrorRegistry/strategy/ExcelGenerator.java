package java.org.exercise.logErrorRegistry.strategy;

import java.org.exercise.logErrorRegistry.ErrorLogEntry;
import java.util.List;

public class ExcelGenerator {

    private ExcelGenerationStrategy strategy;
    public ExcelGenerator(ExcelGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public void generetedExcel(List<ErrorLogEntry> errorLogs){
        strategy.generateExcel(errorLogs);
    }

}
