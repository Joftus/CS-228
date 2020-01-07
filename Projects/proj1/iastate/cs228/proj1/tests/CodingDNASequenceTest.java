/**
* Author @Josh_Lofuts
* Sep 13, 2018
*/
package edu.iastate.cs228.proj1.tests;

import edu.iastate.cs228.proj1.CodingDNASequence;



public class CodingDNASequenceTest
	{
	public static void main(String[] args)
		{
		// Example 1
		String str1 = new String("AtGT");
		CodingDNASequence CSeq1 = new CodingDNASequence(str1.toCharArray());
		CSeq1.checkStartCodon();
		
		// Example 2
		String str2 = new String("AtgAAAA");
		CodingDNASequence CSeq2 = new CodingDNASequence(str2.toCharArray());
		CSeq2.checkStartCodon();
		
		// Example 3
		String str3 = new String("aTGCCCC");
		CodingDNASequence CSeq3 = new CodingDNASequence(str3.toCharArray());
		CSeq3.checkStartCodon();
		
		// Example 4
		String str4 = new String("AtGGGGG");
		CodingDNASequence CSeq4 = new CodingDNASequence(str4.toCharArray());
		CSeq4.checkStartCodon();
		
		// Example 5
		String str5 = new String("TTTT");
		CodingDNASequence CSeq5 = new CodingDNASequence(str5.toCharArray());
		CSeq5.checkStartCodon();
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 6
		String str6 = new String("asgasg");
		CodingDNASequence CSeq6 = new CodingDNASequence(str6.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 7
		String str7 = new String("$^^#%^");
		CodingDNASequence CSeq7 = new CodingDNASequence(str7.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 8
		String str8 = new String("ccc*");
		CodingDNASequence CSeq8 = new CodingDNASequence(str8.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 9
		String str9 = new String("ATGCta");
		CodingDNASequence CSeq9 = new CodingDNASequence(str9.toCharArray());
		CSeq9.checkStartCodon();
		
		// Example 10
		String str10 = new String("atGtact");
		CodingDNASequence CSeq10 = new CodingDNASequence(str10.toCharArray());
		CSeq10.checkStartCodon();
		
		// Example 11
		String str11 = new String("dddd");
		CodingDNASequence CSeq11 = new CodingDNASequence(str11.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 12
		String str12 = new String("AtGCTC");
		CodingDNASequence CSeq12 = new CodingDNASequence(str12.toCharArray());
		CSeq12.checkStartCodon();
		
		// Example 13
		String str13 = new String("tt^tt");
		CodingDNASequence CSeq13 = new CodingDNASequence(str13.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 14
		String str14 = new String("wwmm#");
		CodingDNASequence CSeq14 = new CodingDNASequence(str14.toCharArray());
		// Invalid sequence letter for class
		// edu.iastate.cs228.proj1.CodingDNASequenceTest
		
		// Example 15
		String str15 = new String("tGCa");
		CodingDNASequence CSeq15 = new CodingDNASequence(str15.toCharArray());
		CSeq15.checkStartCodon();
		// Returns false
		}
	}
