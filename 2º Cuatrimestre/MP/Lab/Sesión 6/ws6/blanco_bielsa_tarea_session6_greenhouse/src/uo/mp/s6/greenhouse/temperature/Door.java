package uo.mp.s6.greenhouse.temperature;

/**
 * <p>Title: Door</p>
 * <p>Description: Clase que simula una puerta.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Door implements VentilationDevice{

	private boolean opened = false;
	protected int id;
	
	public Door(int id) {
		this.id = id;
	}

	@Override
	public boolean isOpened() {
		return this.opened;
	}
	
	@Override
	public void open(){
		if ( ! opened) {
			showOpeningMessage();
			opened = true;
		}
	}

	@Override
	public void close(){
		if ( opened) {
			showClosingMessage();
			opened = false;
		}
	}

	protected void showOpeningMessage() {
		System.out.println ("  Por favor, abre la puerta " + id);
	}
	
	protected void showClosingMessage() {
		System.out.println ("  Por favor, cierra la puerta  " + id);
	}
}
