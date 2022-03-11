package sintactico;

public class Nodo {
	private String etiqueta;
	private Double valor;
	private Nodo izda;
	private Nodo dcha;


	public Nodo(String etiqueta, Double valor, Nodo izda, Nodo dcha){
		this.etiqueta = etiqueta;
		this.valor=valor;
		this.izda=izda;
		this.dcha=dcha;
	}

	public Nodo (String etiqueta, Nodo izda, Nodo dcha) {
		this(etiqueta, null, izda, dcha);
		
	}
	
	public Nodo (String etiqueta, Nodo dcha) {
		this(etiqueta, null, null, dcha);
		
	}
	
	public Nodo(String etiqueta, Double valor, Nodo dcha){
		this(etiqueta, valor, null, dcha);
	}

	public Nodo(String etiqueta, Double valor){
		this(etiqueta, valor, null, null);
	}
	
	public Nodo(String etiqueta){
		this(etiqueta, null, null, null);
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public void setValor (Double valor){
		this.valor=valor;
	}

	public Double getValor(){
		return valor;
	}

	public Nodo getIzda(){
		return izda;
	}

	public void setIzda(Nodo izda){
		this.izda=izda;
	}

	public void setDcha(Nodo dcha){
		this.dcha=dcha;
	}

	public Nodo getDcha(){
		return dcha;
	}

	public String evaluateToString(){
		String temp="";
		if(izda!=null)
			temp+=izda.evaluateToString();
		temp+=etiqueta;
		if(dcha!=null)
			temp+=dcha.evaluateToString();
		return temp;
	}

	public void printTree(int level, boolean left, String prefix) {
		if(prefix.length() > 0)
			System.out.println(prefix + "|__" + etiqueta);
		else
			System.out.println("---"+etiqueta);

		if(left) {
			if(izda != null)
				izda.printTree(level+1, true, prefix+"|  ");
			if(dcha != null)
				dcha.printTree(level+1, false, prefix+"|  ");
		}
		else {
			if(izda != null)
				izda.printTree(level+1, true, prefix+"   ");
			if(dcha != null)
				dcha.printTree(level+1, false, prefix+"   ");
		}
	}

}
