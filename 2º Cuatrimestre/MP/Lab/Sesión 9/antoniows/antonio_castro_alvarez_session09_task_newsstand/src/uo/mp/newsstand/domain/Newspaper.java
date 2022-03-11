package uo.mp.newsstand.domain;

import uo.mp2021.util.checks.ArgumentChecks;

public class Newspaper extends Publication {

	public Newspaper(String name, int stock, int sales) {
		super(name, stock, sales);
		ArgumentChecks.isTrue(name != null);
		ArgumentChecks.isTrue(stock >= 0);
		ArgumentChecks.isTrue(sales >= 0);
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
