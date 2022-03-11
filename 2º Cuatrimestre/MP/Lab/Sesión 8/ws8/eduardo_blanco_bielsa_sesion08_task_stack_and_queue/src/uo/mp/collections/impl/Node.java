/**
 * 
 */
package uo.mp.collections.impl;

/**
 * @author blanc
 * @param <T>
 *
 */
public class Node<T> {
	Object value;
	Node<T> next;
	
	Node(Object value, Node<T> next){
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}
	
}
