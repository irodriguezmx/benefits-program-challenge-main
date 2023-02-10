package coe.unosquare.benefits.exception;

/**
 *   Custom empty order exception
 */
public class EmptyOrderException extends Exception{
    /**
     * Instantiates a new EmptyOrderException.
     * @param errorMessage The error message
     */
    public EmptyOrderException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Instantiates a new EmptyOrderException.
     * @param errorMessage The error message
     * @param error The error description
     */
    public EmptyOrderException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
