package by.freebook.dao.exception;

public class DatabaseException extends ApplicationException {
    private static final long serialVersionUID = 2833009951810444747L;

    public DatabaseException() {
	super();
    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public DatabaseException(String message, Throwable cause) {
	super(message, cause);
    }

    public DatabaseException(String message) {
	super(message);
    }

    public DatabaseException(Throwable cause) {
	super(cause);
    }

}
