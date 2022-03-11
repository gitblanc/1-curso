package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;

public abstract class AbstractList<T> implements List<T> {

	protected int numberOfElements;



	@Override//
	public int size() {
		return numberOfElements;
	}

	@Override//
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override//
	public boolean contains(T o) {
		if (o == null)
			throw new IllegalArgumentException();
		
		return indexOf(o) >= 0;
	}

	@Override
	public boolean add(T element) {
		if (element == null)
			throw new IllegalArgumentException();
		
		add(size(), element);
		return true;
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
		
		return get(index);
	}

	@Override
	public T set(int index, T element) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
				
		if (element == null)
			throw new IllegalArgumentException();
		
		return set(index, element);
	}

	@Override
	public void add(int index, T element) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
				
		if (element == null)
			throw new IllegalArgumentException();
		
		add(index, element);
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		return remove(index);
	}

	@Override
	public int indexOf(Object o) {
	if (o == null)
		throw new IllegalArgumentException();
	
	 return indexOf(o);
	}

	public abstract Iterator<T> iterator();

	
	
	@Override
	public int hashCode() {
		int result = 1;
		for (int i = 0; i < size(); i++){
			T element = this.get(i);
			result = 31 * result + element.hashCode();
		}
		return result;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof List))
			return false;
		List<T> other = (List<T>) obj;
		for (int i = 0; i < size(); i++) {
			T o1 = this.get(i);
			T o2 = other.get(i);
			if(!o1.equals(o2))
				return false;
			}
		return true;
	}

	
	
}