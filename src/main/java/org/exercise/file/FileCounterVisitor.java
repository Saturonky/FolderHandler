package org.exercise.file;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FileCounterVisitor implements FileVisitor {
    private final Map<File, Map<String, Integer>> folderFileCounts = new HashMap<>();
    private final Map<File, Integer> folderTotalFileCount = new HashMap<>();

    @Override
    public void visitFile(File file) {
        String extension = getFileExtension(file);
        File parentFolder = file.getParentFile();

        folderFileCounts.computeIfAbsent(parentFolder, k -> new HashMap<>())
                .put(extension, folderFileCounts.getOrDefault(parentFolder, new HashMap<>()).getOrDefault(extension, 0) + 1);
    }

    @Override
    public void visitFolder(File folder) {
        // Inizializza la mappa dei conteggi dei file per questa cartella
        folderFileCounts.putIfAbsent(folder, new HashMap<>());
    }

    public void printResult() {
        log.info("*****************************FILE**************************************");
        folderFileCounts.forEach((folder, counts) -> {
            log.info("Conteggio dei file per cartella {} : {}", folder.getName(), folder.getParent());
            counts.forEach((extension, count) -> log.info("   File con formato {}: {}", extension, count));
            int totalFiles = counts.values().stream().mapToInt(Integer::intValue).sum();
            log.info("   Totale file: {}\n", totalFiles);
        });
        log.info("*****************************END***************************************\n");
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        }
        return "N/A";
    }
}
