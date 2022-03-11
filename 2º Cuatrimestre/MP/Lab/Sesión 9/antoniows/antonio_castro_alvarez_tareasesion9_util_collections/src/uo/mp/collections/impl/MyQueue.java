/**
 * 
 */
package uo.mp.collections.impl;

import java.util.NoSuchElementException;

import uo.mp.collections.Queue;

/**
 * @author Antonio Castro
 *
 */
public class MyQueue<T> extends LinkedList<T> implements Queue<T> {

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public void enqueue(T element) {
		super.add(size(), element);		
	}

	@Override
	public T dequeue() {
		if (size() == 0)
			throw new IllegalArgumentException();
		
		T first = get(0);
		int size = size();
		for (int i = 0; i < size - 1; i++) {
			add(i, get(i+1));
			remove(i+1);
		}
		remove(size - 1);
			
		return first;
	}

	@Override
	public T peek() {
		if (size() <= 0)
			throw new NoSuchElementException();
		
		return get(0);
	} 

}
