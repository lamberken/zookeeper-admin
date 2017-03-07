package org.artjava.zookeeper.exception;

public class SerializeException extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;

    public SerializeException() {
    }

    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializeException(Throwable cause) {
        super(cause);
    }
}
