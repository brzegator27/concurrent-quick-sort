package pl.com.ampre.concquicksort;

import pl.com.ampre.DoublesArrSorting;
import static pl.com.ampre.util.Util.exchange;

/**
 * Created by Jakub on 2015-12-27.
 */
public class ConcQuickSort implements DoublesArrSorting {
    private int threadsNo;

    public ConcQuickSort() {
        threadsNo = 1;
    }

    public ConcQuickSort(int threadsNo) throws Exception {
        if (threadsNo < 1) {
            throw new Exception("The number of threads is less than one! It should be 1 or more.");
        }
        this.threadsNo = threadsNo;
    }

    public void sort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void sort(double[] arr, int begin, int end) {
        quickSort(arr, begin, end);
    }

    protected void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int q = partition(arr, low, high);
            quickSort(arr, low, q - 1);
            quickSort(arr, q + 1, high);
        }
    }

    protected int partition(double[] arr, int low, int high) {
        double x = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                exchange(arr, i, j);
            }
        }
        exchange(arr, i + 1, high);
        return i + 1;
    }
}
