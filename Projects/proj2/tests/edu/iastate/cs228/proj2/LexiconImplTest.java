package tests.edu.iastate.cs228.proj2;

import edu.iastate.cs228.proj2.LexiconImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LexiconImplTest {
    LexiconImpl lexicon;

    @Before
    public void setup(){
        char[] characters = {'c', 'B', 'A', 'C', 'd',  'D', 'E', 'a', 'b', 'e'};
        lexicon = new LexiconImpl(characters);

    }

    @Test
    public void constructor(){
        char[] characters = {'c', 'b', 'a'};
        LexiconImpl li = new LexiconImpl(characters);
        LexiconImpl.CharacterValue[] characterValues = li.characterOrdering;

        Assert.assertEquals('a', characterValues[0].character);
        Assert.assertEquals(2, characterValues[0].value);
        Assert.assertEquals('b', characterValues[1].character);
        Assert.assertEquals(1, characterValues[1].value);
        Assert.assertEquals('c', characterValues[2].character);
        Assert.assertEquals(0, characterValues[2].value);
    }

    @Test
    public void complexConstructor(){
        char[] chars = {'4', 'd', 'P', 'D', '*', '!', '\\'};
        LexiconImpl li = new LexiconImpl(chars);
        LexiconImpl.CharacterValue[] characterValues = li.characterOrdering;

        Assert.assertEquals('!', characterValues[0].character);
        Assert.assertEquals(5, characterValues[0].value);
        Assert.assertEquals('*', characterValues[1].character);
        Assert.assertEquals(4, characterValues[1].value);
        Assert.assertEquals('4', characterValues[2].character);
        Assert.assertEquals(0, characterValues[2].value);
        Assert.assertEquals('D', characterValues[3].character);
        Assert.assertEquals(3, characterValues[3].value);
        Assert.assertEquals('P', characterValues[4].character);
        Assert.assertEquals(2, characterValues[4].value);
        Assert.assertEquals('\\', characterValues[5].character);
        Assert.assertEquals(6, characterValues[5].value);
        Assert.assertEquals('d', characterValues[6].character);
        Assert.assertEquals(1, characterValues[6].value);
    }


    @Test
    public void compare() {
        Assert.assertEquals(0, lexicon.compare("ABCDEabcde", "ABCDEabcde"));
        Assert.assertEquals(-1, lexicon.compare("AEae", "aeAE"));
        Assert.assertEquals(1, lexicon.compare("ea", "AE"));
        Assert.assertEquals(-1, lexicon.compare("abcd", "abcde"));
        Assert.assertEquals(1, lexicon.compare("abcdeA", "abcde"));
    }

    @Test
    public void test02_LexiconImplCompare() {
        char[] chars = new char[] {'q', 'z', 'a'};
        LexiconImpl lex = new LexiconImpl(chars);
        Assert.assertEquals(0, lex.compare("qza", "qza"));
        Assert.assertEquals(-1, lex.compare("qza", "zqa"));
        Assert.assertEquals(1, lex.compare("qaz", "qza"));
    }

    @Test
    public void getCharacterOrdering() {
        Assert.assertEquals(2, lexicon.getCharacterOrdering('A'));
        Assert.assertEquals(9, lexicon.getCharacterOrdering('e'));
        Assert.assertEquals(6, lexicon.getCharacterOrdering('E'));
        Assert.assertEquals(-1, lexicon.getCharacterOrdering('h'));
    }

    @Test
    public void isValid() {
        Assert.assertTrue(lexicon.isValid("bCdE"));
        Assert.assertTrue(lexicon.isValid("Aced"));
        Assert.assertFalse(lexicon.isValid("Face"));
        Assert.assertFalse(lexicon.isValid("can"));
    }
}