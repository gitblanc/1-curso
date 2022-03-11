package uo.mp.collections.impl;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.NoSuchElementChecks;

public class LinkedList implements List {
	private Node head;
	private int counter;

	public LinkedList() {
		this.head = null;
		this.counter = 0;
	}

	@Override
	public int size() {
		return counter;
	}

	private void addFirst(Object value) {
		head = new Node(value, this.head);
		counter++;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return search(o) != -1;
	}

	@Override
	public boolean add(Object element) {
		ArgumentChecks.isTrue(element != null);
		if (element == null) {
			return false;
		}
		if (isEmpty()) {
			this.addFirst(element);
		} else {
			Node last = getNode(size() - 1);
			last.next = new Node(element, null);
			counter++;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isTrue(o != null);
		int pos = indexOf(o);
		if (pos == -1) {
			return false;
		} else {
			remove(pos);
			return true;
		}
	}

	private int search(Object o) {
		Node aux = head;
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
		this.counter = 0;

	}

	@Override
	public Object get(int index) {
		ArgumentChecks.isTrueIndex(index >= 0 && index < size());
		return getNode(index).value;
	}

	private Node getNode(int index) {
		Node aux = head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux;
	}

	@Override
	public Object set(int index, Object element) {
		getNode(index).value = element;
		return this;
	}

	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrueIndex(index >= 0 && index <= size());
		ArgumentChecks.isTrue(element != null);
		if (index == 0) {
			this.addFirst(element);
		} else {
			Node previous = getNode(index - 1);
			previous.next = new Node(element, previous.next);
			counter++;
		}

	}

	@Override
	public Object remove(int index) {
		Object value;
		if (index == 0) {
			value = head.value;
			head = head.next;
		} else {
			Node previous = getNode(index - 1);
			value = previous.next.value;
			previous.next = previous.next.next;
		}
		counter--;// siempre que se elimina un nodo, se decrementa el contador
		return value;
	}

	@Override
	public int indexOf(Object o) {
		return search(o);
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
			ArrayList other = (ArrayList) obj;
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
			List other = (List) obj;
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

	@Override
	public Iterator<Object> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Object> {

		private Node next = head;
		private Node lastReturned = null;
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
		 * Elimina el obejto de la lista que se ha cogido la última vez con un next
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
			Node each = head;
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
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            String str = "[";
            for (int i = 0; i < size() - 1; i++) {
                str += get(i).toString() + ",";
            }
            str += get(size() - 1).toString() + "]";
            return str;
        }
    }
}
