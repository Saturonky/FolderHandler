package org.exercise.file;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;

import static org.apache.commons.io.FilenameUtils.getExtension;

@Slf4j
public class FileLoggingVisitor implements FileVisitor {
    @Override
    public void visitFile(File file) {
        final String extension = getExtension(file.getName());
        log.info("File: {}", extension);
    }

    @Override
    public void visitDirectory(File directory) {
    log.info("Directory: {}", directory.getName());
    }
}
