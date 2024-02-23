package java.org.exercise.logErrorRegistry.factory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelFactory {
    //Metodi per la creazione di oggetti Excel
    Workbook createWorkbook();
    Cell createCell();

}
