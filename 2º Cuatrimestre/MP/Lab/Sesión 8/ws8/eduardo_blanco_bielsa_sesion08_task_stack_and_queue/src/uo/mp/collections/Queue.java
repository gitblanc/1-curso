package uo.mp.collections;

	/**
	 * A {@code Queue} represents a FIFO (first-in-first-out) collection of
	 * elements. Queues provide insertion, extraction, and inspection operations 
	 * ({@code enqueue}, {@code dequeue}, and {@code peek} methods, respectively.
	 * @author blanc
	 */
	public interface Queue<E>
	{
		/**
		 * Returns the number of elements in this queue.
		 * 
		 * @return the number of elements in this queue
		 */
		public int size();

		/**
		 * Returns whether this queue is empty or not.
		 * 
		 * @return {@code true} if this queue is empty; {@code false} otherwise.
		 */
		public boolean isEmpty();

		/**
		 * Adds an object to the rear (end) of this queue.
		 * 
		 * @param element the element to be added
		 */
		public void enqueue(E element);


		/**
		 * Removes and returns an object from the front (beginning) of this queue.
		 * It throws an exception if this queue is empty.
		 * 
		 * @return the element removed
	     * @throws EmptyQueueException if this queue is empty
		 */
		public E dequeue();

		/**
		 * Returns the object at the front (beginning) of this queue without removing it.
		 * It throws an exception if this queue is empty.
		 * 
		 * @return the element at the front (beginning) of this queue
	     * @throws EmptyQueueException if this queue is empty
		 */
		public E peek();
	}

