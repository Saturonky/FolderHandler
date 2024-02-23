package org.exercise.file;

import java.io.File;

public class FileExplorer {
    private final FileHandlerChain fileHandlerChain;

    public FileExplorer(FileHandlerChain fileHandlerChain) {
        this.fileHandlerChain = fileHandlerChain;
    }

    public void explore(File root) {
        exploreDirectory(root);
    }

    private void exploreDirectory(File directory) {
        final File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileHandlerChain.handleDirectory(file);
                    exploreDirectory(file);
                } else {
                    fileHandlerChain.handleFile(file);
                }
            }
        }
    }
}
