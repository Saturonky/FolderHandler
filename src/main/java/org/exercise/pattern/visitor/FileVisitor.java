package org.exercise.pattern.visitor;

import java.io.File;

public interface FileVisitor {
    void visitFile(File file);
    void visitDirectory(File directory);
}
