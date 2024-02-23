package org.exercise.file;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.chain.FileHandlerChain;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;

// Analyzer che combina Chain e Step
@Slf4j
public class FileAnalyzer {
    private final FileHandlerChain handlerChain;

    public FileAnalyzer(FileHandlerChain handlerChain) {
        this.handlerChain = handlerChain;
    }

    public void analyze(File file, FileVisitor visitor) {
        handlerChain.handle(file, visitor);
    }
}
