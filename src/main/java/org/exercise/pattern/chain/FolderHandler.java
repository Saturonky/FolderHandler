package org.exercise.pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FolderHandler implements FileHandlerChain {
    private final FileHandlerChain next;

    public FolderHandler(FileHandlerChain next) {
        this.next = next;
    }

    @Override
    public void handle(File file, FileVisitor visitor) throws IOException {
        if (file.isDirectory()) {
            handleDirectory(file, visitor);
        } else {
            next.handle(file, visitor); // Passa il controllo dei file al gestore successivo
        }
    }

    private void handleDirectory(File directory, FileVisitor visitor) {
        try {
            visitor.visitFolder(directory);
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        handle(file, visitor);
                    } else {
                        next.handle(file, visitor);
                    }
                }
            }
        } catch (IOException e) {
            log.error("Errore durante la visita della cartella " + directory.getPath(), e);
        }
    }
}
