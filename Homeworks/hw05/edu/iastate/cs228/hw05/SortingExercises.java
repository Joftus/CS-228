package edu.iastate.cs228.hw05;

/**
 * 
 * @author Joshua Loftus
 * 		
 * 		NOTE: 0. Put your Firstname and Lastname after above author tag. Make
 *         sure that in both cases the first letter is uppercase and all others
 *         are lowercase. 1. In all of these methods implementations you are
 *         allowed to use the StringBuilder class. 2. You are allowed to create
 *         and use your own private helper methods. 3. No data fields can be
 *         introduced. 4. No custom classes of your own can be introduced or
 *         used. 5. Import statements are not allowed. 6. Fully qualified class
 *         names usage is not allowed. 7. You are allowed to reuse any part of
 *         the source codes provided or shown under lecture notes.
 * 
 */

public class SortingExercises
	{
	/**
	 * Recursive implementation of selection sort.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Rec(int[] arr)
		{
		int n = arr.length;
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		int[] nextArr = new int[n - 1];
		int smallest = arr[0];
		int smallestIndex = 0;
		for (int index = 0; index < arr.length; index++)
			{
			if (arr[index] < smallest)
				{
				smallest = arr[index];
				smallestIndex = index;
				}
			}
		int temp = arr[0];
		arr[0] = smallest;
		arr[smallestIndex] = temp;
		for (int index = 0; index < n - 1; index++)
			{
			nextArr[index] = arr[index + 1];
			}
		insertionSort_Rec(nextArr);
		for (int index = 0; nextArr.length > index; index++)
			{
			arr[index + 1] = nextArr[index];
			}
		}
		
		
		
	/**
	 * Recursive implementation of insertion sort.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void insertionSort_Rec(int[] arr)
		{
		int n = arr.length;
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		
		int[] nextArr = new int[n - 1];
		for (int index = 0; index < n - 1; index++)
			{
			nextArr[index] = arr[index];
			}
		insertionSort_Rec(nextArr);
		for (int index = 0; nextArr.length > index; index++)
			{
			arr[index] = nextArr[index];
			}
		int last = arr[n - 1];
		int a = n - 2;
		while (a >= 0 && arr[a] > last)
			{
			arr[a + 1] = arr[a];
			a--;
			}
		arr[a + 1] = last;
		}
		
		
		
	/**
	 * Iterative implementation of selection sort with modifications as follows. On
	 * each pass in this case the method finds both the largest and smallest values
	 * in the unsorted portion of the array, and places them in the correct
	 * locations.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Itr(int[] arr)
		{
		int n = arr.length;
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		int[] result = new int[n];
		int count = 0;
		for (int index1 = 0; index1 < n / 2; index1++)
			{
			int max = -2147483647;
			int maxIndex = 0;
			for (int index2 = 0; index2 < n; index2++)
				{
				if (arr[index2] > max && arr[index2] != -2147483647 && arr[index2] != 2147483647)
					{
					max = arr[index2];
					maxIndex = index2;
					}
				}
			int min = 2147483647;
			int minIndex = 0;
			for (int index3 = 0; index3 < n; index3++)
				{
				if (arr[index3] < min && arr[index3] != -2147483647 && arr[index3] != 2147483647)
					{
					min = arr[index3];
					minIndex = index3;
					}
				}
			result[0 + count] = min;
			result[n - 1 - count] = max;
			arr[maxIndex] = 2147483647;
			arr[minIndex] = 2147483647;
			count++;
			}
		if (n % 2 != 0)
			{
			int middle = 0;
			boolean found = false;
			while (found == false)
				{
				if (arr[middle] != 2147483647 && arr[middle] != -2147483647)
					{
					result[(n - 1) / 2] = arr[middle];
					found = true;
					}
				middle++;
				}
			}
		for (int index = 0; index < n; index++)
			{
			arr[index] = result[index];
			}
			
		}
		
		
		
	/**
	 * A bubble sort can sort an array of n entries into ascending order by makeing
	 * n-1 passes through the array. On each pass, it compares adjacent entries and
	 * swaps them if they are out or order. For example, on the first pass, it
	 * compares the first and second entries, then the second and third entries, and
	 * so on. At the end of the first pass, the largest entry is in its proper
	 * position at the end of the array. We say that it has bubbled to its correct
	 * spot. Each subsequent pass ignores the entries at the end of the array, since
	 * they are sorted and are larger than any of the remaining entries. Thus, each
	 * pass makes one fewer comparison than the previous pass. Check the figure
	 * under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort iteratively.
	 * 
	 * @param arr
	 *            Array of objects (with specific bounds) to be sorted in
	 *            nondecreasing order.
	 */
	public static <T extends Comparable<? super T>> void bubbleSort_Itr(T[] arr)
		{
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		boolean inOrder = false;
		while (inOrder == false)
			{
			inOrder = true;
			for (int index = 0; index < arr.length - 1; index++)
				{
				int compare = arr[index].compareTo(arr[index + 1]);
				if (compare > 0)
					{
					T temp = arr[index];
					arr[index] = arr[index + 1];
					arr[index + 1] = temp;
					inOrder = false;
					}
				}
			}
		}
		
		
		
	/**
	 * A bubble sort can sort an array of n entries into ascending order by makeing
	 * n-1 passes through the array. On each pass, it compares adjacent entries and
	 * swaps them if they are out or order. For example, on the first pass, it
	 * compares the first and second entries, then the second and third entries, and
	 * so on. At the end of the first pass, the largest entry is in its proper
	 * position at the end of the array. We say that it has bubbled to its correct
	 * spot. Each subsequent pass ignores the entries at the end of the array, since
	 * they are sorted and are larger than any of the remaining entries. Thus, each
	 * pass makes one fewer comparison than the previous pass. Check the figure
	 * under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort recursively.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void bubbleSort_Rec(int[] arr)
		{
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		boolean inOrder = true;
		for (int index = 0; index < arr.length - 1; index++)
			{
			if (arr[index] > arr[index + 1])
				{
				int temp = arr[index];
				arr[index] = arr[index + 1];
				arr[index + 1] = temp;
				inOrder = false;
				}
			}
		if (inOrder == false)
			{
			bubbleSort_Rec(arr);
			}
		}
	}
