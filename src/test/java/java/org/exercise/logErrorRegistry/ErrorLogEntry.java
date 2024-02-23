package java.org.exercise.logErrorRegistry;

import java.util.Date;

/**
 * La classe ErrorLogEntry rappresenta una voce di log per un errore.
 * Contiene un messaggio di errore e un timestamp.
 */
public class ErrorLogEntry {
    private String errorMessage;
    private Date timestamp;

    /**
     * Costruttore privato per creare una nuova istanza di ErrorLogEntry utilizzando il Builder.
     *
     * @param builder L'oggetto Builder utilizzato per creare l'istanza di ErrorLogEntry.
     */
    private ErrorLogEntry(Builder builder) {
        this.errorMessage = builder.errorMessage;
        this.timestamp = builder.timestamp;
    }

    /**
     * Restituisce il messaggio di errore.
     *
     * @return Il messaggio di errore.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Restituisce il timestamp.
     *
     * @return Il timestamp.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Restituisce una rappresentazione testuale dell'oggetto ErrorLogEntry.
     *
     * @return La rappresentazione testuale dell'oggetto ErrorLogEntry.
     */
    @Override
    public String toString() {
        return "ErrorLogEntry{" +
                "errorMessage='" + errorMessage + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    /**
     * Il Builder è un pattern di progettazione utilizzato per creare oggetti complessi passo dopo passo.
     * Per ErrorLogEntry, il Builder viene utilizzato per creare istanze con valori opzionali.
     */
    public static class Builder {
        private String errorMessage;
        private Date timestamp;

        /**
         * Imposta il messaggio di errore.
         *
         * @param errorMessage Il messaggio di errore.
         * @return L'oggetto Builder.
         */
        public Builder setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        /**
         * Imposta il timestamp.
         *
         * @param timestamp Il timestamp.
         * @return L'oggetto Builder.
         */
        public Builder setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Crea e restituisce un'istanza di ErrorLogEntry utilizzando i valori impostati nel Builder.
         *
         * @return Un'istanza di ErrorLogEntry.
         */
        public ErrorLogEntry build() {
            return new ErrorLogEntry(this);
        }
    }
}