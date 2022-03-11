package uo.mp.collections;

/**
 * An ordered collection (also known as a <i>sequence</i>). The user of this
 * interface has precise control over where in the list each element is
 * inserted. The user can access elements by their integer index (position in
 * the list), and search for elements in the list.
 * <p>
 */
public interface List<T> extends Collection<T> {

	// -- Positional access operations

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range (
	 *                                   {@code index < 0 || index >= size()})
	 */
	T get(int index);

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (
	 *                                   {@code index < 0 || index >= size()})
	 */
	public T set(int index, T element);

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * @param index,   index at which the specified element is to be inserted
	 * @param element, the element to be inserted
	 * @throws IllegalArgumentException  if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range (
	 *                                   {@code index < 0 || index > size()})
	 */
	void add(int index, T element);

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 *
	 * @param index, the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (
	 *                                   {@code index < 0 || index >= size()})
	 */
	T remove(int index);

	// -- Search operations

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index {@code i} such that
	 * {@code (o == null ? get(i) == null : o.equals(get(i)))}, or -1 if there is no
	 * such index.
	 *
	 * @param o, the element to search for
	 * @return the index of the first occurrence of the specified element in this
	 *         list, or -1 if this list does not contain the element
	 */
	int indexOf(Object o);

	// Comparison and hashing

	/**
	 * Compares the specified T with this list for equality. Returns {@code true} if
	 * and only if: - the specified T is also a list, - both lists have the same
	 * size, and - all corresponding pairs of elements in the two lists are
	 * <i>equal</i>. In other words, two lists are defined to be equal if they
	 * contain the same elements in the same order. This definition ensures that the
	 * equals method works properly across different implementations of the
	 * <tt>List</tt> interface.
	 *
	 * @param o, the T to be compared for equality with this list
	 * @return {@code true} if the specified T is equal to this list
	 */
	boolean equals(Object o);

	/**
	 * Returns the hash code value for this list. The hash code of a list is defined
	 * to be the result of the following calculation:
	 * 
	 * <pre>
	 * int hashCode = 1;
	 * for (T e : list)
	 * 	hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
	 * </pre>
	 * 
	 * This ensures that {@code list1.equals(list2)} implies that
	 * {@code list1.hashCode() == list2.hashCode()} for any two lists, {@code list1}
	 * and {@code list2}, as required by the general contract of {@link T#hashCode}.
	 *
	 * @return the hash code value for this list
	 * @see T#equals(T)
	 * @see #equals(T)
	 */
	int hashCode();
}
