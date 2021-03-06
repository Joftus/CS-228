package edu.iastate.cs228.hw08;

import java.util.Vector;
import java.util.Iterator;
import java.util.Objects;
import java.util.NoSuchElementException;



/**
 * A class that implements a sorted dictionary by using a Vector. Entries are
 * sorted based on keys in nondecreasing order. The dictionary has distinct
 * search keys, i.e., can have duplicate values, however, those are
 * differentiated based on their keys.
 * 
 * @author Joshua Loftus
 * 
 * 
 * 
 *         NOTEs and REQUIREMENTs:
 * 
 *         0. Put your Firstname and Lastname after above empty author tag. Make
 *         sure that in both cases the first letter is uppercase and all others
 *         are lowercase. 1. You are allowed to create and use your own private
 *         helper methods. If you are introducing your own helper methods those
 *         need to be private and properly documented as per Javadoc style.
 *         Already existing methods declaration cannot be changed, too. 2. No
 *         additional data fields can be introduced in any of the classes below.
 *         You are not allowed to change the case of the ones already existing,
 *         or rename those. 3. No custom classes of your own can be introduced
 *         or used. 4. Import statements are not allowed, besides the ones that
 *         are already provided. 5. Fully qualified class names usage is not
 *         allowed. 6. You are allowed to reuse any part of the provided source
 *         codes or shown under lecture notes section of Canvas, which do not
 *         violate any of above. 7. If you have any additional questions PLEASE
 *         ask on Piazza Q/A platform, but first PLEASE search and make sure
 *         that it was not already asked and answered. PLEASE setup your
 *         notifications for both Canvas and Piazza so that you are updated
 *         whenever there are any changes immediately. 8. You need to provide
 *         implementation to all methods and constructors which have a comment
 *         //TODO in their body. For all of these methods and constructors there
 *         is no need to provide comments.
 * 
 * 
 * 
 * 
 */

public class SortedVectorDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
	{
	private Vector<Entry> dict;
	
	
	
	public SortedVectorDictionary()
		{
		dict = new Vector<>();
		}
		
		
		
	public SortedVectorDictionary(int initialCapacity)
		{
		dict = new Vector<>(initialCapacity);
		}
		
		
		
	public V add(K key, V value)
		{
		if (Objects.isNull(key) || Objects.isNull(value))
			{
			throw new IllegalArgumentException();
			}
		Entry newEntry = new Entry(key, value);
		if (getSize() == 0)
			{
			dict.addElement(newEntry);
			return null;
			}
		else
			{
			for (int index = 0; index < getSize(); index++)
				{
				if (dict.elementAt(index).key == key)
					{
					V replacedValue = dict.elementAt(index).value;
					dict.elementAt(index).value = value;
					return replacedValue;
					}
				if (dict.elementAt(index).key.compareTo(key) > 0)
					{
					dict.insertElementAt(newEntry, index);
					return null;
					}
				}
			dict.addElement(newEntry);
			return null;
			}
		}
		
		
		
	public V remove(K key)
		{
		if (Objects.isNull(key))
			throw new IllegalArgumentException();
		if (isEmpty() == true)
			{
			return null;
			}
		int removeIndex = 0;
		boolean found = false;
		V removed = null;
		for (int index = 0; index < getSize(); index++)
			{
			if (dict.elementAt(index).key == key)
				{
				removeIndex = index;
				index = getSize();
				found = true;
				}
			}
		if (found == true)
			{
			removed = dict.elementAt(removeIndex).value;
			if (removeIndex == getSize() - 1)
				{
				dict.elementAt(removeIndex).value = null;
				dict.elementAt(removeIndex).key = null;
				}
			else
				{
				for (int index = removeIndex; index < getSize() - 1; index++)
					{
					dict.elementAt(index).value = dict.elementAt(index + 1).value;
					dict.elementAt(index).key = dict.elementAt(index + 1).key;
					}
				}
			dict.setSize(getSize() - 1);
			}
		return removed;
		}
		
		
		
	public V getValue(K key)
		{
		if (Objects.isNull(key))
			{
			throw new IllegalArgumentException();
			}
		for (int index = 0; index < getSize(); index++)
			{
			if (dict.elementAt(index).key == key)
				{
				return dict.elementAt(index).value;
				}
			}
		return null;
		}
		
		
		
	public boolean contains(K key)
		{
		if (Objects.isNull(key))
			throw new IllegalArgumentException();
		
		for (int index = 0; index < getSize(); index++)
			{
			if (dict.elementAt(index).key.equals(key))
				{
				return true;
				}
			}
		return false;
		}
		
		
		
	public boolean isEmpty()
		{
		if (dict.size() == 0)
			{
			return true;
			}
		return false;
		}
		
		
		
	public int getSize()
		{
		return dict.size();
		}
		
		
		
	public void clear()
		{
		for (int index = 0; index < dict.size(); index++)
			{
			dict.elementAt(index).value = null;
			}
		dict.setSize(0);
		}
		
		
		
	public String toString()
		{
		return dict.toString();
		}
		
		
		
	public Iterator<K> getKeyIterator()
		{
		return new KeyIterator();
		}
		
		
		
	public Iterator<V> getValueIterator()
		{
		return new ValueIterator();
		}
		
	private class KeyIterator implements Iterator<K>
		{
		private Iterator<Entry> iter;
		
		
		
		private KeyIterator()
			{
			iter = dict.iterator();
			}
			
			
			
		public boolean hasNext()
			{
			if (iter.hasNext() == true)
				{
				return true;
				}
			return false;
			}
			
			
			
		public K next()
			{
			return iter.next().key;
			}
		}
		
	private class ValueIterator implements Iterator<V>
		{
		private Iterator<Entry> iter;
		
		
		
		private ValueIterator()
			{
			iter = dict.iterator();
			}
			
			
			
		public boolean hasNext()
			{
			if (iter.hasNext() == true)
				{
				return true;
				}
			return false;
			}
			
			
			
		public V next()
			{
			return iter.next().value;
			}
		}
		
	private class Entry
		{
		private K key;
		private V value;
		
		
		
		private Entry(K searchKey, V dataValue)
			{
			key = searchKey;
			value = dataValue;
			}
			
			
			
		private K getKey()
			{
			return key;
			}
			
			
			
		private V getValue()
			{
			return value;
			}
			
			
			
		private void setValue(V dataValue)
			{
			value = dataValue;
			}
			
			
			
		public String toString()
			{
			return "(" + key + ":" + value + ")";
			}
		}
	}
