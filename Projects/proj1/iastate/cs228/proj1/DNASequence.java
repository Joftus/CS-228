package edu.iastate.cs228.proj1;

/*
 * @Josh_Loftus
*/

public class DNASequence extends Sequence
	{
	/**
	 * If the character array argument has a character on which the method
	 * {@link #isValidLetter(char)} returns {@code false}, then it throws an
	 * {@link java.lang.IllegalArgumentException} with the message
	 * {@code "Invalid sequence letter for class X"} where {@code X} denotes
	 * {@code "edu.iastate.cs228.proj1.DNASequence"} or the name of a subclass of
	 * which an object is created. Otherwise, the constructor saves a copy of the
	 * character array argument in the field of its superclass.
	 * 
	 * @param dnaarr
	 *            See {@link #DNASequence(char[])}.
	 * @throws IllegalArgumentException
	 *             See {@link #DNASequence(char[])}.
	 */
	public DNASequence(char[] dnaarr)
		{
		super(dnaarr);
		for (int index = 0; index < dnaarr.length; index++)
			{
			if (!isValidLetter(dnaarr[index]))
				{
				throw new IllegalArgumentException("Invalid sequence letter for class X");
				}
			}
		}
		
		
		
	/**
	 * The method returns {@code true} if the character argument is equal to one of
	 * the eight characters {@code 'a', 'A', 'c', 'C', 'g', 'G', 't', and 'T'}.
	 * Otherwise, it returns {@code false}. This method overrides the one in its
	 * superclass.
	 * 
	 * @param let
	 *            See {@link #isValidLetter(char)}.
	 * @return {@link #isValidLetter(char)}.
	 */
	@Override
	public boolean isValidLetter(char let)
		{
		char lowerCase = Character.toLowerCase(let);
		if (lowerCase == 'a' || lowerCase == 'c' || lowerCase == 'g' || lowerCase == 't' || lowerCase == 0)
			{
			return true;
			}
		return false;
		}
		
	}
