package edu.iastate.cs228.proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EvalSorts {
	public static final int kNumberOfWordsToSort = 10000;

	/**
	 main is responsible only for extracting fileNames from args,
     reading the files, and constructing an instance of the this 
     class configured with the input data.
	 FileNotFoundException and FileConfigurationException exceptions 
	 should be handled in main, i.e., print out appropriate message
	 to the user.
	*/
	public static void main(String args[]) {
		char[] alphabet   = null;  //ref to the Lexicon it creates. 
		String[] wordList = null;  //ref to the list of words to be sorted. 
		EvalSorts theApp  = null;  //ref to the app. 
		LexiconImpl comp  = null;  //the concrete lexicon your app uses. 
		
		//TODO
		/*
		 * 
		 *      Here you should add code that extracts the file names from the args array,
		 *      opens and reads the data from the files,constructs an instance of Lexicon from the character order file, 
		 *      and then create an instance of this class (EvalSorts) to act as a configured
		 *      instance of the application. After you have constructed the configured
		 *      instance, you should start it running (see below). 
		 *      
		 *      
		 *   
		 *  
		*/		
		

		//configure an instance of the app
		theApp = new EvalSorts(comp, wordList, kNumberOfWordsToSort);
		//now execute that instance
		theApp.runSorts();
		
	}

	
	private String[] words; //ref to the word lit
	private Lexicon lex;    //ef to the relevant lexicon	
	private int numWordsToSort = kNumberOfWordsToSort;
	
	/**
	 * This constructor configures an instance of EvalSorts to sort input read
	 * my main, using the character order read by main and now embedded in
	 * an instance of Lexicon
	 * @param lex the instance of lexicon to be used
	 * @param wordList the wordlist (as array of string)  to be sorted
	 * @param numWordsToSort each sort will be repeated until it has sorted
	 *                       this many words. 
	 */
	public EvalSorts(Lexicon lex, String[] wordList, int numWordsToSort) {
		//TODO
	}

	/**
	 * runSorts() performs the sort evaluation. 
	 * 
	 * Note: The three sorters extend a common base
	 * so they share the same interface for starting the sort and collecting statistics. 
	 * Thus, you should create instances of the sorter and save references to each in an 
	 * array of base type. This allows you to use a simple loop to run all the reports and 
	 * collect the statistics.   
	 */
	public void runSorts(){
		
		SorterWithStatistics[] sorters = new SorterWithStatistics[3];
		//TODO 

	}
	
	/**
	 * Reads the characters contained in filename and returns them as a character array.
	 * @param filename the file containing the list of characters
	 * @returns an char array representing the ordering of characters to be used 
	 *          or null if there is a FileNotFoundException.
	 */
	public static char[] readCharacterOrdering(String filename) 
			throws FileNotFoundException, FileConfigurationException {
		//TODO 
		return null; 
	}
	
	/**
	 * Reads the words from the file and returns them as a String array.
	 * @param filename file containing words
	 * @return the words contained in the file or null if there was a FileNotFoundException.
	 */
	public static String[] readWordsFile(String filename, Lexicon comp)
			throws FileNotFoundException, FileConfigurationException {
		//TODO 
		return null; 
	}

}
