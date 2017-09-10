package org.myapp.mercury.application.infrastructure.exception.flow;

import org.myapp.mercury.application.infrastructure.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * 
 * @author todosuk
 *
 */
public class InvalidParameterException extends FlowException {

	private static final long serialVersionUID = 4990959228756992926L;

	public InvalidParameterException(String message) {
		super(message);
	}
}
