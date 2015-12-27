package pl.com.ampre.concquicksort;

import pl.com.ampre.DoublesArrSorting;

/**
 * Created by Jakub on 2015-12-27.
 */
public class ConcQuickSort implements DoublesArrSorting {
    private int threadsNo;

    public ConcQuickSort() {
        threadsNo = 1;
    }

    public ConcQuickSort(int threadsNo) throws Exception {
        if(threadsNo < 1) {
            throw new Exception("The number of threads is less than one! It should be 1 or more.");
        }
        this.threadsNo = threadsNo;
    }

    public void sort(double[] arr) {

    }

    protected void quickSort(double[] arr, int low, int high) {

    }

    protected int partition(double[] arr, int low, int high) {

        return -999;
    }
}
