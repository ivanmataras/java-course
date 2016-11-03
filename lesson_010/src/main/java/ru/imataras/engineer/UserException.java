package ru.imataras.engineer;

/**
 * TODO: comment
 * @author imataras
 * @since 30.10.2010
 */

public class UserException extends Exception{

    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

}
