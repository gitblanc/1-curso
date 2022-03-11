package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.check.NoSuchElementChecks;
import uo.mp.collections.List;

public class ArrayList<T> extends AbstractList<T> implements List<T> {
	
	
	final static int INITIAL_CAPACITY = 20;
	
	
	T[] elements;
	
	
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		elements = (T[]) new Object[capacity];
		numberOfElements = 0;
	}
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	
	public ArrayList(List<T> list) {
		this(INITIAL_CAPACITY);
		for (int i = 0 ; i < list.size(); i++) {
			this.add(list.get(i));
		}
	}



	void moreMemory(int numElem) {
		if (numElem > elements.length) {
			@SuppressWarnings("unchecked")
			T[] aux = (T[]) new Object[Math.max( numElem, 2*elements.length)];
			System.arraycopy(elements, 0, aux, 0, elements.length);
			elements=aux;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	
	private class ArrayListIterator implements Iterator<T> {

		private int nextPos = 0;
		private T next = null;
		
		
		@Override
		public boolean hasNext() {
			return nextPos < size();
		}

		@Override
		public T next() {
			NoSuchElementChecks.isTrue(hasNext());
			next = elements[nextPos];
			nextPos++;
			return next;
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements =  (T[]) new Object[INITIAL_CAPACITY];
		numberOfElements = 0;
	}
	
	

	
	
	
	@Override
	public boolean add(T element) {
		if (element == null)
			throw new IllegalArgumentException();
		
		if (size() >= elements.length)
				moreMemory(size()+1);
			elements[size()] = element;
			numberOfElements++;
			
			for (T o : elements) {
				if(o == element)
					return true;
			}
		return false;
	}

	@Override
	public boolean remove(T o) {
		if (o == null)
			throw new IllegalArgumentException();
		
		if(this.contains(o)){
			this.remove(indexOf(o));
			return true;
		}
		return false;
	}




	@Override
	public T get(int index) {
		if (index < 0 || (index >= size() && size() != 0) || size() == 0)
			throw new IndexOutOfBoundsException();
		
		return elements[index];
	}

	@Override
	public T set(int index, T element) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
				
		if (element == null)
			throw new IllegalArgumentException();
		
		elements[index]=element;
		return element;
	}

	@Override
	public void add(int index, T element) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
				
		if (element == null)
			throw new IllegalArgumentException();
		
		if (size() >= elements.length)
			moreMemory(size()+1);
		
			for(int i=size(); i>=index; i--)
				elements[i+1] = elements[i];
			
			elements[index] = element;
			numberOfElements++;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		T value = elements[index];
		for(int j=index; j<size()-1; j++)
		elements[j] = elements[j+1];
		numberOfElements--;
		return value;
	}

	@Override
	public int indexOf(Object o) {
	if (o == null)
		throw new IllegalArgumentException();
	
	 //No logro encontrar por qué no funciona
		for (int i = 0; i < this.size(); i++) {
			if (o.equals(elements[i]))
				return i;
		}
		return -1;
	}


	@SuppressWarnings("unchecked")
	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayList<T> other = (ArrayList<T>) obj;
		if (other.size() != size())
			return false;
		for (int i = 0; i < size(); i++) {
			if (!other.get(i).equals(get(i)))
				return false;
		} 
		return true;
	}

	
}
