package pl.com.ampre;

import pl.com.ampre.concquicksort.ConcQuickSort;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jakub on 2015-12-27.
 */
public class Main {

    static PerformanceComparisonTester tester = new PerformanceComparisonTester();

    public static void main(String[] args) throws Exception {
        System.out.println("Concurrent Quick Sort");

        Random randGen = new Random(123);
        double[] arr = {4, 12, 62, 16, 3, 73, 83, 2, 3, 7, 24};
        double[] arrRandomNumb = new double[100000],
                arrRandomNumb2 = new double[100000];
        for(int i = 0; i < arrRandomNumb.length; i++) {
            arrRandomNumb[i] = randGen.nextDouble();
            arrRandomNumb2[i] = randGen.nextDouble();
        }
//        sortArr(arr, new ConcQuickSort());

        ConcQuickSort sorter = new ConcQuickSort(arr, 0, arr.length - 1, 1);
        sorter.sort();

        ConcQuickSort sorterRandomNumb = new ConcQuickSort(arrRandomNumb, 0, arrRandomNumb.length - 1, 1);
        ConcQuickSort sorterRandomNumb2 = new ConcQuickSort(arrRandomNumb2, 0, arrRandomNumb2.length - 1, 2);

        tester.testOneStart();
        sorterRandomNumb.sort();
        tester.testOneEnd();

        tester.testTwoStart();
        sorterRandomNumb2.sort();
        tester.testTwoEnd();

        System.out.println(tester);

        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arrRandomNumb));
    }

//    protected static void sortArr(double[] arr, DoublesArrSorting sortingStrategy) {
//        sortingStrategy.sort(arr);
//    }

    private static class PerformanceComparisonTester {
        private long startTime1,
                startTime2,
                endTime1,
                endTime2;

        public void testOneStart() {
            startTime1 = System.currentTimeMillis();
        }

        public void testOneEnd() {
            endTime1 = System.currentTimeMillis();
        }

        public void testTwoStart() {
            startTime2 = System.currentTimeMillis();
        }

        public void testTwoEnd() {
            endTime2 = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            long totalTime1 = endTime1 - startTime1,
                    totalTime2 = endTime2 - startTime2;

            double percentage;

            percentage = totalTime2 - totalTime1;
            percentage /= totalTime2;
            percentage *= 100;

            return totalTime1 + ", " + totalTime2 + " -> " + percentage + "%";
        }
    }
}
