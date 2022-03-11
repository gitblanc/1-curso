/**
 * 
 */
package uo.mp.collections.impl;

import uo.mp.collections.Stack;

/**
 * @author Antonio Castro
 *
 */
public class MyStack<T> extends ArrayList<T> implements Stack<T> {

	@Override
	public T push(T element) {
		add(element);
		return element;
	}

	@Override
	public T pop() {
		T aux = get(size() - 1);
		remove(size() - 1);
		return aux;
	}

	@Override
	public T peek() {
		return get(size() - 1);
	}
	
	
}
