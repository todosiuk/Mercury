package org.myapp.mercury.application.infrastructure.exception;

import org.myapp.mercury.application.infrastructure.exception.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 * 
 * @author todosuk
 *
 */
public class FlowException extends AppException {

	private static final long serialVersionUID = -2889607185988464072L;

	public FlowException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlowException(String message) {
		super(message);
	}

}
