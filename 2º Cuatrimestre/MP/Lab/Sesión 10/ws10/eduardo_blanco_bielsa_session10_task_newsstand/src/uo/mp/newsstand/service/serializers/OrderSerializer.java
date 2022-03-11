package uo.mp.newsstand.service.serializers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Order;

public class OrderSerializer {

	/**
	 * Returns a list of String out of a list of Orders
	 * @param orders, the list of orders to convert
	 * @return a list of String-serialized orders
	 */
	public List<String> serialize(List<Order> orders) {
		List<String> res = new ArrayList<>(); 
		for(Order order : orders) {
			res.add(order.serialize());
		}
		return res;
	}

}
