package org.artjava.zookeeper.exception;

public class DaoException extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
