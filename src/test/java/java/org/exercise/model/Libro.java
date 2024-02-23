package java.org.exercise.model;


/**
 * Questa classe rappresenta un libro.
 * È possibile utilizzare il pattern Builder per creare un oggetto Libro in modo più flessibile.
 */
public class Libro {

    // Campi del libro

    /**
     * Il titolo del libro.
     */
    private String titolo;

    /**
     * L'autore del libro.
     */
    private String autore;

    /**
     * Il genere del libro.
     */
    private String genere;

    /**
     * L'ISBN del libro.
     */
    private String ISBN;

    // Costruttore privato e pattern Builder

    /**
     * Costruttore privato per creare un oggetto Libro utilizzando il pattern Builder.
     * Utilizzare il Builder per impostare i campi del libro.
     *
     * @param builder Il Builder utilizzato per creare l'oggetto Libro.
     */
    private Libro(Builder builder) {
        this.titolo = builder.titolo;
        this.autore = builder.autore;
        this.genere = builder.genere;
        this.ISBN = builder.ISBN;
    }

    // Metodi getter per i campi del libro

    /**
     * Restituisce il titolo del libro.
     *
     * @return Il titolo del libro.
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Restituisce l'autore del libro.
     *
     * @return L'autore del libro.
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Restituisce il genere del libro.
     *
     * @return Il genere del libro.
     */
    public String getGenere() {
        return genere;
    }

    /**
     * Restituisce l'ISBN del libro.
     *
     * @return L'ISBN del libro.
     */
    public String getISBN() {
        return ISBN;
    }

    // Classe Builder

    /**
     * Classe Builder per creare un oggetto Libro in modo flessibile.
     */
    public static class Builder {

        // Campi del Builder

        /**
         * Il titolo del libro.
         */
        private String titolo;

        /**
         * L'autore del libro.
         */
        private String autore;

        /**
         * Il genere del libro.
         */
        private String genere;

        /**
         * L'ISBN del libro.
         */
        private String ISBN;

        // Metodi setter per i campi del Builder

        /**
         * Imposta il titolo del libro.
         *
         * @param titolo Il titolo del libro.
         * @return Il Builder.
         */
        public Builder setTitolo(String titolo) {
            this.titolo = titolo;
            return this;
        }

        /**
         * Imposta l'autore del libro.
         *
         * @param autore L'autore del libro.
         * @return Il Builder.
         */
        public Builder setAutore(String autore) {
            this.autore = autore;
            return this;
        }

        /**
         * Imposta il genere del libro.
         *
         * @param genere Il genere del libro.
         * @return Il Builder.
         */
        public Builder setGenere(String genere) {
            this.genere = genere;
            return this;
        }

        /**
         * Imposta l'ISBN del libro.
         *
         * @param ISBN L'ISBN del libro.
         * @return Il Builder.
         */
        public Builder setISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        // Metodo build per creare l'oggetto Libro

        /**
         * Crea un oggetto Libro utilizzando i valori impostati nel Builder.
         *
         * @return Un oggetto Libro.
         */
        public Libro build() {
            return new Libro(this);
        }
    }
}