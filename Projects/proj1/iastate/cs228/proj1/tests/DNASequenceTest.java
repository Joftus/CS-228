/**
* Author @Josh_Lofuts
* Sep 13, 2018
*/
package edu.iastate.cs228.proj1.tests;

import edu.iastate.cs228.proj1.DNASequence;



public class DNASequenceTest
	{
	public static void main(String[] args)
		{
		// Given example
		String probst2 = new String("TDG");
		DNASequence dnaseqobj = new DNASequence(probst2.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 1 
		String str1 = new String("ACGT");
		DNASequence DNASeq1 = new DNASequence(str1.toCharArray());
		
		// Example 2 
		String str2 = new String("AAAA");
		DNASequence DNASeq2 = new DNASequence(str2.toCharArray());
		
		// Example 3
		String str3 = new String("CCCC");
		DNASequence DNASeq3 = new DNASequence(str3.toCharArray());
		
		// Example 4 
		String str4 = new String("GGGG");
		DNASequence DNASeq4 = new DNASequence(str4.toCharArray());
		
		// Example 5
		String str5 = new String("TTTT");
		DNASequence DNASeq5 = new DNASequence(str5.toCharArray());
		
		// Example 6
		String str6 = new String("B");
		DNASequence DNASeq6 = new DNASequence(str6.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 7
		String str7 = new String("AABG");
		DNASequence DNASeq7 = new DNASequence(str7.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 8
		String str8 = new String("AGBA");
		DNASequence DNASeq8 = new DNASequence(str8.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 9
		String str9 = new String("GATC");
		DNASequence DNASeq9 = new DNASequence(str9.toCharArray());
		
		// Example 10
		String str10 = new String("ATCJ");
		DNASequence DNASeq10 = new DNASequence(str10.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 11
		String str11 = new String("@#$$%");
		DNASequence DNASeq11 = new DNASequence(str11.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 12
		String str12 = new String("kajsdg");
		DNASequence DNASeq12 = new DNASequence(str12.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 13
		String str13 = new String("accc");
		DNASequence DNASeq13 = new DNASequence(str13.toCharArray());
		
		// Example 14
		String str14 = new String("aqwe");
		DNASequence DNASeq14 = new DNASequence(str14.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence
		
		// Example 15
		String str15 = new String("cggc");
		DNASequence DNASeq15 = new DNASequence(str15.toCharArray());
		
		}
	}
