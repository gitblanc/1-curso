package uo.mp.newsstand.service.exception;

@SuppressWarnings("serial")
public class NewsStandException extends Exception {

	private String msg;

	
	public NewsStandException(String msg) {
		super(msg);
		
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return "Error " + msg;
	}

}
