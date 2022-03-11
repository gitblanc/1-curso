package uo.mp.newsstand.service.exception;

@SuppressWarnings("serial")
public class AlreadyExistException extends  NewsStandException {

	
	
	public AlreadyExistException() {
		super("La publicacion ya existe");
		
	}
	
	@Override
	public String getMessage() {
		return "Error: " + "La publicacion ya existe";
	}

}

