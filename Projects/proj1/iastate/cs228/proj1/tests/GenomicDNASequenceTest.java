/**
* Author @Josh_Lofuts
* Sep 13, 2018
*/
package edu.iastate.cs228.proj1.tests;

import edu.iastate.cs228.proj1.GenomicDNASequence;



public class GenomicDNASequenceTest
	{
	public static void main(String[] args)
		{
		// Given example
		String probst3 = new String("TGCH");
		GenomicDNASequence gdnaobj = new GenomicDNASequence(probst3.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 1
		String str1 = new String("ACGT");
		int[] iarr1 = new int[str1.length()];
		GenomicDNASequence GenDNASeq1 = new GenomicDNASequence(str1.toCharArray());
		GenDNASeq1.extractExons(iarr1);
		
		// Example 2
		String str2 = new String("AATG");
		int[] iarr2 = new int[str2.length()];
		GenomicDNASequence GenDNASeq2 = new GenomicDNASequence(str2.toCharArray());
		GenDNASeq2.extractExons(iarr2);
		
		// Example 3
		String str3 = new String("GGTA");
		int[] iarr3 = new int[str3.length()];
		GenomicDNASequence GenDNASeq3 = new GenomicDNASequence(str3.toCharArray());
		GenDNASeq3.extractExons(iarr3);
		
		// Example 4
		String str4 = new String("JJJJ");
		GenomicDNASequence GenDNASeq4 = new GenomicDNASequence(str4.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 5
		String str5 = new String("PIOPAF");
		GenomicDNASequence GenDNASeq5 = new GenomicDNASequence(str5.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 6
		String str6 = new String("TTTT");
		int[] iarr6 = new int[str6.length()];
		GenomicDNASequence GenDNASeq6 = new GenomicDNASequence(str6.toCharArray());
		GenDNASeq6.extractExons(iarr6);
		
		// Example 7
		String str7 = new String("TCCC");
		int[] iarr7 = new int[str7.length()];
		GenomicDNASequence GenDNASeq7 = new GenomicDNASequence(str7.toCharArray());
		GenDNASeq7.extractExons(iarr7);
		
		
		// Example 8
		String str8 = new String("adgsdag");
		GenomicDNASequence GenDNASeq8 = new GenomicDNASequence(str8.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 9
		String str9 = new String("BBAPP");
		GenomicDNASequence GenDNASeq9 = new GenomicDNASequence(str9.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 10
		String str10 = new String("AAAAAA");
		int[] iarr10 = new int[str10.length()];
		GenomicDNASequence GenDNASeq10 = new GenomicDNASequence(str10.toCharArray());
		GenDNASeq10.extractExons(iarr10);
		
		// Example 11
		String str11 = new String("GTGT");
		int[] iarr11 = new int[str11.length()];
		GenomicDNASequence GenDNASeq11 = new GenomicDNASequence(str11.toCharArray());
		GenDNASeq11.extractExons(iarr11);
		
		// Example 12
		String str12 = new String("AGTK");
		GenomicDNASequence GenDNASeq12 = new GenomicDNASequence(str12.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 13
		String str13 = new String("HTGH");
		GenomicDNASequence GenDNASeq13 = new GenomicDNASequence(str13.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 14
		String str14 = new String("TG..12");
		GenomicDNASequence GenDNASeq14 = new GenomicDNASequence(str14.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		
		// Example 15
		String str15 = new String("T");
		GenomicDNASequence GenDNASeq15 = new GenomicDNASequence(str15.toCharArray());
		//Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence
		}
	}
