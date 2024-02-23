package org.exercise;

import org.exercise.file.FileAnalyzer;
import org.exercise.pattern.chain.FileHandler;
import org.exercise.pattern.chain.FolderHandler;
import org.exercise.pattern.visitor.FileCounterVisitor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\terzi\\Desktop\\mine.mod\\MHRiseTalismanEditor";
        FileHandler fileHandler = new FileHandler(null); // Nessun successore, poiché è l'ultimo nella catena
        FolderHandler folderHandler = new FolderHandler(fileHandler); // Ultimo gestore nella catena, delega il controllo ai file a FileHandler
        FileAnalyzer fileAnalyzer = new FileAnalyzer(folderHandler); // Inizia l'analisi con il gestore della cartella principale
        FileCounterVisitor visitor = new FileCounterVisitor();
        fileAnalyzer.analyze(new File(folderPath), visitor);
        visitor.printResult();
    }
}