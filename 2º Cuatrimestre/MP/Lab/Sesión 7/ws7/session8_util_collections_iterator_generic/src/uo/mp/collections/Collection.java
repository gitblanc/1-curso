package uo.mp.collections;

/**
 * The root interface in the <i>collection hierarchy</i>. A collection
 * represents a group of Ts, known as its <i>elements</i>. Some collections
 * allow duplicate elements and others do not. Some are ordered and others
 * unordered. This interface is typically used to pass collections around and
 * manipulate them where maximum <i>generality</i> is desired.
 */
public interface Collection<T> extends Iterable<T>{

	/**
	 * Returns the number of elements in this collection.
	 *
	 * @return the number of elements in this collection
	 */
	int size();

	/**
	 * Returns {@code true} if this collection contains no elements.
	 *
	 * @return {@code true} if this collection contains no elements.
	 */
	boolean isEmpty();

	/**
	 * Returns {@code true} if this collection contains the specified element.
	 * More formally, returns {@code true} if and only if this collection
	 * contains at least one element e such that
	 * {@code (o == null ? e == null : o.equals(e))}.
	 * 
	 * @param o, the element whose presence in this collection is to be tested
	 * @return {@code true} if this collection contains the specified element
	 */
	boolean contains(T o);

	/**
	 * Appends the specified element to this collection, thus ensuring that this
	 * collection contains the specified element (optional operation). 
	 * 
	 * Returns {@code true} if this collection changed as a result of the call. 
	 * Returns {@code false} if this collection does not permit duplicates and 
	 * already contains the specified element.)
	 * <p>
	 * 
	 * Collections that support this operation may place limitations on what
	 * elements may be added to this collection. In particular, some collections
	 * will refuse to add {@code null}, and others will impose restrictions on
	 * the type of elements that may be added. Collection classes should clearly
	 * specify in their documentation any restrictions on what elements may be
	 * added.
	 * <p>
	 *
	 * If a collection refuses to add a particular element for any reason other
	 * than that it already contains the element, it <i>must</i> throw an
	 * exception (rather than returning {@code false}). This preserves the
	 * invariant that a collection always contains the specified element after
	 * this call returns.
	 *
	 * @param element, the element to be appended to this collection
	 * @return {@code true} if this collection changed as a result of the call
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified element is null and this collection does not
	 *             permit null elements
	 */
	boolean add(T element);

	/**
	 * Removes a single instance of the specified element from this collection,
	 * if it is present. 
	 * More formally, removes an element 
	 * {@code e} such that {@code o == null ? o == null : o.equals(e))}, 
	 * if this collection contains one or more such elements. 
	 * 
	 * @param o, the element to be removed from this collection, if present
	 * 
	 * @return {@code true} if an element was removed as a result of this call
	 */
	boolean remove(T o);

	/**
	 * Removes all of the elements from this collection.
	 * The collection will be empty after this method returns.
	 */
	void clear();

	/**
	 * Returns a string representation of this collection. The string
	 * representation consists of a list of the collection's elements, enclosed
	 * in square brackets (<tt>"[]"</tt>).
	 *  
	 * Adjacent elements are separated by the characters 
	 * <tt>", "</tt> (comma and space).
	 *  
	 * Elements are converted to strings as by invoking their 
	 * {@code toString} method.
	 *
	 * @return a string representation of this collection
	 */
	String toString();
}
