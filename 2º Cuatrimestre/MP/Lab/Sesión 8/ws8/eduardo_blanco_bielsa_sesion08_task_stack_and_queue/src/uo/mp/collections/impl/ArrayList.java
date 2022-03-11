package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

public class ArrayList<T> extends AbstractList<T> implements List<T> {
	public static final int INITIAL_CAPACITY = 20;

	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		elements = (T[]) new Object[capacity];
		numberOfElements = 0;
	}

	public ArrayList() {
		// elements = new Object[INITIAL_CAPACITY];
		// numberOfElements = 0;
		this(INITIAL_CAPACITY);
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(T o) {
		return search(o) != -1;
	}

	private int search(Object o) {
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element != null);
		if (element == null) {
			return false;
		}
		if (memoryFull()) {
			increaseMemory(size() + 1);
		}
		elements[numberOfElements] = element;
		numberOfElements++;

		return true;
	}
	
	/**
	 * Devuelve true si elements está lleno
	 * 
	 * @return Devuelve true si elements está lleno
	 */
	private boolean memoryFull() {
		return size() == numberOfElements;
	}

	private void increaseMemory(int i) {
		if(i > elements.length) {
			@SuppressWarnings("unchecked")
			T[] aux = (T[]) new Object[Math.max(i, 2*elements.length)];
			System.arraycopy(elements, 0, aux, 0, elements.length);
			elements = (T[]) aux;
		}

	}

	@Override
	public boolean remove(T o) {
		ArgumentChecks.isTrue(o != null);
		if(indexOf(o) != -1) {
			return remove(indexOf(o)) != null;
		} else {
			return false;
		}
	}
		

	@Override
	public void clear() {
		for (int i = 0; i < size(); i++) {
			elements[i] = null;
		}
		numberOfElements = 0;
	}

	
	public T get(int index) {
		ArgumentChecks.isTrueIndex(index >= 0 && index < size());
		return elements[index];
	}

	@Override
	public T set(int index, T element) {
		ArgumentChecks.isTrueIndex(index >= 0);
		T before = elements[index];
		elements[index] = (T) element;
		return before;

	}

	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrueIndex(index >= 0 && index <= size());
		ArgumentChecks.isTrue(element != null);
		
		if(memoryFull()) {
			increaseMemory(size() + 1);
		}
		
		for(int i = size(); i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = (T) element;
		numberOfElements++;

	}

	@Override
	public T remove(int index) {
		T value = elements[index];

		for (int i = index; i < size() - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size()] = null;
		numberOfElements--;
		return value;

	}

	@Override
	public int indexOf(Object o) {
		return search(o);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof List)) return false;
		
		@SuppressWarnings("unchecked")
		List<T> that = (List<T>) obj;
		if(this.size() != that.size()) return false;
		
		for(int i = 0; i < size(); i++) {
			T e1 = this.get(i);
			T e2 = that.get(i);
			if(!(e1.equals(e2))) {
				return false;
			}
		}
		return true;
	}
			
		
		

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<T>{

		private int nextPos = 0;
		private T next = null;
		@Override
		public boolean hasNext() {
			return nextPos < size();
		}

		@Override
		public T next() {
			NoSuchElementChecks.isTrue(hasNext(), "No hay elementos");
			next = elements[nextPos];
			nextPos++;
			return (T) this.next;
		}
		
	}

}
