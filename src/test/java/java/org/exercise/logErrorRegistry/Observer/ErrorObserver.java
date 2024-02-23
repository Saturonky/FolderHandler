package java.org.exercise.logErrorRegistry.Observer;

import java.org.exercise.logErrorRegistry.ErrorLogEntry;

public interface ErrorObserver {
    void update(ErrorLogEntry errorLogEntry);
}
