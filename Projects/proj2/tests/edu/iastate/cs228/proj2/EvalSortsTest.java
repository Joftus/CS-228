package tests.edu.iastate.cs228.proj2;

import edu.iastate.cs228.proj2.FileConfigurationException;
import edu.iastate.cs228.proj2.Lexicon;
import edu.iastate.cs228.proj2.LexiconImpl;
import org.junit.Assert;
import org.junit.Test;
import tests.utils.FileRoots;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static edu.iastate.cs228.proj2.EvalSorts.readCharacterOrdering;
import static edu.iastate.cs228.proj2.EvalSorts.readWordsFile;

public class EvalSortsTest {
    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};
    Lexicon comp = new LexiconImpl(letters);
    private String baseRoot = FileRoots.getTestingFileRoot();

    @Test
    public void readCharacterOrderingTest() throws FileNotFoundException, FileConfigurationException {
        char[] expectedAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] actualAlphabet = readCharacterOrdering(baseRoot + "valid.alphabet.txt");
        Assert.assertArrayEquals(expectedAlphabet, actualAlphabet);
    }

    @Test (expected = FileNotFoundException.class)
    public void readCharacterOrderingNotFound() throws FileNotFoundException, FileConfigurationException{
        char[] result = readCharacterOrdering("not_a_file.txt");
    }

    @Test (expected = FileConfigurationException.class)
    public void readCharacterOrderingFileConfigException() throws FileNotFoundException, FileConfigurationException{
        char[] result = readCharacterOrdering(baseRoot + "doubleLetter.alphabet.txt");
    }

    @Test (expected = FileConfigurationException.class)
    public void readCharacterOrderingFileConfigException2() throws FileNotFoundException, FileConfigurationException{
        char[] result = readCharacterOrdering(baseRoot + "duplicateLetter.alphabet.txt");
    }

    @Test (expected = FileNotFoundException.class)
    public void readWordsFileNotFound()  throws FileNotFoundException, FileConfigurationException {
        String[] result = readWordsFile(baseRoot + "not_a_file.txt", comp);
    }

    @Test (expected = FileConfigurationException.class)
    public void readWordsFileConfigException() throws FileNotFoundException, FileConfigurationException{
        String[] result = readWordsFile(baseRoot + "incorrect.wordlist.txt", comp);
    }

    @Test
    public void readWordsTest() throws FileNotFoundException, FileConfigurationException {
        String[] expectedWords = {"cab", "bag", "him", "gem", "hi", "dimmed", "abba"};
        String[] actualWords = readWordsFile(baseRoot + "valid.wordlist.txt", comp);
        Assert.assertArrayEquals(expectedWords, actualWords);
    }
}