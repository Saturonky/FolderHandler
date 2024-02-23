package org.exercise;

import lombok.extern.slf4j.Slf4j;
import org.exercise.file.FileExplorer;
import org.exercise.file.FileHandlerChain;
import org.exercise.file.FileLoggingVisitor;

import java.io.File;
import java.io.IOException;
@Slf4j
public class Main {
    public static void main(String[] args) {
        final File rootFolder = new File("C:\\Users\\terzi\\Desktop\\Cartelle\\Games\\Athena's Armor Set Search for MHW v0.61b\\Data\\Languages\\Italiano");

        final FileLoggingVisitor visitor = new FileLoggingVisitor();
        final FileHandlerChain chain = new FileHandlerChain(visitor);

        final FileExplorer explorer = new FileExplorer(chain);
        explorer.explore(rootFolder);
    }
}