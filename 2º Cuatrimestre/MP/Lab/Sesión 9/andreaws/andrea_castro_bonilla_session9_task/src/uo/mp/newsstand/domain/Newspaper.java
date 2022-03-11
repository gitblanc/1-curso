package uo.mp.newsstand.domain;

public class Newspaper extends Publication {

	public Newspaper(String name, int stock, int sales) {
		super(name, stock, sales);
	}

	@Override
	public Order generateOrders() {
		return new Order(getName(), getSales() + (getStock() * 2));
	}

	@Override
	public String serialize() {
		return "revista" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}
}
