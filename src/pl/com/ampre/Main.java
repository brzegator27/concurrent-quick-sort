package pl.com.ampre;

import pl.com.ampre.concquicksort.ConcQuickSort;
import java.util.Arrays;

/**
 * Created by Jakub on 2015-12-27.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Concurrent Quick Sort");

        double[] arr = {4, 12, 62, 16, 3, 73, 83, 2, 3, 7, 24};
        sortArr(arr, new ConcQuickSort());

        System.out.println(Arrays.toString(arr));
    }

    protected static void sortArr(double[] arr, DoublesArrSorting sortingStrategy) {
        sortingStrategy.sort(arr);
    }
}
