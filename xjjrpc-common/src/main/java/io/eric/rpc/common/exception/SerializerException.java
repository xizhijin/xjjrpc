package io.eric.rpc.common.exception;

public class SerializerException extends RuntimeException {

    private static final long serialVersionUID = 67836736366L;

    public SerializerException(final Throwable e) {
        super(e);
    }

    public SerializerException(final String message) {
        super(message);
    }

    public SerializerException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
