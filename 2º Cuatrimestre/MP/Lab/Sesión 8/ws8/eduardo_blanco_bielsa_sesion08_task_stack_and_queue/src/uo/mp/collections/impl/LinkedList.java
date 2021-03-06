package uo.mp.collections.impl;

import java.util.EmptyStackException;
import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp.collections.Queue;
import uo.mp.collections.Stack;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

public class LinkedList<T> extends AbstractList<T> implements List<T>, Queue<T>, Stack<T>{
	public static final int MAX_NUMBER_OF_ELEMENTS = 10;
	private Node<T> head;

	public LinkedList() {
		this.head = null;
		this.numberOfElements = 0;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	private void addFirst(T value) {
		head = new Node<T>(value, this.head);
		numberOfElements++;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(T o) {
		return search(o) != -1;
	}

	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element != null);
		if (element == null) {
			return false;
		}
		if (isEmpty()) {
			this.addFirst(element);
		} else {
			Node<T> last = getNode(size() - 1);
			last.next = new Node<T>(element, null);
			numberOfElements++;
		}
		return true;
	}

	@Override
	public boolean remove(T o) {
		ArgumentChecks.isTrue(o != null);
		int pos = indexOf(o);
		if (pos == -1) {
			return false;
		} else {
			remove(pos);
			return true;
		}
	}

	private int search(T o) {
		Node<T> aux = head;
		int i = 0;
		while (aux != null && !aux.value.equals(o)) {
			aux = aux.next;
			i++;
		}
		return aux == null ? -1 : i;
	}

	@Override
	public void clear() {
		this.head = null;
		this.numberOfElements = 0;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		ArgumentChecks.isTrueIndex(index >= 0 && index < size());
		return (T) getNode(index).value;
	}

	private Node<T> getNode(int index) {
		Node<T> aux = head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T element) {
		getNode(index).value = element;
		return (T) this;
	}

	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrueIndex(index >= 0 && index <= size());
		ArgumentChecks.isTrue(element != null);
		if (index == 0) {
			this.addFirst(element);
		} else {
			Node<T> previous = getNode(index - 1);
			previous.next = new Node<T>(element, previous.next);
			numberOfElements++;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		Object value;
		if (index == 0) {
			value = head.value;
			head = head.next;
		} else {
			Node<T> previous = getNode(index - 1);
			value = previous.next.value;
			previous.next = previous.next.next;
		}
		numberOfElements--;// siempre que se elimina un nodo, se decrementa el contador
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		return search((T) o);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj.getClass() == ArrayList.class) {
			@SuppressWarnings("unchecked")
			ArrayList<T> other = (ArrayList<T>) obj;
			if (size() != other.size()) {
				return false;
			}
			if (isEmpty() && other.isEmpty()) {
				return true;
			}

			for (int i = 0; i < size(); i++) {
				if (!get(i).equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		if (obj.getClass() == LinkedList.class) {
			@SuppressWarnings("unchecked")
			List<T> other = (List<T>) obj;
			if (size() != other.size()) {
				return false;
			}
			if (isEmpty() && other.isEmpty()) {
				return true;
			}

			for (int i = 0; i < size(); i++) {
				if (!get(i).equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Object> {

		private Node<T> next = head;
		private Node<T> lastReturned = null;
		private int nextPos = 0;

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public Object next() {
			NoSuchElementChecks.isTrue(hasNext(), "No hay elementos");
			this.lastReturned = next;
			this.next = next.next;
			this.nextPos++;
			return this.lastReturned;

		}

		/**
		 * Elimina el obejto de la lista que se ha cogido la ?ltima vez con un next
		 * Necesita previamente hacer un next para que se pueda ejecutar
		 */
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException("No hay elementos a eliminar");
			}
			LinkedList.this.remove(nextPos - 1);// asi se dice que es el remove de la clase linkedList
			nextPos--;
			this.lastReturned = null;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("[");
			Node<T> each = head;
			for(int i = 0; i < size(); i++) {
				result.append(each.value);
					if(i < size() - 1) {
						result.append(", ");
					}
				each = each.next;
			}
			result.append("]");
			return result.toString();
		}
	}

	@Override
	public T push(T element) {
		ArgumentChecks.isTrue(numberOfElements <= MAX_NUMBER_OF_ELEMENTS);
		this.addFirst(element);
		return element;
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		return this.remove(0);
	}

	@Override
	public void enqueue(T element) {
		ArgumentChecks.isTrue(element != null);
		add(element);
		
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new EmptyStackException();
		return this.remove(0);
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return this.get(0);
	}


}
