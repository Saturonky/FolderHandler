package org.exercise.file;

import org.exercise.pattern.chain.FileHandler;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;

public class FileHandlerChain implements FileHandler {
    private final FileVisitor visitor;

    public FileHandlerChain(FileVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void handleFile(File file) {
        visitor.visitFile(file);
    }

    @Override
    public void handleDirectory(File directory) {
    visitor.visitDirectory(directory);
    }
}
