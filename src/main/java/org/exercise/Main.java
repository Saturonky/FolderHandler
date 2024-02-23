package org.exercise;

import lombok.extern.slf4j.Slf4j;
import org.exercise.file.FileAnalyzer;
import org.exercise.pattern.chain.FileHandler;
import org.exercise.pattern.chain.FolderHandler;
import org.exercise.file.FileCounterVisitor;

import java.io.File;
import java.io.IOException;
@Slf4j
public class Main {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\terzi\\Desktop\\Cartelle\\emulator\\publish\\bin";
        // Creazione della catena di responsabilità
        FileHandler fileHandler = new FileHandler(null); // Nessun successore, poiché è l'ultimo nella catena
        FolderHandler folderHandler = new FolderHandler(fileHandler); // Ultimo gestore nella catena, delega il controllo ai file a FileHandler
        // Creazione dell' analizzatore di file e il viisitor
        FileAnalyzer fileAnalyzer = new FileAnalyzer(folderHandler); // Inizia l'analisi con il gestore della cartella principale
        FileCounterVisitor visitor = new FileCounterVisitor();
        try {
            fileAnalyzer.analyze(new File(folderPath), visitor);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        visitor.printResult();
    }
}