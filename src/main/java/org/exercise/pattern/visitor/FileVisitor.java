package org.exercise.pattern.visitor;

import java.io.File;

// Interfaccia per il Visitor
public interface FileVisitor {
    void visitFile(File file);
    void visitFolder(File folder);
}
