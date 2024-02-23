package org.exercise.pattern.chain;

import java.io.File;

public interface FileHandler {
    void handleFile(File file);
    void handleDirectory(File directory);
}
