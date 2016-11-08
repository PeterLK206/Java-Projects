package edu.greenriver.it.Driver;

import edu.greenriver.it.Merge.MyMergeSort;

import java.util.Arrays;

/**
 * Created by peter on 6/5/2016.
 * This class is used to initiate and test my MyMergeSort algorithm.
 */
public class Driver<T extends Comparable<T>> {

    /**
     * Main method used to initiate the program.
     * @param args are not used in this program.
     */
    public static void main(String[] args) {

        sortSizeTwoArrayOrLess();

        sortArrayOfSize10WithTheSameValues();

        sortAReversedSortedArray();

        System.out.println("This method tests my MergeSort with arrays of size n where n is 100, 1000, 10000, 100000");
        sortArrayOfSizeN(100);
        sortArrayOfSizeN(1000);
        sortArrayOfSizeN(10000);
        sortArrayOfSizeN(100000);

    }

    /**
     * This tests to see if merge sort performs correctly with an array with a size of 2 or less.
     */
    public static void sortSizeTwoArrayOrLess(){
        Integer[] arrOfSizeOne = {6};
        Integer[] arrOfSizeTwo = {6, 1};

        MyMergeSort<Integer> mSortSizeOne = new MyMergeSort<>(arrOfSizeOne);
        MyMergeSort<Integer> mSortSizeTwo = new MyMergeSort<>(arrOfSizeTwo);

        System.out.println("This method tests my MergeSort with 2 or less values.");
        System.out.println("Merge sort of array of size one: " + Arrays.toString(mSortSizeOne.getSortedArray()));
        System.out.println("Merge sort of array of size two: " + Arrays.toString(mSortSizeTwo.getSortedArray()));
        System.out.println();

    }

    /**
     * This tests to see if merge sort performs correctly with an array that contains values all with the same value.
     */
    public static void sortArrayOfSize10WithTheSameValues(){
        Integer[] arrWith10IdenticalValues = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};

        MyMergeSort<Integer> mSortWith10IdenticalValues = new MyMergeSort<>(arrWith10IdenticalValues);

        System.out.println("This method tests my MergeSort with 10 elements with the same value.");
        System.out.println("Merge sort of array of 10 identical values: " + Arrays.toString(mSortWith10IdenticalValues.getSortedArray()));
        System.out.println();
    }

    /**
     * This tests to see if merge sort performs correctly with an array that is sorted in reverse order.
     */
    public static void sortAReversedSortedArray(){

        Integer[] arrInReverseSortedOrder = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        MyMergeSort<Integer> mSortInReverseSortedOrder = new MyMergeSort<>(arrInReverseSortedOrder);

        System.out.println("This method tests my MergeSort with elements in reversed order");
        System.out.println("Merge sort of array of elements in reverse order: " + Arrays.toString(mSortInReverseSortedOrder.getSortedArray()));
        System.out.println();

    }

    /**
     * This method sorts any array with the array size of N filling each value in the array with a random value
     * @param n the size of the array you want to sort
     */
    public static void sortArrayOfSizeN(int n){

        Integer[] arrOfSizeN = new Integer[n];

        for (int i = 0; i < n; i++) {
            int num = (int) Math.round(Math.random() * n);// <-- You can change n here to a static smaller value if you like, so its easier to see the sorted order in the console.

            arrOfSizeN[i] = num;
        }

        MyMergeSort<Integer> mSortArrSizeN = new MyMergeSort<>(arrOfSizeN);

        System.out.println("Merge sort of array of size n where n = " + n + ": " + Arrays.toString(mSortArrSizeN.getSortedArray()));
        System.out.println();

    }


}
