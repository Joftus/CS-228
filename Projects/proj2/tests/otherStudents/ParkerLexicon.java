package tests.otherStudents;

import edu.iastate.cs228.proj2.LexiconImpl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Parker Bibus
 */
public class ParkerLexicon {
    char[] chars = new char[]{'a', 'b', 'd', 'c'};  //Sets the order of the letters for the lexicon
    LexiconImpl lI = new LexiconImpl(chars);

    /**
     * Tests the compare method using predefined low, high, and equal pairings based off the lexicon comparator.
     */
    @Test
    public void compare() {
        String[][] lowPairs = {{"ab", "ba"}, {"bbbac", "bcccc"}, {"abcc", "ccbcbcbcb"}}; //Pairs where the first is less than the second
        String[][] highPairs = {{"dd", "dbd"}, {"acb", "abc"}, {"bbbbbb", "abbbbbb"}}; //Pairs where the first is greater than the second
        String[][] equalPairs = {{"a", "a"}, {"abd", "abd"}, {"bbbbc", "bbbbc"}};//Pairs where the first and second are equal
        int[] compareResults = new int[lowPairs.length + highPairs.length + equalPairs.length];
        int[] correctResults = new int[lowPairs.length + highPairs.length + equalPairs.length];
        int i;
        int j;
        int l;
        for(i = 0; i < lowPairs.length; i++){
            compareResults[i] = lI.compare(lowPairs[i][0], lowPairs[i][1]);
            correctResults[i] = -1;
        }
        for(j = 0; j < highPairs.length; j++){
            compareResults[i + j] = lI.compare(highPairs[j][0], highPairs[j][1]);
            correctResults[i + j] = 1;
        }
        for(l = 0; l < equalPairs.length; l++){
            compareResults[i + j + l] = lI.compare(equalPairs[l][0], equalPairs[l][1]);
            correctResults[i + j + l] = 1;
        }
        for (int k = 0;k < compareResults.length; k++) {
            assertTrue(compareResults[k] * correctResults[k] >= 0);  //Uses multiplication to make sure both numbers match in sign or are zero, does mean there is possibility for error when a number is supposed to return non zero but returns zero.
        }
    }

    /**
     * Ensures that the getCharacterOrdering method runs properly by checking the the returned character order
     * matches the value of the character at the corresponding postition.
     */
    @Test
    public void getCharacterOrderingForList() {
        int coLength = lI.characterOrdering.length;
        int[] charOrder = new int[lI.characterOrdering.length];
        int[] correctOrder = new int[lI.characterOrdering.length];
        for (int i = 0; i < coLength; i++) {
            charOrder[i] = this.getCharacterOrdering(lI.characterOrdering[i].character);
            correctOrder[i] = lI.characterOrdering[i].value;
        }
        assertArrayEquals(correctOrder, charOrder);
    }

    int getCharacterOrdering(char key) {
        return lI.getCharacterOrdering(key);
    }

    /**
     * Ensures that the isValid method is returning correctly based on the created lexicon
     */
    @Test
    public void isValid() {
        char[] valid = new char[] {'a', 'a', 'b', 'c', 'd', 'c', 'd'};
        char[] invalid = new char[] {'e', 'f', 'g', 'e', 't', 12, '\0'};
        boolean[] receivedValues = new boolean[valid.length + invalid.length];
        boolean[] correctValues  = new boolean[valid.length + invalid.length];
        int i;
        int j;
        for(i = 0; i < valid.length; i++){
            receivedValues[i] = lI.isValid(valid[i] + "");
            correctValues[i] = true;
        }
        for(j = 0; j < invalid.length; j++){
            receivedValues[i + j] = lI.isValid(invalid[j] + "");
            correctValues[i + j] = false;
        }
        assertArrayEquals(correctValues, receivedValues);
    }
}