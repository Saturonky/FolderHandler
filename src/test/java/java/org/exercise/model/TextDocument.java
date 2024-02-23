package java.org.exercise.model;

import java.util.Optional;

public final class TextDocument {
    private final Optional<String> title;
    private final Optional<String> body;
    private final Optional<String> author;

    private TextDocument(Optional<String> title, Optional<String> body, Optional<String> author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public Optional<String> getBody() {
        return body;
    }

    public Optional<String> getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "'" + title.orElse("Nessun titolo specificato") + '\'' + "\n" +
                "'" + body.orElse("Nessun corpo specificato") + '\'' + "\n" +
                "'" + author.orElse("Nessun autore specificato") + '\'' + "\n" +
                '}';
    }

    public static class Builder {
        private String title;
        private String body;
        private String author;

        public Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public TextDocument build() {
            if (title == null && body == null && author == null) {
                throw new IllegalStateException("Titolo, corpo e autore sono obbligatori.");
            }
            return new TextDocument(Optional.ofNullable(title), Optional.ofNullable(body), Optional.ofNullable(author));
        }
    }
}
