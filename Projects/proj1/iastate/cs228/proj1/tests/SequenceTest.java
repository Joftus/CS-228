/**
* Author @Josh_Lofuts
* Sep 13, 2018
*/
package edu.iastate.cs228.proj1.tests;

import edu.iastate.cs228.proj1.Sequence;



public class SequenceTest
	{
	public static void main(String[] args)
		{
		// Given example
		String probst = new String("T$G");
		Sequence seqobj = new Sequence(probst.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.Sequence
		
		// Example 1
		String str1 = new String("TsG");
		Sequence Seq1 = new Sequence(str1.toCharArray());
		
		
		// Example 2
		String str2 = new String("T.G");
		Sequence Seq2 = new Sequence(str2.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.Sequence
		
		// Example 3
		String str3 = new String("TtGgw");
		Sequence Seq3 = new Sequence(str3.toCharArray());
		
		// Example 4
		String str4 = new String("aasWdga");
		Sequence Seq4 = new Sequence(str4.toCharArray());
		str4.equals(str4);
		
		// Example 5
		String str5 = new String("##@##");
		Sequence Seq5 = new Sequence(str5.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.Sequence
		
		// Example 6
		String str6 = new String("TG's");
		Sequence Seq6 = new Sequence(str6.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.Sequence
		
		// Example 7
		String str7 = new String("uOu");
		Sequence Seq7 = new Sequence(str7.toCharArray());
		str7.equals(str7);
		
		// Example 8
		String str8 = new String("pQqqp");
		Sequence Seq8 = new Sequence(str8.toCharArray());
		
		
		// Example 9
		String str9 = new String(":...:");
		Sequence Seq9 = new Sequence(str9.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.Sequence
		
		// Example 10
		String str10 = new String("josh");
		Sequence Seq10 = new Sequence(str10.toCharArray());
		
		}
	}
