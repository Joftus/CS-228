package tests.otherStudents;
/**
 * @author Jamie Sampson
 */

import tests.utils.FileRoots;
import edu.iastate.cs228.proj2.EvalSorts;
import edu.iastate.cs228.proj2.FileConfigurationException;
import edu.iastate.cs228.proj2.LexiconImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class JamieEvalSorts {
    String basePath = FileRoots.getTestingFileRoot();
    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void readCharacterOrderingFileNotFound() throws FileConfigurationException, FileNotFoundException {
        ex.expect(FileNotFoundException.class);
        EvalSorts.readCharacterOrdering("FakeName");
        ex.expectMessage("File Not Found");
    }

    @Test
    public void readCharacterOrderingBaseCase() throws FileNotFoundException, FileConfigurationException {
        char[] test = EvalSorts.readCharacterOrdering(basePath + "smallTestFile.txt");
        char[] expected = {'*', 'j', 'a', 'z', '$', '#', '@', '8', '0'};
        assertArrayEquals(expected, test);
    }

    @Test
    public void readCharacterOrderingFileConfigTooLong() throws FileNotFoundException, FileConfigurationException {
        ex.expect(FileConfigurationException.class);
        EvalSorts.readCharacterOrdering(basePath + "wrongConfigTestFile.txt");
        ex.expectMessage("Error: line too long");
    }

    @Test
    public void readCharacterOrderingFileConfigAlreadyExists() throws FileNotFoundException, FileConfigurationException {
        ex.expect(FileConfigurationException.class);
        EvalSorts.readCharacterOrdering(basePath + "duplicatesTestFile.txt");
//        ex.expectMessage("Error: s already exists within array");
    }

    @Test
    public void readWordsFileFileNotFound() throws FileNotFoundException, FileConfigurationException {
        char[] chars = new char[]{'a', 'b'};
        LexiconImpl lex = new LexiconImpl(chars);
        ex.expect(FileNotFoundException.class);
        EvalSorts.readWordsFile("BadFile", lex);
        ex.expectMessage("File Not Found");
    }

    @Test
    public void readWordsFileFileConfig() throws FileNotFoundException, FileConfigurationException {
        char[] chars = new char[]{'a', 'z'};
        LexiconImpl lex = new LexiconImpl(chars);
        ex.expect(FileConfigurationException.class);
        EvalSorts.readWordsFile(basePath + "badWordTestFile.txt", lex);
//        ex.expectMessage("Error: z&a is an invalid line");
    }

    @Test
    public void readWordsFileBaseCase() throws FileNotFoundException, FileConfigurationException {
        char[] chars = new char[]{'A', 'B', '*', 'C', 'D'};
        LexiconImpl lex = new LexiconImpl(chars);
        String[] test = EvalSorts.readWordsFile(basePath + "validWordTestFile.txt", lex);
        String[] expected = {"*DAC", "DB", "C*", "AB"};
        assertArrayEquals(expected, test);
    }
}