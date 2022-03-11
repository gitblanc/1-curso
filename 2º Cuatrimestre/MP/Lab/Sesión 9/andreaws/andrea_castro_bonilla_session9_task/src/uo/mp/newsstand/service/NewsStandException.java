package uo.mp.newsstand.service;

@SuppressWarnings("serial")
public class NewsStandException extends Exception {

	private String publicationName;

	public NewsStandException(String name, String msg) {
		super(msg);
		publicationName = name;
	}

	@Override
	public String getMessage() {
		return "Error en la publicaci�n con el nombre: " + publicationName + " " + getMessage();
	}
}
