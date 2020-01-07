package tests.otherStudents;
/**
 * @author Jamie Sampson
 */

import edu.iastate.cs228.proj2.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class JamieLexicon {


    @Test
    public void test01_LexiconImplConstructor(){
        char[] chars = new char[] {'z', 'a', 'l'};
        LexiconImpl lex = new LexiconImpl(chars);

        LexiconImpl.CharacterValue[] expected = new LexiconImpl.CharacterValue[] {
                new LexiconImpl.CharacterValue(1, 'a'),
                new LexiconImpl.CharacterValue(2, 'l'),
                new LexiconImpl.CharacterValue(0, 'z')
        };
        assertEquals(lex.characterOrdering[0].character, expected[0].character);
        assertEquals(lex.characterOrdering[1].character, expected[1].character);
        assertEquals(lex.characterOrdering[2].character, expected[2].character);
        assertEquals(lex.characterOrdering[0].value, expected[0].value);
        assertEquals(lex.characterOrdering[1].value, expected[1].value);
        assertEquals(lex.characterOrdering[2].value, expected[2].value);
    }

    //requires that getCharacterOrdering works properly
    @Test
    public void test_02_LexiconImplCompare(){
        char[] chars = new char[] {'z', 'a', 'l'};
        LexiconImpl lex = new LexiconImpl(chars);

        assertEquals(0 ,lex.compare("azzl", "azzl")); // same strings
        assertEquals(1, lex.compare("zzal", "zza")); // a longer than b
        assertEquals(-1, lex.compare("za", "zal")); // b longer than a
        assertEquals(-1, lex.compare("azl", "lza")); // a < b (first char)
        assertEquals(-1, lex.compare("zal", "laz")); // a < b (first char)
        assertEquals(-1, lex.compare("zzzz", "zzza")); // a < b (last char)
        assertEquals(1, lex.compare("aalz", "aazl")); // a > b (mid char)
    }

    @Test
    public void test_03_LexiconImplGetCharacterOrdering(){
        char[] chars = new char[] {'z', 'a', 'l'};
        LexiconImpl lex = new LexiconImpl(chars);

        assertEquals(0, lex.getCharacterOrdering('z'));
        assertEquals(1, lex.getCharacterOrdering('a'));
        assertEquals(2, lex.getCharacterOrdering('l'));
        assertEquals(-1, lex.getCharacterOrdering('b'));
    }


    @Test
    public void test_04_LexiconImplIsValid() {
        char[] chars = new char[] {'z', 'a', 'l'};
        LexiconImpl lex = new LexiconImpl(chars);
        assertFalse(lex.isValid("aaaazzzd")); //error at last char
        assertFalse(lex.isValid("dazz")); // error at first char
        assertFalse(lex.isValid("zzadll")); // error at mid char
        assertTrue(lex.isValid("zzzaaall"));
        assertTrue(lex.isValid("lazlazlaz"));
        assertTrue(lex.isValid("lllllllll"));
    }

}
