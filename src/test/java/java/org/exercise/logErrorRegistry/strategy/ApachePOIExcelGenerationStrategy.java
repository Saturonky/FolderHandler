package java.org.exercise.logErrorRegistry.strategy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.org.exercise.logErrorRegistry.ErrorLogEntry;
import java.org.exercise.logErrorRegistry.factory.ExcelFactory;
import java.util.List;

public class ApachePOIExcelGenerationStrategy implements ExcelGenerationStrategy {
    private ExcelFactory excelFactory;

    public ApachePOIExcelGenerationStrategy(ExcelFactory excelFactory) {
        this.excelFactory = excelFactory;
    }

    @Override
    public void generateExcel(List<ErrorLogEntry> errorLogs) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Error Logs");

        int rowNum = 0;
        for (ErrorLogEntry entry : errorLogs) {

            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(entry.getErrorMessage());
            cell = row.createCell(1);
            cell.setCellValue(entry.getTimestamp().toString());
        }

        try(FileOutputStream fileOut = new FileOutputStream("error_logs.xlsx")) {

        workbook.write(fileOut);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
