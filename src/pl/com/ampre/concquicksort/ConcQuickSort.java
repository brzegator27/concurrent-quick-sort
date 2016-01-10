package pl.com.ampre.concquicksort;

import pl.com.ampre.DoublesArrSorting;
import static pl.com.ampre.util.Util.exchange;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Jakub on 2015-12-27.
 */
public class ConcQuickSort extends RecursiveAction implements DoublesArrSorting {
    private int threadsNo;

    protected double[] arr;
    protected int   low,
                    high;

    public ConcQuickSort(double[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
        this.threadsNo = 1;
    }

    public ConcQuickSort(double[] arr, int low, int high, int threadsNo) throws Exception {
        if (threadsNo < 1) {
            throw new Exception("The number of threads is less than one! It should be 1 or more.");
        }

        this.arr = arr;
        this.low = low;
        this.high = high;
        this.threadsNo = threadsNo;
    }

    @Override
    protected void compute() {
        try {
            quickSort(arr, low, high);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sort() throws Exception {
        compute();
    }

    public void sort(double[] arr) throws Exception {
        quickSort(arr, 0, arr.length - 1);
    }

    public void sort(double[] arr, int begin, int end) throws Exception {
        quickSort(arr, begin, end);
    }

    protected void quickSort(double[] arr, int low, int high) throws Exception {
        if (low < high) {
            int q = partition(arr, low, high);
            if(threadsNo > 2) {
                invokeAll(  new ConcQuickSort(arr, low, q - 1, threadsNo / 2),
                            new ConcQuickSort(arr, q + 1, high, threadsNo / 2));
//                System.out.println("asdf > 2");
            } else if(threadsNo == 2) {
                invokeAll(  new ConcQuickSort(arr, low, q - 1, 1));
                quickSort(arr, q + 1, high);
//                System.out.println("asdf == 2");
            } else {
                quickSort(arr, low, q - 1);
                quickSort(arr, q + 1, high);
            }
        }
    }

    protected int partition(double[] arr, int low, int high) {
        double x = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= x) {
                i++;
                exchange(arr, i, j);
            }
        }
        exchange(arr, i + 1, high);
        return i + 1;
    }
}
