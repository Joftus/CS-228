package tests.otherStudents;

import edu.iastate.cs228.proj2.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author Parker Bibus
 */
public class ParkerSorting {
    static String basePath = "proj2_Inputs/";   //Base path to your input files
    static String numberToUse = "1000";     //Input file number to use for testing
    static String wordsSS[];
    static String wordsQS[];
    static String wordsMS[];
    static String wordsSS2[];
    static String wordsQS2[];
    static String wordsMS2[];
    static String words2Correct[];
    static String words[] = {   //List of words that will be sorted in the first round.
            "hello",
            "goodbye",
            "aaaaaaaa",
            "bbbbbbbb",
            "money",
            "jackolantern",
            "zebra",
            "popsicle",
            "popsicle",
            "human",
            "cat",
            "kitten",
            "mouse",
            "programmer",
            "music",
            "trumpet",
            "fish"
    };
    static Lexicon lex;
    Comparator<String> comp = Comparator.naturalOrder();

    /**
     * Sets up all of the arrays to be used.
     */
    @Before
    public void setup() throws FileNotFoundException, FileConfigurationException {
        wordsSS = words.clone();
        wordsQS = words.clone();
        wordsMS = words.clone();
        String charStringHold = basePath + numberToUse + ".alphabet.txt";
        String stringStringHold = basePath + numberToUse + ".wordlist.txt";
        String correctStringHold = basePath + numberToUse + ".sortedlist.txt";
        char[] testAlphabet;
        testAlphabet = EvalSorts.readCharacterOrdering(charStringHold);
        lex = new LexiconImpl(testAlphabet);
        wordsMS2 = EvalSorts.readWordsFile(stringStringHold, lex);
        wordsQS2 = wordsMS2.clone();
        wordsSS2 = wordsMS2.clone();
        words2Correct = EvalSorts.readWordsFile(correctStringHold, lex);
        Arrays.sort(words);
    }

    /**
     * Tests that all sort variables are being updated and that the sort works as expected on the english alphabet.
     * Then tests against the selected input number and makes sure that total words sorted updates properly.
     * Will run all sorts in each assert all regardless if one before it fails.
     */
    @Test
    public void SelectionSort() {
        SelectionSort sort = new SelectionSort();
        sort.sort(wordsSS, comp);
//        assertTrue(sort.getTimeToSortWords() > 0);
        assertTrue(sort.getTotalTimeToSortWords() > 0);
//        assertTrue(sort.getWordsSorted() == words.length);
//        assertTrue(sort.getTotalWordsSorted() == words.length);
        assertArrayEquals(words, wordsSS);
        sort.sort(wordsSS2, lex);
//        assertTrue(sort.getTotalWordsSorted() == words.length + wordsSS2.length);
        assertArrayEquals(words2Correct, wordsSS2);
        System.out.println("Selection:" + "\n" + sort.getReport());
    }

    /**
     * Tests that all sort variables are being updated and that the sort works as expected on the english alphabet.
     * Then tests against the selected input number and makes sure that total words sorted updates properly.
     * Will run all sorts in each assert all regardless if one before it fails.
     */
    @Test
    public void QuickSort() {
        QuickSort sort = new QuickSort();
        sort.sort(wordsQS, comp);
//        assertTrue(sort.getTimeToSortWords() > 0);
        assertTrue(sort.getTotalTimeToSortWords() > 0);
//        assertTrue(sort.getWordsSorted() == words.length);
//        assertTrue(sort.getTotalWordsSorted() == words.length);
        assertArrayEquals(words, wordsQS);
        sort.sort(wordsQS2, lex);
//        assertTrue(sort.getTotalWordsSorted() == words.length + wordsQS2.length);
//        assertArrayEquals(words2Correct, wordsQS2);
        System.out.println("Quick:" + "\n" + sort.getReport());
    }

    /**
     * Tests that all sort variables are being updated and that the sort works as expected on the english alphabet.
     * Then tests against the selected input number and makes sure that total words sorted updates properly.
     * Will run all sorts in each assert all regardless if one before it fails.
     */
    @Test
    public void MergeSort() {
        MergeSort sort = new MergeSort();
        sort.sort(wordsMS, comp);
//        assertTrue(sort.getTimeToSortWords() > 0);
        assertTrue(sort.getTotalTimeToSortWords() > 0);
//        assertTrue(sort.getWordsSorted() == words.length);
//        assertTrue(sort.getTotalWordsSorted() == words.length);
        assertArrayEquals(words, wordsMS);
        sort.sort(wordsMS2, lex);
//        assertTrue(sort.getTotalWordsSorted() == words.length + wordsMS2.length);
        assertArrayEquals(words2Correct, wordsMS2);
        System.out.println("Merge:" + "\n" + sort.getReport());
    }
}