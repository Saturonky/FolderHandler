package org.exercise.file;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static org.apache.commons.io.FilenameUtils.getExtension;

@Slf4j
public class FileLoggingVisitor implements FileVisitor {
    private final Map<String, Map<String, Integer>> folderFileCounts = new HashMap<>();

    @Override
    public void visitFile(File file) {
        final String extension = getExtension(file.getName());
        File parentFolder = file.getParentFile();
        folderFileCounts.computeIfAbsent(parentFolder.getAbsolutePath(), k -> new HashMap<>())
                .put(extension, folderFileCounts.getOrDefault(parentFolder.getAbsolutePath(), new HashMap<>()).getOrDefault(extension, 0) + 1);
        log.info("File: {} ", file.getName());
        log.info("In directory: {}", parentFolder.getAbsolutePath());
    }

    @Override
    public void visitDirectory(File directory) {
        log.info("Directory: {}", directory.getAbsolutePath());
    }

    public void printTotalCounts() {
        log.info("Total file counts per extension in each folder:");
        folderFileCounts.forEach((folderPath, counts) -> {
            log.info("Folder: {}", folderPath);
            counts.forEach((extension, count) -> log.info("   File with extension {}: {}", extension, count));
        });
    }
}