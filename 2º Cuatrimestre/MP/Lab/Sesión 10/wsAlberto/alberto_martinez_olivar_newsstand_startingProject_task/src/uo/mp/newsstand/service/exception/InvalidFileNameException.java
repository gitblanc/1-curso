package uo.mp.newsstand.service.exception;

@SuppressWarnings("serial")
public class InvalidFileNameException extends NewsStandException {

	
	public InvalidFileNameException(String name) {
		super("El nombre del archivo debe ser mayor que 5");
	}
	
	@Override
	public String getMessage() {
		return "Error: " + "El nombre del archivo debe ser mayor que 5";
	}

}