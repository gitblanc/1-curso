package uo.mp.newsstand.domain;

import uo.mp2021.util.checks.ArgumentChecks;

public class Magazine extends Publication {
	public static int WEEKLY = 7;
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;

	private int frequency;

	public Magazine(String name, int stock, int sales, int freq) {
		super(name, stock, sales);
		ArgumentChecks.isTrue( freq > 0);
		this.frequency = freq;
	}

	public int getFrequency() {
		return frequency;
	}

	public String toString() {
		return super.toString() + "\t" + getFrequency();
	}

	@Override
	public String serialize() {
		return "revista" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales() 
				+ "\t" + getFrequency();
	}

	@Override
	public Order generateOrders() {
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getFrequency() == WEEKLY) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}

}
