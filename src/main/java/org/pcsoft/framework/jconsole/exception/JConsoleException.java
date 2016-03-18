package org.pcsoft.framework.jconsole.exception;

/**
 * Created by Christoph on 18.03.2016.
 */
public class JConsoleException extends RuntimeException {

    public JConsoleException() {
    }

    public JConsoleException(String message) {
        super(message);
    }

    public JConsoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public JConsoleException(Throwable cause) {
        super(cause);
    }
}
