package uo.mp.newsstand.domain;

import uo.mp.checks.ArgumentsCheck;

public abstract class Publication {
	private String name;
	private int instock;
	private int sales;

	public Publication(String name, int stock, int sales) {
		ArgumentsCheck.isTrue( name != null );
		ArgumentsCheck.isTrue( name.trim().isEmpty() == false );
		ArgumentsCheck.isTrue( stock > 0 );
		ArgumentsCheck.isTrue( sales > 0 );
		this.name = name;
		this.instock = stock;
		this.sales = sales;
	}

	public abstract Order generateOrders();
	public abstract String serialize();

	public String getName() {
		return name;
	}

	public int getStock() {
		return instock;
	}

	public int getSales() {
		return sales;
	}

	public String toString() {
		return getName() + "\t" + getStock() + "\t" + getSales();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
