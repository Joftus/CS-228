
package edu.iastate.cs228.hw08;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;



/**
 * 
 * 
 * A class that implements the ADT dictionary by using a chain of nodes. The
 * dictionary is unsorted and has distinct search keys, i.e., can have duplicate
 * values, however, those are differentiated based on their keys.
 * 
 * @author
 * 		
 * 		NOTEs and REQUIREMENTs:
 * 
 *         Exactly same as the ones listed for SortedVectorDictionary class.
 * 
 *         In addition to above ANSWER the following 6 QUESTIONS, inside these
 *         comments right below each question. Figures needed to answer
 *         questions 3, 4, and 5 are shown on Canvas under description of HW08.
 * 
 *         =========================================================================
 *         Q1. (a) What is the height of the shortest binary tree that contains
 *         22 nodes? (b) Is this tree full? (c) Is it balanced?
 * 
 *         A1. (a) 5 (b) Nope (c) Yes
 *         =========================================================================
 *         Q2. Consider a binary tree that has four levels. (a) What is the
 *         maximum number of nodes in this tree? (b) What is the maximum number
 *         of leaves in this tree?
 * 
 *         A2. (a) 15 (b) 8
 *         =========================================================================
 *         Q3. Consider a traversal of a binary tree, which contains Integer
 *         data. Suppose that visiting a node means to simply display the data
 *         in the node. What are the results of each of the following traversals
 *         of the binary tree shown in Figure 1. (a) Preorder (b) Postorder (c)
 *         Inorder (d) Level order
 * 
 *         A3. (a) 6, 4, 2, 1, 3, 5, 8, 7, 9, 10, 11 (b) 1, 3, 2, 5, 4, 9, 7,
 *         11, 10, 8, 6 (c) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 (d) 6, 4, 8, 2, 5,
 *         7, 10, 1, 3, 9, 11
 * 
 *         =========================================================================
 *         Q4. Repeat Q3 but for the binary tree shwn in Figure 2. A4. (a) 11,
 *         8, 3, 2, 1, 5, 4, 6, 10, 9, 7 (b) 2, 1, 3, 4, 6, 5, 8, 9, 7, 10, 11
 *         (c) 2, 3, 1, 8, 4, 5, 6, 11, 8, 10, 7 (d) 11, 8, 10, 3, 5, 9, 7, 2,
 *         1, 4, 6
 * 
 *         =========================================================================
 *         Q5. The two binary trees shown in Figures 1 and 2 contain Integer
 *         data. (a) Is the tree in Figure 1 a binary search tree? Why or why
 *         not? (b) Is the tree in Figure 2 a maxheap? Why or why not?
 * 
 *         A5. (a) Yes, because both the left and right side of the tree have 1
 *         parent node and 5 nodes. (b) No, because one of the nodes in level 4
 *         has a value of 6.
 * 
 *         =========================================================================
 *         Q6. Can a binary search tree ever be a maxheap? Explain. A6. Yes, a
 *         tree with 2 nodes, one being a child and one being the root, is an
 *         example of this.
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
	{
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;
	
	
	
	public LinkedDictionary()
		{
		firstNode = null;
		numberOfEntries = 0;
		}
		
		
		
	public V add(K key, V value)
		{
		if (Objects.isNull(key) || Objects.isNull(value))
			throw new IllegalArgumentException();
		Node node = firstNode;
		Node trail = firstNode;
		if (numberOfEntries == 0)
			{
			firstNode = new Node(key, value);
			numberOfEntries++;
			return null;
			}
		for (int index = 0; index < numberOfEntries; index++)
			{
			if (node.key == key)
				{
				V removedValue = node.value;
				node.value = value;
				return removedValue;
				}
			if (index >= 1)
				{
				trail = trail.next;
				}
			node = node.next;
			}
		node = new Node(key, value);
		trail.next = node;
		numberOfEntries++;
		return null;
		
		}
		
		
		
	public V remove(K key)
		{
		if (Objects.isNull(key))
			throw new IllegalArgumentException();
		Node node = firstNode;
		Node trail = firstNode;
		V removed = null;
		int outerIndex = 0;
		if (node.key == key)
			{
			removed = node.value;
			firstNode = node.next;
			numberOfEntries--;
			return removed;
			}
		for (int index = 0; index < numberOfEntries - 1; index++)
			{
			if (node.key == key)
				{
				removed = node.value;
				trail.next = trail.next.next;
				numberOfEntries--;
				return removed;
				}
			if (index > 0)
				{
				trail = trail.next;
				}
			outerIndex++;
			node = node.next;
			}
		if (numberOfEntries > 0 && outerIndex == numberOfEntries - 1 && trail.next.key == key)
			{
			removed = trail.next.value;
			trail.next = null;
			numberOfEntries--;
			return removed;
			}
		/*
		 * while (node.next != null && node.key != key) { node = node.next; index++; }
		 * if (node.next != null && node.key == key) { removed = node.next.value; }
		 */
		return null;
		}
		
		
		
	public V getValue(K key)
		{
		if (Objects.isNull(key))
			throw new IllegalArgumentException();
		Node node = firstNode;
		if (node.key == key)
			{
			return node.value;
			}
		while (node.next != null && node.next.key != key)
			{
			node = node.next;
			}
		if (node.next != null)
			{
			return node.next.value;
			}
		return null;
		}
		
		
		
	public boolean contains(K key)
		{
		if (Objects.isNull(key))
			throw new IllegalArgumentException();
		Node node = firstNode;
		for (int index = 0; index < numberOfEntries; index++)
			{
			if (node.key == key)
				{
				return true;
				}
			node = node.next;
			}
		return false;
		}
		
		
		
	public boolean isEmpty()
		{
		return numberOfEntries == 0;
		}
		
		
		
	public int getSize()
		{
		return numberOfEntries;
		}
		
		
		
	public void clear()
		{
		numberOfEntries = 0;
		firstNode.next = null;
		}
		
		
		
	// Needs to output String representation in exact same
	// format as the one done by SortedVectorDictionary.
	public String toString()
		{
		String output = "[";
		Node node = firstNode;
		for (int index = 0; index < numberOfEntries; index++)
			{
			if (node.key != null && node.value != null)
				{
				if (index == 0)
					{
					output += "(" + node.key + ":" + node.value + ")";
					}
				else
					{
					output += ", " + "(" + node.key + ":" + node.value + ")";
					}
				}
			if (node.next != null)
				{
				node = node.next;
				}
			}
		output += "]";
		return output;
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
		private Node nextNode;
		
		
		
		private KeyIterator()
			{
			nextNode = firstNode;
			}
			
			
			
		public boolean hasNext()
			{
			return nextNode != null;
			}
			
			
			
		public K next()
			{
			K info = nextNode.key;
			nextNode = nextNode.next;
			return info;
			}
		}
		
	private class ValueIterator implements Iterator<V>
		{
		private Node nextNode;
		
		
		
		private ValueIterator()
			{
			nextNode = firstNode;
			}
			
			
			
		public boolean hasNext()
			{
			return nextNode != null;
			}
			
			
			
		public V next()
			{
			V info = nextNode.value;
			nextNode = nextNode.next;
			return info;
			}
		}
		
	private class Node
		{
		private K key;
		private V value;
		private Node next;
		
		
		
		private Node(K searchKey, V dataValue)
			{
			key = searchKey;
			value = dataValue;
			next = null;
			}
			
			
			
		private Node(K searchKey, V dataValue, Node nextNode)
			{
			key = searchKey;
			value = dataValue;
			next = nextNode;
			}
			
			
			
		private K getKey()
			{
			return key;
			}
			
			
			
		private V getValue()
			{
			return value;
			}
			
			
			
		private void setValue(V newValue)
			{
			value = newValue;
			}
			
			
			
		private Node getNextNode()
			{
			return next;
			}
			
			
			
		private void setNextNode(Node nextNode)
			{
			next = nextNode;
			}
			
			
			
		public String toString()
			{
			return "(" + key + ":" + value + ")";
			}
		}
	}
