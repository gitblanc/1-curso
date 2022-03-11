package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

public class ArrayList implements List {
	public static final int INITIAL_CAPACITY = 20;

	private Object[] elements;
	private int numberOfElements;

	public ArrayList(int capacity) {
		elements = new Object[capacity];
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
	public boolean contains(Object o) {
		return search(o) != -1;
	}

	private int search(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean add(Object element) {
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
			Object[] aux = new Object[Math.max(i, 2*elements.length)];
			System.arraycopy(elements, 0, aux, 0, elements.length);
			elements = aux;
		}

	}

	@Override
	public boolean remove(Object o) {
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

	@Override
	public Object get(int index) {
		ArgumentChecks.isTrueIndex(index >= 0 && index < size());
		return elements[index];
	}

	@Override
	public Object set(int index, Object element) {
		ArgumentChecks.isTrueIndex(index >= 0);
		Object before = elements[index];
		elements[index] = element;
		return before;

	}

	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrueIndex(index >= 0 && index <= size());
		ArgumentChecks.isTrue(element != null);
		
		if(memoryFull()) {
			increaseMemory(size() + 1);
		}
		
		for(int i = size(); i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		numberOfElements++;

	}

	@Override
	public Object remove(int index) {
		Object value = elements[index];

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
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj.getClass() == ArrayList.class) {
			ArrayList other = (ArrayList) obj;
			if(size() != other.size()) {
				return false;
			}
			if(isEmpty() && other.isEmpty()) {
				return true;
			}
			
			for(int i = 0; i < size(); i++) {
				if(!get(i).equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		if(obj.getClass() == LinkedList.class) {
			List other = (List) obj;
			if(size() != other.size()) {
				return false;
			}
			if(isEmpty() && other.isEmpty()) {
				return true;
			}
			
			for(int i = 0; i < size(); i++) {
				if(!get(i).equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<Object>{

		private int nextPos = 0;
		private Object next = null;
		@Override
		public boolean hasNext() {
			return nextPos < size();
		}

		@Override
		public Object next() {
			NoSuchElementChecks.isTrue(hasNext(), "No hay elementos");
			next = elements[nextPos];
			nextPos++;
			return this.next;
		}
		
	}

}
