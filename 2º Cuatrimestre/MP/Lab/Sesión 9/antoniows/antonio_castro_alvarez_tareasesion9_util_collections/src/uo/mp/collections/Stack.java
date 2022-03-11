package uo.mp.collections;

import java.util.EmptyStackException;

/**
 * The {@code Stack} interface represents a last-in-first-out (LIFO) stack of
 * objects. It has three operations. The usual {@code push} and {@code pop} 
 * operations are provided, as well as a method to {@code peek} at
 * the top item on the stack. 
 */
 public interface Stack<E>
{	
	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack
	 */
	public int size();
	
	/**
	 * Tests if this stack is empty.
	 * 
	 * @return {@code true} if this stack contains no elements; {@code false} otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Pushes (adds) an element onto the top of the stack.
	 * 
	 * @param element the object to be pushed onto this stack
	 * @return the element argument
	 */
	public E push(E element);
	
	/**
	 * Removes and returns the object at the top of this stack.
	 * 
	 * @return the object removed from this stack
     * @throws EmptyStackException if this stack is empty
	 */
	public E pop();
	
	/**
	 * Returns the object at the top of the stack without removing it.
	 * 
	 * @return the object at the top of this stack
     * @throws EmptyStackException if this stack is empty 
	 */
	public E peek();	
}
