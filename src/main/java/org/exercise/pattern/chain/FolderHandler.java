package org.exercise.pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.exercise.pattern.visitor.FileVisitor;

import java.io.File;

@Slf4j
public class FolderHandler implements FileHandlerChain {
    private final FileHandlerChain next;

    public FolderHandler(FileHandlerChain next) {
        this.next = next;
    }

    @Override
    public void handle(File file, FileVisitor visitor) {
        if (file.isDirectory()) {
            visitor.visitFolder(file);
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    // Gestione delle sottocartelle
                    if (f.isDirectory()) {
                        handle(f, visitor); // Gestione ricorsiva delle sottocartelle
                    } else {
                        next.handle(f, visitor); // Passa il controllo dei file al gestore successivo
                    }
                }
            }
        } else {
            next.handle(file, visitor); // Passa il controllo dei file al gestore successivo
        }
    }
}
