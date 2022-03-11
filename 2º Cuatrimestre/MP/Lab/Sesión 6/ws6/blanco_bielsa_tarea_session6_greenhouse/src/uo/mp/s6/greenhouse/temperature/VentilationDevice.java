package uo.mp.s6.greenhouse.temperature;

public interface VentilationDevice {
	
	void open();
	void close();
	boolean isOpened();
}
