package org.exercise.pattern.visitor;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FileCounterVisitor implements FileVisitor {
    private final Map<String, Integer> fileCounts = new HashMap<>();
    private int folderCount = 0;

    @Override
    public void visitFile(File file) {
        String extension = getFileExtension(file);
        fileCounts.put(extension, fileCounts.getOrDefault(extension, 0) + 1);
    }

    @Override
    public void visitFolder(File folder) {
        folderCount++;
    }

    public void printResult() {
        log.info("*****************************FILE**************************************");
        log.info("Conteggio dei file per estensione:");
        fileCounts.forEach((extension, count) -> log.info("File con formato {}: {}", extension, count));
        log.info("*****************************END***************************************\n");
        log.info("*****************************CARTELLE**********************************");
        log.info("Cartelle controllate: {}", folderCount);
        log.info("*****************************END***************************************");
    }
    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex +1);
        }
        return "N/A";
    }
}
