package com.user.exception;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
}
