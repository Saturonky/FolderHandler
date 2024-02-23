package java.org.exercise.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainTextDocument {
    private static final Logger log = LoggerFactory.getLogger(MainTextDocument.class);

    private Libro libro = new Libro.Builder()
            .setTitolo("qui inserisci il titolo")
            .setAutore("qui inserisci l'autore")
            .setGenere("qui inserisci il genere")
            .setISBN("qui inserisci il codice ISBN")
            .build();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        log.info("Creazione di un nuovo documento di testo:");

        System.out.print("Inserisci il titolo (opzionale, premi Invio per saltare): ");
        String title = scanner.nextLine();

        System.out.print("Inserisci il corpo (opzionale, premi Invio per saltare): ");
        String body = scanner.nextLine();

        System.out.print("Inserisci l'autore (opzionale, premi Invio per saltare): ");
        String author = scanner.nextLine();

        TextDocument.Builder builder = new TextDocument.Builder();

        if (!author.isEmpty() && !title.isEmpty() && !body.isEmpty()) {

            builder
                    .withTitle(title)
                    .withBody(body)
                    .withAuthor(author);
        }

        try {
            TextDocument document = builder.build();

            log.info("Documento creato con successo: {}", document);
        } catch (IllegalStateException e) {
            log.error("Errore: {}", e.getMessage());
            log.error("Assicurati di inserire almeno uno dei campi opzionali.");
        }

        scanner.close();
    }
}
