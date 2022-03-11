package uo.mp.newsstand.service.serializers;


import uo.mp.collections.List;
import uo.mp.exception.NotYetImplementedException;
import uo.mp.newsstand.domain.Order;

public class OrderSerializer {

	/**
	 * Returns a list of String out of a list of Orders
	 * @param orders, the list of orders to convert
	 * @return a list of String-serialized orders
	 */
	public List<String> serialize(List<Order> orders) {
		throw new NotYetImplementedException();
	}

}
