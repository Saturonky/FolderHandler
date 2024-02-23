package java.org.exercise.logErrorRegistry.factory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ApachePOIExcelFactory implements ExcelFactory {
    @Override
    public Workbook createWorkbook() {
        return new HSSFWorkbook();
    }

    @Override
    public Cell createCell() {
        Workbook workbook = createWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        return cell;
    }
}
