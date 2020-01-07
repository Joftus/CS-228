/**
* Author @Josh_Lofuts
* Oct 23, 2018
*/
package edu.iastate.cs228.proj3;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;



public class TestAdaptiveList
	{
	
	@Rule
	public ExpectedException ex = ExpectedException.none();
	
	
	
	/*
	 * 
	 * Class: AdaptiveList, add(E obj)
	 * 
	 */
	@Test
	public void test01_AdaptiveListAdd()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "a", "e", "d", "c", "b" };
		seq.add("a");
		seq.add("e");
		seq.add("d");
		seq.add("d");
		seq.add("c");
		seq.add("b");
		seq.add("a");
		Iterator<String> i = seq.iterator();
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		
		assertTrue(i.hasNext());
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		i.next();
		assertEquals(expected[2], i.next());
		assertEquals(7, seq.size());
		assertEquals(expected[2], seq.get(3));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, add(int pos, E obj)
	 * 
	 * 
	 */
	@Test
	public void test02_AdaptiveListAdd()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "a", "b", "c", "d", "e" };
		Iterator<String> i = seq.iterator();
		seq.add(0, "a");
		seq.add(1, "c");
		seq.add(2, "d");
		seq.add(3, "e");
		seq.add(1, "b");
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		assertEquals(expected[2], i.next());
		i.next();
		assertEquals(expected[4], i.next());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, addAll(Collection<? extends E> c)
	 * 
	 * 
	 */
	@Test
	public void test03_AdaptiveListAddAll()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "a", "b", "c", "d", "e" };
		Iterator<String> i = seq.iterator();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		seq.addAll(list);
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		i.next();
		assertEquals(expected[3], i.next());
		assertEquals(5, seq.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, addAll(int pos, Collection<? extends E> c)
	 * 
	 * 
	 */
	@Test
	public void test04_AdaptiveListAddAll()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "f", "g", "a", "b", "c", "d", "e", "h" };
		Iterator<String> i = seq.iterator();
		seq.add("f");
		seq.add("g");
		seq.add("h");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		seq.addAll(2, list);
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		assertEquals(expected[2], i.next());
		assertEquals(expected[3], i.next());
		i.next();
		i.next();
		assertEquals(expected[6], i.next());
		assertEquals(expected[7], i.next());
		assertEquals(8, seq.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, remove(Object obj)
	 * 
	 * 
	 */
	@Test
	public void test05_AdaptiveListRemove()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "b", "d", "e" };
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		seq.add("d");
		seq.add("b");
		seq.add("e");
		seq.remove("a");
		seq.remove("c");
		Iterator<String> i = seq.iterator();
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		assertEquals(expected[1], i.next());
		assertEquals(5, seq.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, remove(int pos)
	 * 
	 * 
	 */
	@Test
	public void test06_AdaptiveListRemove()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] { "a", "b", "e", "d" };
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		seq.add("d");
		seq.add("b");
		seq.add("e");
		assertEquals("d", seq.remove(3));
		assertEquals("c", seq.remove(2));
		Iterator<String> i = seq.iterator();
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		
		assertEquals(expected[0], i.next());
		assertEquals(expected[1], i.next());
		assertEquals(expected[3], i.next());
		assertEquals(5, seq.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, updateArray()
	 * 
	 * 
	 */
	@Test
	public void test07_AdaptiveListUpdateArray()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		assertTrue(seq.getlinkedUTD());
		assertFalse(seq.getarrayUTD());
		// call method that calls updateArray()
		seq.get(0);
		assertTrue(seq.getarrayUTD());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, updateLinked()
	 * 
	 * 
	 */
	@Test
	public void test08_AdaptiveListUpdateLinked()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("d");
		seq.add("e");
		seq.add("f");
		seq.set(0, "a");
		seq.set(1, "b");
		seq.set(2, "c");
		assertTrue(seq.getarrayUTD());
		assertFalse(seq.getlinkedUTD());
		// call method that calls updateLinked()
		seq.size();
		assertTrue(seq.getlinkedUTD());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, isEmpty()
	 * 
	 * 
	 */
	@Test
	public void test09_AdaptiveListIsEmpty()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		assertTrue(seq.isEmpty());
		seq.add("a");
		assertFalse(seq.isEmpty());
		seq.remove("a");
		assertTrue(seq.isEmpty());
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		seq.addAll(list);
		assertFalse(seq.isEmpty());
		seq.clear();
		assertTrue(seq.isEmpty());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, size()
	 * 
	 * 
	 */
	@Test
	public void test10_AdaptiveListSize()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		assertEquals(0, seq.size());
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		assertEquals(4, seq.size());
		seq.remove(2);
		assertEquals(3, seq.size());
		seq.clear();
		assertEquals(0, seq.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, get(int pos)
	 * 
	 * 
	 */
	@Test
	public void test11_AdaptiveListGet()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		assertEquals("c", seq.get(2));
		assertEquals("a", seq.get(0));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, set(int pos, E obj)
	 * 
	 * 
	 */
	@Test
	public void test12_AdaptiveListSet()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		assertTrue("c" == seq.get(2));
		AdaptiveList<String> seqBefore = seq;
		seq.set(2, "z");
		assertFalse("c" == seq.get(2));
		assertEquals("z", seq.get(2));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, reverse()
	 * 
	 * 
	 */
	@Test
	public void test13_AdaptiveListReverse()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		seq.reverse();
		// must update linked by calling a method that calls updateLinked()
		seq.contains("a");
		assertTrue(seq.get(0) == "d");
		assertTrue(seq.get(3) == "a");
		assertTrue(seq.size() == 4);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, reorderOddEven
	 * 
	 * 
	 */
	@Test
	public void test14_AdaptiveListReorderOddEven()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		seq.reorderOddEven();
		// must update linked by calling a method that calls updateLinked()
		seq.contains("a");
		assertTrue(seq.get(0) == "b");
		assertTrue(seq.get(3) == "c");
		assertTrue(seq.size() == 4);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, contains(Object obj)
	 * 
	 * 
	 */
	@Test
	public void test15_AdaptiveListContains()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		assertFalse(seq.contains("a"));
		seq.add("a");
		assertTrue(seq.contains("a"));
		seq.remove(0);
		assertFalse(seq.contains("a"));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, containsAll(Collection< ? > c)
	 * 
	 * 
	 */
	@Test
	public void test16_AdaptiveListContainsAll()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ArrayList<String> list = new ArrayList<String>();
		list.add("c");
		list.add("d");
		list.add("e");
		assertFalse(seq.containsAll(list));
		seq.add("e");
		assertTrue(seq.containsAll(list));
		seq.remove(0);
		assertTrue(seq.containsAll(list));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, indexOf(Object obj)
	 * 
	 * 
	 */
	@Test
	public void test17_AdaptiveListIndexOf()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		assertEquals(seq.indexOf("a"), 0);
		assertEquals(seq.indexOf("c"), 3);
		seq.remove(0);
		assertEquals(seq.indexOf("b"), 1);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, lastIndexOf(Object obj)
	 * 
	 * 
	 */
	@Test
	public void test18_AdaptiveListLastIndexOf()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("a");
		assertEquals(seq.lastIndexOf("a"), 3);
		assertEquals(seq.lastIndexOf("b"), 1);
		seq.remove(3);
		assertEquals(seq.lastIndexOf("a"), 0);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, toArray()
	 * 
	 * 
	 */
	@Test
	public void test19_AdaptiveListToArray()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		Object[] arr = seq.toArray();
		assertEquals(arr.length, seq.size());
		assertEquals(arr[0], seq.get(0));
		assertEquals(arr[2], seq.get(2));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, retainAll(Collection<?> c)
	 * 
	 * 
	 */
	@Test
	public void test20_AdaptiveListRetainAll()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ArrayList<String> list = new ArrayList<String>();
		list.add("b");
		list.add("a");
		list.add("d");
		seq.retainAll(list);
		assertFalse(seq.contains("c"));
		assertTrue(seq.contains("b"));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, removeAll(Collection<?> c)
	 * 
	 * 
	 */
	@Test
	public void test21_AdaptiveListRemoveAll()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ArrayList<String> list = new ArrayList<String>();
		list.add("z");
		list.add("a");
		list.add("d");
		seq.removeAll(list);
		assertFalse(seq.contains("a"));
		assertTrue(seq.contains("b"));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, toArray(T[] arr)
	 * 
	 * 
	 */
	@Test
	public void test22_AdaptiveListToArray()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		Object[] list = new Object[] { "z", "a", "d" };
		Object[] arr = seq.toArray(list);
		assertEquals(arr[0], list[0]);
		assertEquals(arr[1], list[1]);
		assertEquals(arr[2], list[2]);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, hasNext()
	 * 
	 * 
	 */
	@Test
	public void test23_AdaptiveListIteratorHasNext()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		Iterator i = seq.iterator();
		assertTrue(i.hasNext());
		i.next();
		assertTrue(i.hasNext());
		i.next();
		assertFalse(i.hasNext());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, next()
	 * 
	 * 
	 */
	@Test
	public void test24_AdaptiveListIteratorNext()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		Iterator i = seq.iterator();
		assertEquals(i.next(), "a");
		assertEquals(i.next(), "b");
		seq.remove(2);
		assertEquals(i.next(), "d");
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, hasPrevious()
	 * 
	 * 
	 */
	@Test
	public void test25_AdaptiveListIteratorHasPrevious()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(2);
		assertTrue(i.hasPrevious());
		i.previous();
		assertTrue(i.hasPrevious());
		i.previous();
		assertFalse(i.hasPrevious());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, previous()
	 * 
	 * 
	 */
	@Test
	public void test26_AdaptiveListIteratorPrevious()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(2);
		assertEquals(i.previous(), "b");
		assertEquals(i.previous(), "a");
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, nextIndex()
	 * 
	 * 
	 */
	@Test
	public void test27_AdaptiveListIteratorNextIndex()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(1);
		assertEquals(i.nextIndex(), 2);
		i.next();
		assertEquals(i.nextIndex(), 3);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, previousIndex()
	 * 
	 * 
	 */
	@Test
	public void test28_AdaptiveListIteratorPreviousIndex()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(3);
		assertEquals(i.previousIndex(), 2);
		i.previous();
		assertEquals(i.previousIndex(), 1);
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, remove()
	 * 
	 * 
	 */
	@Test
	public void test29_AdaptiveListIteratorRemove()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(2);
		i.next();
		i.remove();
		assertFalse(i.next() == "d");
		i.previous();
		i.remove();
		assertFalse(i.previous() == "b");
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, add(E obj)
	 * 
	 * 
	 */
	@Test
	public void test30_AdaptiveListIteratorAdd()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(2);
		i.add("e");
		assertEquals(i.next(), "e");
		assertEquals(i.previous(), "b");
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, set(E obj)
	 * 
	 * 
	 */
	@Test
	public void test31_AdaptiveListIteratorSet()
		{
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("a");
		seq.add("b");
		seq.add("c");
		seq.add("d");
		ListIterator i = seq.listIterator(1);
		i.next();
		i.set("e");
		Object[] arr = seq.toArray();
		assertEquals(arr[2], "e");
		assertEquals(arr[1], "b");
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveList, AdaptiveListCollection<? extends E> c)
	 * 
	 * 
	 */
	@Test
	public void test32_AdaptiveListAdaptiveList()
		{
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		AdaptiveList<String> seq = new AdaptiveList<String>(list);
		assertTrue(seq.contains("a"));
		assertTrue(seq.contains("b"));
		assertFalse(seq.contains("c"));
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, AdaptiveListIterator()
	 * 
	 * 
	 */
	@Test
	public void test33_AdaptiveListIteratorAdaptiveListIterator()
		{
		ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b", "c"));
		ListIterator<String> li = a.listIterator();
		int count = 0;
		while (li.hasNext())
			{
			assertEquals(li.next(), a.get(count));
			count++;
			}
		assertEquals(count, a.size());
		}
		
		
		
	/*
	 * 
	 * 
	 * Class: AdaptiveListIterator, AdaptiveListIterator(int pos)
	 * 
	 * 
	 */
	@Test
	public void test34_AdaptiveListIteratorAdaptiveListIterator()
		{
		ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b", "c"));
		int pos = 1;
		ListIterator<String> li = a.listIterator(pos);
		int count = pos;
		while (li.hasNext())
			{
			assertEquals(li.next(), a.get(count));
			count++;
			}
		assertEquals(count - pos - 1, 1);
		}
	}
