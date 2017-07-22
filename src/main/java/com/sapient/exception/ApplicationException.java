package com.sapient.exception;

/**
 * Custom Exception class to wrap all runtime exceptions.
 * @author pratikgupta
 *
 */
public class ApplicationException  extends  RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;

    public ApplicationException(String errorCode) {
        this.errorCode = errorCode;
    }

    public ApplicationException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(String message, Throwable cause, String errorCode) {
        super("", cause);
        this.errorCode = errorCode;
    }

    public ApplicationException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
