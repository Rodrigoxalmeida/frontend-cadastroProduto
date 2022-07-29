package br.com.cadastro.service.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String message) {
		super(message);
	}
	
	public ObjectNotFoundException(String message, Exception exception) {
		super(message, exception);
	}
	
	public ObjectNotFoundException(Exception exception) {
		super(exception);
	}

}
