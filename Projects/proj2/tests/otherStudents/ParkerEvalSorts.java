package tests.otherStudents;

import edu.iastate.cs228.proj2.Lexicon;
import org.junit.Before;
import tests.utils.FileRoots;
import edu.iastate.cs228.proj2.EvalSorts;
import edu.iastate.cs228.proj2.FileConfigurationException;
import edu.iastate.cs228.proj2.LexiconImpl;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Parker Bibus
 */
public class ParkerEvalSorts {
    String basePath = FileRoots.getProdFileRoot();  //Set to your base path for where the word lists are.
//    String baseEdgeCaseTestingPath = "src/edu/iastate/cs228/proj2/tests/";
    Lexicon lex;
    int numberOfTestsToRunTo = 10000;   //How high of input file to run too.

    /**
     * Sets up all the null line test file
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Before
    public void setup() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter file = new PrintWriter(FileRoots.getTestingFileRoot() + "nullLineTestFile.txt", "UTF-8");
        file.write(new char[]{'\0','\n','b','\n','c'});
        file.close();
    }

    /**
     * Ensures that the main method works for eval sorts.
     * DOES NOT TEST to make sure that fill errors are caught correctly because what would be returned is unique
     * each implementation
     */
    @Test
    public void main() {
        int i;
        for (i = 10; i <= numberOfTestsToRunTo; i *= 10) {
            String charStringHold = basePath + i + ".alphabet.txt";
            String stringStringHold = basePath + i + ".wordlist.txt";
            EvalSorts.main(new String[]{charStringHold, stringStringHold});
        }

    }

    /**
     * Ensures that eval constructing and runSorts runs properly.
     * @throws FileNotFoundException
     * @throws FileConfigurationException
     */
    @Test
    public void runSorts() throws FileNotFoundException, FileConfigurationException {
        int i;
        EvalSorts eval;
        for (i = 10; i <= numberOfTestsToRunTo; i *= 10) { //Use each alphabet list and text reading.
            String charStringHold = basePath + i + ".alphabet.txt";
            String stringStringHold = basePath + i + ".wordlist.txt";
            lex = new LexiconImpl(EvalSorts.readCharacterOrdering(charStringHold));
            eval = new EvalSorts(lex, EvalSorts.readWordsFile(stringStringHold, lex), numberOfTestsToRunTo);
            eval.runSorts();
        }
    }

    /**
     * Ensures that readCharacterOrdering is working properly.
     * Also makes sure exceptions are at least thrown in missing, null, repeat, and empty edge cases.
     * To properly check that the exceptions are being thrown correctly, use debug and see if each of the exception
     * spots are hit.
     * @throws FileNotFoundException
     * @throws FileConfigurationException
     */
    @Test
    public void readCharacterOrdering() throws FileNotFoundException, FileConfigurationException {
        int i;
        char[] correctList;
        char[] receivedList;
        for (i = 10; i <= numberOfTestsToRunTo; i *= 10) { //Use each alphabet list and text reading.
            String stringHold = basePath + i + ".alphabet.txt";
            String hold;
            receivedList = EvalSorts.readCharacterOrdering(stringHold);
            File file = new File(stringHold);
            Scanner scan = new Scanner(file);
            correctList = new char[receivedList.length];
            int iterator = 0;
            while (scan.hasNextLine()) {
                hold = scan.nextLine();
                correctList[iterator] = (hold.toCharArray()[0]);
                iterator++;
            }
            assertArrayEquals(correctList, receivedList);
        }
//        assertThrows( FileNotFoundException.class, () -> {
//            EvalSorts.readCharacterOrdering("fakenameasldkfjal;ksdfjk;lasjdf.txt");
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readCharacterOrdering( baseEdgeCaseTestingPath + "nullLineTestFile.txt");
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readCharacterOrdering(baseEdgeCaseTestingPath + "repeatCharacterTestFile.txt");
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readCharacterOrdering(baseEdgeCaseTestingPath + "emptyFile.txt");
//        });
    }


    /**
     * Ensures that readWordsFile is working properly.
     * Also makes sure exceptions are at least thrown in missing, null, repeat, and empty edge cases.
     * To properly check that the exceptions are being thrown correctly, use debug and see if each of the exception
     * spots are hit.
     * @throws FileNotFoundException
     * @throws FileConfigurationException
     */
    @Test
    public void readWordsFile() throws FileNotFoundException, FileConfigurationException {
        int i;
        String[] correctList;
        String[] receivedList;
        for (i = 10; i <= numberOfTestsToRunTo; i *= 10) { //Use each alphabet list and text reading.
            String charHold = basePath + i + ".alphabet.txt";
            lex = new LexiconImpl(EvalSorts.readCharacterOrdering(charHold));
            String stringHold = basePath + i + ".wordlist.txt";
            receivedList = EvalSorts.readWordsFile(stringHold, lex);
            File file = new File(stringHold);
            Scanner scan = new Scanner(file);
            String hold;
            correctList = new String[receivedList.length];
            int iterator = 0;
            while (scan.hasNextLine()) {
                hold = scan.nextLine();
                correctList[iterator] = hold;
                iterator++;
            }
            assertArrayEquals(correctList, receivedList);
        }
//        assertThrows( FileNotFoundException.class, () -> {
//            EvalSorts.readWordsFile("fakenameasldkfjal;ksdfjk;lasjdf.txt", lex);
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readWordsFile(baseEdgeCaseTestingPath + "nullLineTestFile.txt", lex);
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readWordsFile(baseEdgeCaseTestingPath + "repeatCharacterTestFile.txt", lex);
//        });
//        assertThrows( FileConfigurationException.class, () -> {
//            EvalSorts.readWordsFile(baseEdgeCaseTestingPath + "emptyFile.txt", lex);
//        });
    }
}