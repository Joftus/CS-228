/**
* Author @Josh_Lofuts
* Sep 13, 2018
*/
package edu.iastate.cs228.proj1.tests;

import edu.iastate.cs228.proj1.ProteinSequence;



public class ProtienSequenceTest
	{
	public static void main(String[] args)
		{
		// Given example
		String probst4 = new String("BJU");
		ProteinSequence probj = new ProteinSequence(probst4.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 1
		String str1 = new String("xXxxX");
		ProteinSequence PSeq1 = new ProteinSequence(str1.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 2
		String str2 = new String("aaAcc");
		ProteinSequence PSeq2 = new ProteinSequence(str2.toCharArray());
		
		// Example 3
		String str3 = new String("yywM");
		ProteinSequence PSeq3 = new ProteinSequence(str3.toCharArray());
		
		// Example 4
		String str4 = new String("dDfg");
		ProteinSequence PSeq4 = new ProteinSequence(str4.toCharArray());
		
		// Example 5
		String str5 = new String("ggGi");
		ProteinSequence PSeq5 = new ProteinSequence(str5.toCharArray());
		
		// Example 6
		String str6 = new String("uUUo");
		ProteinSequence PSeq6 = new ProteinSequence(str6.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 7
		String str7 = new String("jojU");
		ProteinSequence PSeq7 = new ProteinSequence(str7.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 8
		String str8 = new String("vCv>");
		ProteinSequence PSeq8 = new ProteinSequence(str8.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 9
		String str9 = new String("-./");
		ProteinSequence PSeq9 = new ProteinSequence(str9.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 10
		String str10 = new String("#####");
		ProteinSequence PSeq10 = new ProteinSequence(str10.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 11
		String str11 = new String("aAhIh");
		ProteinSequence PSeq11 = new ProteinSequence(str11.toCharArray());
		
		// Example 12
		String str12 = new String("jJUu");
		ProteinSequence PSeq12 = new ProteinSequence(str12.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 13
		String str13 = new String("pqpq");
		ProteinSequence PSeq13 = new ProteinSequence(str13.toCharArray());
		
		// Example 14
		String str14 = new String("BBU");
		ProteinSequence PSeq14 = new ProteinSequence(str14.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence
		
		// Example 15
		String str15 = new String("sSSe");
		ProteinSequence PSeq15 = new ProteinSequence(str15.toCharArray());
		
		}
	}
