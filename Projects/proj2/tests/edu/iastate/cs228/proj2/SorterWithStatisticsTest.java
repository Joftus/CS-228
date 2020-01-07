package tests.edu.iastate.cs228.proj2;

import edu.iastate.cs228.proj2.MergeSort;
import edu.iastate.cs228.proj2.QuickSort;
import edu.iastate.cs228.proj2.SelectionSort;
import edu.iastate.cs228.proj2.SorterWithStatistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class SorterWithStatisticsTest {

    private Comparator<String> c = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    @Test
    public void mergeSort() {
        SorterWithStatistics ms = new MergeSort();

        String[] a = {"Cabbage", "apple", "grape", "banana", "e", "carrot", "cranberry", "pineapple", "strawberry", "fraises"};
        String[] a2 = Arrays.copyOf(a, a.length);
        Arrays.sort(a2);
        ms.sort(a, c);
        Assert.assertArrayEquals(a2, a);

        Assert.assertEquals(ms.getReport().substring(0, 11), "MergeSort: ");
    }

    @Test
    public void quickSort() {
        SorterWithStatistics qs = new QuickSort();

        String[] a = {"Cabbage", "apple", "grape", "banana", "e", "carrot", "cranberry", "pineapple", "strawberry", "fraises"};
        String[] a2 = Arrays.copyOf(a, a.length);
        Arrays.sort(a2);
        qs.sort(a, c);
        Assert.assertArrayEquals(a2, a);

        Assert.assertEquals(qs.getReport().substring(0, 11), "QuickSort: ");
    }

    @Test
    public void selectionSort() {
        SorterWithStatistics ss = new SelectionSort();

        String[] a = {"Cabbage", "apple", "grape", "banana", "e", "carrot", "cranberry", "pineapple", "strawberry", "fraises"};
        String[] a2 = Arrays.copyOf(a, a.length);
        Arrays.sort(a2);
        ss.sort(a, c);
        Assert.assertArrayEquals(a2, a);

        Assert.assertEquals(ss.getReport().substring(0, 15), "SelectionSort: ");
    }
}