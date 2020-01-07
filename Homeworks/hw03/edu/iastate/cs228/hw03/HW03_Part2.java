package edu.iastate.cs228.hw03;

/**
 * 
 * @Josh_Loftus
 *
 */
public class HW03_Part2
	{
	/*
	 * Answers to short questions:
	 * 
	 * 1.O(n)
	 * 
	 * 2.O(log(n))
	 * 
	 * 3.O(n^3)
	 * 
	 * 4.O(n^2)
	 * 
	 * 5.O(n^2)
	 * 
	 */
	
	/*
	 * In all of the following methods you can assume that array will always have
	 * elements (ints) in it. And will have proper integers as defined in the
	 * description of HW03, i.e., in first two it will be in the range, and in last
	 * two it will be composed of negative and positive values only.
	 */
	
	public static int findMissingInt_a_On2(int[] array)
		{
		int result = 0;
		boolean isPresent;
		for (int comparable = 1; comparable < array.length + 2; comparable++)
			{
			isPresent = false;
			for (int index = 0; index < array.length; index++)
				{
				if (array[index] == comparable)
					{
					isPresent = true;
					}
				}
			if (isPresent == false)
				{
				return comparable;
				}
			}
		// Part (a) of subsection 2.2.1 of HW03.
		return result;
		}
		
		
		
	public static int findMissingInt_b_On1(int[] array)
		{
		int result = 1;
		int factorial = 1;
		for (int index = 0; index <= array.length + 1; index++)
			{
			if (index < array.length)
				{
				result = result * array[index];
				}
			if (index != 0)
				{
				factorial = factorial * index;
				}
			}
		int missing = factorial / result;
		// Part (b) of subsection 2.2.2 of HW03.
		return missing;
		}
		
		
		
	public static void rearrange_a_On2(int[] array)
		{
		int[] ordered = new int[array.length];
		int indexBack = 0;
		int indexFront = array.length - 1;
		int currentIndex = 0;
		for (int index1 = 0; index1 < array.length; index1++)
			{
			if (array[index1] > 0)
				{
				currentIndex = indexFront;
				indexFront--;
				}
			else
				{
				currentIndex = indexBack;
				indexBack++;
				}
			ordered[currentIndex] = array[index1];
			if (!(index1 + 1 < array.length))
				{
				for (int index2 = 0; index2 < array.length; index2++)
					{
					array[index2] = ordered[index2];
					}
				}
			}
		// Part (a) of subsection 2.2.2 of HW03.
		}
		
		
		
	public static void rearrange_b_On1(int[] array)
		{
		for (int index = 0; index < array.length; index++)
			{
			if (index > 0 && array[index] < array[index - 1])
				{
				int temp = array[index];
				array[index] = array[index - 1];
				array[index - 1] = temp;
				index = 0;
				}
			}
		// Part (b) of subsection 2.2.2 of HW03.
		}
		
	}
