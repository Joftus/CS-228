package tests.edu.iastate.cs228.proj2;

import edu.iastate.cs228.proj2.MergeSort;
import edu.iastate.cs228.proj2.SorterWithStatistics;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSortTest {

    private Comparator<String> c = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    @Test
    public void sortHelper() {
        String[] a = {"i", "j", "k", "l", "m", "a", "b", "c", "d", "e", "f", "g", "h"};
        String[] a2 = Arrays.copyOf(a, a.length);
        Arrays.sort(a2);
        SorterWithStatistics s = new MergeSort();
        s.sort(a, c);
        Assert.assertArrayEquals(a2, a);

        String[] b = {"cat", "dog", "ferret", "horse", "guinea pig", "guinea", "gerbil", "gremlin", "bird", "parrot", "porcupine", "kitten"};
        String[] b2 = Arrays.copyOf(b, b.length);
        Arrays.sort(b2);
        SorterWithStatistics s2 = new MergeSort();
        s2.sort(b, c);
        Assert.assertArrayEquals(b2, b);

        String[] d = {"France", "Europe", "france", "Orange", "Purple", "Maroon", "europe"};
        String[] d2 = Arrays.copyOf(d, d.length);
        Arrays.sort(d2);
        SorterWithStatistics s3 = new MergeSort();
        s3.sort(d, c);
        Assert.assertArrayEquals(d2, d);
    }
}