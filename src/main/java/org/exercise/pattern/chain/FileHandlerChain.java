package org.exercise.pattern.chain;

import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;
import java.io.IOException;

// Interfaccia per il Chain of Responsibility
public interface FileHandlerChain {
    void handle(File file, FileVisitor visitor) throws IOException;
}