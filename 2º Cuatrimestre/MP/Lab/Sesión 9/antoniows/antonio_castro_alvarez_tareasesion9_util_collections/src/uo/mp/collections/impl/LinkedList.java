package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.check.NoSuchElementChecks;
import uo.mp.collections.List;

public class LinkedList<T> extends AbstractList<T> implements List<T> {
	
	
	private class Node<U> {

		
		T value;
		Node<T> next;
				
		
		Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node<T> head;
	

	

	@Override
	public boolean add(T element) {
		if (element == null)
			throw new IllegalArgumentException();
		
		if (isEmpty()) {
			addFirst(element);
			return true;
		}
		else {
			Node<T> last = getNode(size()-1);
			last.next = new Node<T>(element, null);
			numberOfElements++;
		}
		return false;
	}

	@Override
	public boolean remove(T o) {
		if (o == null)
			throw new IllegalArgumentException();
		
		if(this.contains(o)) {
			this.remove(indexOf(o));
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		numberOfElements = 0;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		return getNode(index).value;
	}

	@Override
	public T set(int index, T element) {
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		if (element == null)
			throw new IllegalArgumentException();
		
		
		Node<T> node = getNode(index);
		T old = node.value;
		node.value = element;
		return old;
	}

	
	
	@Override
	public void add(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException();
		
		if (index==0)
			addFirst(element);
		else {
			Node<T> previous = getNode(index-1);
			previous.next = new Node<T>(element, previous.next);
			numberOfElements++;
		}
	}
	
	

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		if (isEmpty()) return null;
			T value;
			
		if (index == 0) {
			value = head.value;
			head = head.next;
		} 
		else {
			Node<T> previous = getNode(index - 1);
			value = previous.next.value;
			previous.next = previous.next.next;
		}
		numberOfElements--;
		return value; 
	}

	@Override
	public int indexOf(Object o) {
		if (o == null)
		throw new IllegalArgumentException();
	
		for (int i = 0; i < this.size(); i++) {
			if(getNode(i).equals(o));
				return i;
		}
		return 0;
	}

	
	private Node<T> getNode(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		
		int position = 0;
		Node<T> node = head;
		while (position < index) {
			node = node.next;
			position++;
		}
		return node;
	}
	
	public void addFirst(T value) {
		if (value == null)
			throw new IllegalArgumentException();
		
		head = new Node<T>(value, head);
		numberOfElements++;
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
		LinkedList<T> other = (LinkedList<T>) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (numberOfElements != other.numberOfElements)
			return false;
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<T> each = head;
		for (int i = 0; i < size(); i++) {
			result.append(each.value);
			
			if (i < size() - 1) 
				result.append(",");
		}
		result.append("]");
		return result.toString();
	}






	private class LinkedListIterator implements Iterator<T> {
		
		private Node<T> next = head;
		private Node<T> lastReturned = null;
		private int nextPos = 0;
		
		
		@Override
		public boolean hasNext() {
			return next != null;
		}
		
		
		@Override
		public T next() {
			NoSuchElementChecks.isTrue(hasNext());
			
			lastReturned = next;
			next = next.next;
			nextPos++;
			return lastReturned.value;
		}
		
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException("No hay elemento a eliminar");
			}
			LinkedList.this.remove(nextPos - 1);
			nextPos--;
			lastReturned = null;
		}
	}
}
