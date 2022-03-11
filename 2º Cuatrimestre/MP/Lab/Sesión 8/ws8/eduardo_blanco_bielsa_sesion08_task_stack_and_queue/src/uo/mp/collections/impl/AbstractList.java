/**
 * 
 */
package uo.mp.collections.impl;

/**
 * @author blanc
 *
 */
public abstract class AbstractList<T> {
	protected int numberOfElements;
	
	protected abstract int size();
	protected abstract boolean isEmpty();
	protected abstract boolean contains(T o);
	protected abstract boolean add(T element);
	protected abstract boolean remove(T o);
	public abstract boolean equals(Object obj);
}
