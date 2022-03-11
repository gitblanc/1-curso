package uo.mp.s4.dome.model;

public interface Borrowable {
	boolean isAvailable();
	void borrow();
	void giveBack();
}
