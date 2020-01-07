package edu.iastate.cs228.proj3;

/*
 *  @author
 *
 *
 *  An implementation of List<E> based on a doubly-linked list 
 *  with an array for indexed reads/writes
 *
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class AdaptiveList<E> implements List<E>
	{
	public class ListNode
		{
		public E data;
		public ListNode next;
		public ListNode prev;
		
		
		
		public ListNode(E item)
			{
			data = item;
			next = prev = null;
			}
		}
		
	public ListNode head; // dummy node made public for testing.
	public ListNode tail; // dummy node made public for testing.
	private int numItems; // number of data items
	private boolean linkedUTD; // true if the linked list is up-to-date.
	
	public E[] theArray; // the array for storing elements
	private boolean arrayUTD; // true if the array is up-to-date.
	
	
	
	public AdaptiveList()
		{
		clear();
		}
		
		
		
	@Override
	public void clear()
		{
		head = new ListNode(null);
		tail = new ListNode(null);
		head.next = tail;
		tail.prev = head;
		numItems = 0;
		linkedUTD = true;
		arrayUTD = false;
		theArray = null;
		}
		
		
		
	public boolean getlinkedUTD()
		{
		return linkedUTD;
		}
		
		
		
	public boolean getarrayUTD()
		{
		return arrayUTD;
		}
		
		
		
	public AdaptiveList(Collection<? extends E> c)
		{
		clear();
		addAll(c);
		}
		
		
		
	// Removes the node from the linked list.
	// This method should be used to remove a node
	// from the linked list.
	private void unlink(ListNode toRemove)
		{
		if (toRemove == head || toRemove == tail)
			throw new RuntimeException("An attempt to remove head or tail");
		toRemove.prev.next = toRemove.next;
		toRemove.next.prev = toRemove.prev;
		}
		
		
		
	// Inserts new node toAdd right after old node current.
	// This method should be used to add a node to the linked list.
	private void link(ListNode current, ListNode toAdd)
		{
		if (current == tail)
			throw new RuntimeException("An attempt to chain after tail");
		if (toAdd == head || toAdd == tail)
			throw new RuntimeException("An attempt to add head/tail as a new node");
		toAdd.next = current.next;
		toAdd.next.prev = toAdd;
		toAdd.prev = current;
		current.next = toAdd;
		}
		
		
		
	private void updateArray() // makes theArray up-to-date.
		{
		if (numItems < 0)
			throw new RuntimeException("numItems is negative: " + numItems);
		if (!linkedUTD)
			throw new RuntimeException("linkedUTD is false");
		ListNode node = head.next;
		theArray = (E[]) new Object[numItems];
		for (int index = 0; index < numItems; index++)
			{
			theArray[index] = node.data;
			node = node.next;
			}
		arrayUTD = true;
		}
		
		
		
	private void updateLinked() // makes the linked list up-to-date.
		{
		if (numItems < 0)
			throw new RuntimeException("numItems is negative: " + numItems);
		if (!arrayUTD)
			throw new RuntimeException("arrayUTD is false");
		
		if (theArray == null || theArray.length < numItems)
			throw new RuntimeException("theArray is null or shorter");
		head.next = tail;
		ListNode node = head;
		int count = 0;
		while (count < theArray.length)
			{
			ListNode newNode = new ListNode(theArray[count]);
			link(node, newNode);
			node = newNode;
			count++;
			}
		numItems = count;
		linkedUTD = true;
		}
		
		
		
	@Override
	public int size()
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		ListNode traverse = head.next;
		int length = 0;
		while (traverse.next != null)
			{
			traverse = traverse.next;
			length++;
			}
		return length;
		}
		
		
		
	@Override
	public boolean isEmpty()
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		if (head.next.equals(tail))
			{
			return true;
			}
		return false;
		}
		
		
		
	@Override
	public boolean add(E obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		ListNode newNode = new ListNode(obj);
		link(tail.prev, newNode);
		numItems++;
		return true;
		}
		
		
		
	@Override
	public boolean addAll(Collection<? extends E> c)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		for (Iterator i = c.iterator(); i.hasNext();)
			{
			E obj = (E) i.next();
			ListNode newNode = new ListNode(obj);
			link(tail.prev, newNode);
			numItems++;
			}
		return true;
		}
		
		
		
	@Override
	public boolean remove(Object obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		if (contains(obj) == true)
			{
			int location = indexOf(obj);
			ListNode node = head;
			for (int posA = 0; posA <= location; posA++)
				{
				node = node.next;
				}
			unlink(node);
			numItems--;
			return true;
			}
		return false;
		}
		
		
		
	private void checkIndex(int pos) // a helper method
		{
		if (pos >= numItems || pos < 0)
			throw new IndexOutOfBoundsException("Index: " + pos + ", Size: " + numItems);
		}
		
		
		
	private void checkIndex2(int pos) // a helper method
		{
		if (pos > numItems || pos < 0)
			throw new IndexOutOfBoundsException("Index: " + pos + ", Size: " + numItems);
		}
		
		
		
	private void checkNode(ListNode cur) // a helper method
		{
		if (cur == null || cur == tail)
			throw new RuntimeException("numItems: " + numItems + " is too large");
		}
		
		
		
	private ListNode findNode(int pos) // a helper method
		{
		ListNode cur = head;
		for (int i = 0; i < pos; i++)
			{
			checkNode(cur);
			cur = cur.next;
			}
		checkNode(cur);
		return cur;
		}
		
		
		
	@Override
	public void add(int pos, E obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		ListNode node = head;
		for (int count = 0; count < pos; count++)
			{
			node = node.next;
			}
		ListNode newNode = new ListNode(obj);
		link(node, newNode);
		numItems++;
		}
		
		
		
	@Override
	public boolean addAll(int pos, Collection<? extends E> c)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		ListNode node = head;
		for (int count = 0; count < pos; count++)
			{
			node = node.next;
			}
		for (Iterator i = c.iterator(); i.hasNext();)
			{
			E obj = (E) i.next();
			ListNode newNode = new ListNode(obj);
			link(node, newNode);
			node = newNode;
			numItems++;
			}
		return true;
		}
		
		
		
	@Override
	public E remove(int pos)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		if (pos <= numItems)
			{
			ListNode node = head;
			for (int posA = 0; posA < pos + 1; posA++)
				{
				node = node.next;
				}
			ListNode removed = node;
			unlink(node);
			numItems--;
			return removed.data;
			}
		return null;
		}
		
		
		
	@Override
	public E get(int pos)
		{
		if (getarrayUTD() == false)
			{
			updateArray();
			}
		return theArray[pos];
		}
		
		
		
	@Override
	public E set(int pos, E obj)
		{
		if (getarrayUTD() == false)
			{
			updateArray();
			}
		linkedUTD = false;
		E changed = theArray[pos];
		theArray[pos] = obj;
		return changed;
		}
		
		
		
	/**
	 * If the number of elements is at most 1, the method returns false. Otherwise,
	 * it reverses the order of the elements in the array without using any
	 * additional array, and returns true. Note that if the array is modified, then
	 * linkedUTD needs to be set to false.
	 */
	public boolean reverse()
		{
		if (getarrayUTD() == false)
			{
			updateArray();
			}
		if (theArray.length > 1)
			{
			linkedUTD = false;
			int index2 = theArray.length - 1;
			for (int index1 = 0; index2 > index1; index1++)
				{
				E temp = theArray[index1];
				theArray[index1] = theArray[index2];
				theArray[index2] = temp;
				index2--;
				}
			return true;
			}
		return false;
		}
		
		
		
	/**
	 * If the number of elements is at most 1, the method returns false. Otherwise,
	 * it swaps the items positioned at even index with the subsequent one in odd
	 * index without using any additional array, and returns true. Note that if the
	 * array is modified, then linkedUTD needs to be set to false.
	 */
	public boolean reorderOddEven()
		{
		if (getarrayUTD() == false)
			{
			updateArray();
			}
		if (theArray.length > 1)
			{
			linkedUTD = false;
			for (int index = 0; index + 1 < theArray.length; index += 2)
				{
				E temp = theArray[index];
				theArray[index] = theArray[index + 1];
				theArray[index + 1] = temp;
				}
			return true;
			}
		return false;
		}
		
		
		
	@Override
	public boolean contains(Object obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		ListNode node = head.next;
		boolean contains = false;
		while (node.next != null && contains == false)
			{
			if (node.data.equals(obj))
				{
				contains = true;
				}
			node = node.next;
			}
		return contains;
		}
		
		
		
	@Override
	public boolean containsAll(Collection<?> c)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		if (c.retainAll(this) == true)
			{
			return false;
			}
		return true;
		}
		
		
		
	@Override
	public int indexOf(Object obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		ListNode node = head.next;
		int index = 0;
		if (contains(obj) == true)
			{
			while (node.next != null)
				{
				if (node.data != null && node.data.equals(obj))
					{
					return index;
					}
				index++;
				node = node.next;
				}
			}
		return -1;
		}
		
		
		
	@Override
	public int lastIndexOf(Object obj)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		ListNode node = head.next;
		int index = 0;
		int lastIndex = -1;
		if (contains(obj) == true)
			{
			while (node.next != null)
				{
				if (node.data.equals(obj))
					{
					lastIndex = index;
					}
				index++;
				node = node.next;
				}
			return lastIndex;
			}
		return -1;
		}
		
		
		
	@Override
	public boolean removeAll(Collection<?> c)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		arrayUTD = false;
		ListNode node = head;
		ListNode remove = null;
		boolean changed = false;
		while (node.next != null)
			{
			if (c.contains(node.data))
				{
				remove = node;
				node = node.next;
				changed = true;
				unlink(remove);
				numItems--;
				}
			else
				{
				node = node.next;
				}
			}
		return changed;
		}
		
		
		
	@Override
	public boolean retainAll(Collection<?> c)
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		boolean changed = false;
		ListNode node = head.next;
		while (node != tail)
			{
			if (!c.contains(node.data))
				{
				changed = true;
				arrayUTD = false;
				unlink(node);
				numItems--;
				}
			node = node.next;
			}
		return changed;
		}
		
		
		
	@Override
	public Object[] toArray()
		{
		if (getlinkedUTD() == false)
			{
			updateLinked();
			}
		Object[] result = new Object[numItems];
		if (numItems > 0)
			{
			ListNode node = head.next;
			int count = 0;
			while (count < numItems)
				{
				result[count] = node.data;
				node = node.next;
				count++;
				}
			}
		return result;
		}
		
		
		
	/**
	 * In here you are allowed to use only java.util.Arrays.copyOf method.
	 */
	@Override
	public <T> T[] toArray(T[] arr)
		{
		return java.util.Arrays.copyOf(arr, arr.length);
		}
		
		
		
	@Override
	public List<E> subList(int fromPos, int toPos)
		{
		throw new UnsupportedOperationException();
		}
		
	private class AdaptiveListIterator implements ListIterator<E>
		{
		private int index; // index of next node;
		private ListNode cur; // node at index - 1
		private ListNode last; // node last visited by next() or previous()
		
		
		
		public AdaptiveListIterator()
			{
			if (!linkedUTD)
				updateLinked();
			E[] list = (E[]) toArray();
			index = 0;
			cur = head;
			}
			
			
			
		public AdaptiveListIterator(int pos)
			{
			if (!linkedUTD)
				updateLinked();
			if (index < numItems)
				{
				index = pos;
				}
			if (index > 0)
				{
				ListNode node = head;
				int count = 0;
				while (node.next != null && count + 1 < index)
					{
					node = node.next;
					count++;
					}
				cur = node;
				}
			}
			
			
			
		@Override
		public boolean hasNext()
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			if (index < numItems)
				{
				return true;
				}
			return false;
			}
			
			
			
		@Override
		public E next()
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			if (index < numItems)
				{
				last = cur.next;
				index++;
				int count = 0;
				ListNode node = head;
				while (count < index)
					{
					node = node.next;
					count++;
					}
				cur = node;
				return last.data;
				}
			return null;
			// return;
			}
			
			
			
		@Override
		public boolean hasPrevious()
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			if (cur.prev != null)
				{
				return true;
				}
			return false;
			}
			
			
			
		@Override
		public E previous()
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			if (index > 0)
				{
				int count = 0;
				ListNode node = head;
				while (count < index)
					{
					cur = node;
					node = node.next;
					count++;
					}
				last = node;
				index--;
				return last.data;
				}
			return null;
			}
			
			
			
		@Override
		public int nextIndex()
			{
			return index + 1;
			}
			
			
			
		@Override
		public int previousIndex()
			{
			return index - 1;
			}
			
			
			
		@Override
		public void remove()
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			arrayUTD = false;
			if (cur.next == last)
				{
				unlink(cur.next);
				numItems--;
				}
			if (cur.prev == last)
				{
				unlink(cur.prev);
				numItems--;
				}
			}
			
			
			
		@Override
		public void add(E obj)
			{
			if (getlinkedUTD() == false)
				{
				updateLinked();
				}
			arrayUTD = false;
			ListNode newNode = new ListNode(obj);
			link(cur, newNode);
			numItems++;
			}
			
			
			
		@Override
		public void set(E obj)
			{
			if (getarrayUTD() == false)
				{
				updateArray();
				}
			linkedUTD = false;
			theArray[index] = obj;
			}
		} // AdaptiveListIterator
		
		
		
	@Override
	public boolean equals(Object obj)
		{
		if (!linkedUTD)
			updateLinked();
		if ((obj == null) || !(obj instanceof List<?>))
			return false;
		List<?> list = (List<?>) obj;
		if (list.size() != numItems)
			return false;
		Iterator<?> iter = list.iterator();
		for (ListNode tmp = head.next; tmp != tail; tmp = tmp.next)
			{
			if (!iter.hasNext())
				return false;
			Object t = iter.next();
			if (!(t == tmp.data || t != null && t.equals(tmp.data)))
				return false;
			}
		if (iter.hasNext())
			return false;
		return true;
		}
		
		
		
	@Override
	public Iterator<E> iterator()
		{
		return new AdaptiveListIterator();
		}
		
		
		
	@Override
	public ListIterator<E> listIterator()
		{
		return new AdaptiveListIterator();
		}
		
		
		
	@Override
	public ListIterator<E> listIterator(int pos)
		{
		checkIndex2(pos);
		return new AdaptiveListIterator(pos);
		}
		
		
		
	// Adopted from the List<E> interface.
	@Override
	public int hashCode()
		{
		if (!linkedUTD)
			updateLinked();
		int hashCode = 1;
		for (E e : this)
			hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
		return hashCode;
		}
		
		
		
	// You should use the toString*() methods to see if your code works as expected.
	@Override
	public String toString()
		{
		// Other options System.lineSeparator or
		// String.format with %n token...
		// Not making data field.
		String eol = System.getProperty("line.separator");
		return toStringArray() + eol + toStringLinked();
		}
		
		
		
	public String toStringArray()
		{
		String eol = System.getProperty("line.separator");
		StringBuilder strb = new StringBuilder();
		strb.append("A sequence of items from the most recent array:" + eol);
		strb.append('[');
		if (theArray != null)
			for (int j = 0; j < theArray.length;)
				{
				if (theArray[j] != null)
					strb.append(theArray[j].toString());
				else
					strb.append("-");
				j++;
				if (j < theArray.length)
					strb.append(", ");
				}
		strb.append(']');
		return strb.toString();
		}
		
		
		
	public String toStringLinked()
		{
		return toStringLinked(null);
		}
		
		
		
	// iter can be null.
	public String toStringLinked(ListIterator<E> iter)
		{
		int cnt = 0;
		int loc = iter == null ? -1 : iter.nextIndex();
		
		String eol = System.getProperty("line.separator");
		StringBuilder strb = new StringBuilder();
		strb.append("A sequence of items from the most recent linked list:" + eol);
		strb.append('(');
		for (ListNode cur = head.next; cur != tail;)
			{
			if (cur.data != null)
				{
				if (loc == cnt)
					{
					strb.append("| ");
					loc = -1;
					}
				strb.append(cur.data.toString());
				cnt++;
				
				if (loc == numItems && cnt == numItems)
					{
					strb.append(" |");
					loc = -1;
					}
				}
			else
				strb.append("-");
			
			cur = cur.next;
			if (cur != tail)
				strb.append(", ");
			}
		strb.append(')');
		return strb.toString();
		}
	}
