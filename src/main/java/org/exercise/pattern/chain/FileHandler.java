package org.exercise.pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FileHandler implements FileHandlerChain {
    private final FileHandlerChain next;

    public FileHandler(FileHandlerChain next) {
        this.next = next;
    }

    @Override
    public void handle(File file, FileVisitor visitor) {
        if (file.isFile()) {
            visitor.visitFile(file); // Delega la gestione dei file a visitor
        } else {
            try {
                next.handle(file, visitor);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}
