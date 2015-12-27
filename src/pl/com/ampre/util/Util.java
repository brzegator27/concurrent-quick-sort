package pl.com.ampre.util;

/**
 * Created by Jakub on 2015-12-27.
 */
public class Util {
    public static void exchange(double[] arr, int firstIdx, int secondIdx) {
        double temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }
}
