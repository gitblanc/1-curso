package uo.mp.newsstand.domain;

import uo.mp.checks.ArgumentsCheck;

public class Order {
	private String name;
	private int quantity;
	
	public Order(String name, int quantity){
		ArgumentsCheck.isTrue( name != null );
		ArgumentsCheck.isTrue( name.trim().isEmpty() == false );
		ArgumentsCheck.isTrue( quantity > 0 );
		
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString(){
		return "Order: " + getName() + "\t" + getQuantity();
	}
	
	public String serialize(){
		return  getName() + "\t" + getQuantity();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
