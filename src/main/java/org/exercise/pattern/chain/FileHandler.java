package org.exercise.pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;

@Slf4j
public class FileHandler implements FileHandlerChain {
    private final FileHandlerChain next;

    public FileHandler(FileHandlerChain next) {
        this.next = next;
    }

    @Override
    public void handle(File file, FileVisitor visitor) {
        if (file.isFile()) {
            visitor.visitFile(file);
        } else {
            next.handle(file, visitor);
        }
    }
}
