package edu.greenriver.it.Merge;

/**
 * Created by peter on 6/3/2016.
 * This is my tri merge class when sorting an array you initialize this class
 * as an object with the array you would like to sort in the parameters.
 */
public class MyMergeSort<T extends Comparable<T>> {

    private T[] unsortedArray;//unsorted array

    /**
     * This is the constructor for the MyMergeSort class it excepts
     * the unsorted array as a parameter. The constructor also starts
     * the sort method after the passed in array has been assigned to this.unsortedArray
     *
     * @param unsortedArray unsorted array of any type.
     */
    public MyMergeSort(T[] unsortedArray) {
        this.unsortedArray = unsortedArray;
        sort();
    }

    // An recursive method that initializes the sort array.
    private void sort() {

        sort(unsortedArray);// passes in the unsorted property

    }

    // An recursive method that passes in a
    // array and splits the data into 3 and
    // sorts all arrays
    private void sort(T[] arr) {

        int numberOfElements = arr.length;// number of elements in arr

        // The two mid points of the array
        int midOne = (numberOfElements / 3) - 1;
        int midTwo = ((numberOfElements * 2) / 3) - 1;

        // The size of the Right, Middle and Left array if they were split in 3
        int leftArrSize = midOne + 1;
        int middleArrSize = numberOfElements - ((midOne + 1) + ((arr.length-1) - midTwo ));
        int rightArrSize = ((arr.length-1) - midTwo );

        // if number of elements are lower them 3 then you wouldn't be able to divide
        // by 3 and would need a special case so anything below 3 would be a base case.
        if (numberOfElements > 2) {

            // Initializing empty arrays for Left, Middle, Right
            // with the correct sizes for each array
            T[] left = (T[]) new Comparable[leftArrSize];
            T[] middle = (T[]) new Comparable[middleArrSize];
            T[] right = (T[]) new Comparable[rightArrSize];

            // individual counters to increment the right,
            // middle and left arrays correctly with the original array.
            int j = 0;
            int k = 0;
            int l = 0;

            // for loop that divides the original array
            // into 3 smaller arrays.
            for (int i = 0; i < arr.length; i++) {

                if (i <= midOne) {
                    left[j] = arr[i];
                    j++;
                } else if (i > midOne && i <= midTwo) {
                    middle[k] = arr[i];
                    k++;
                } else if (i > midTwo) {
                    right[l] = arr[i];
                    l++;
                }

            }

            // recursively calling sort on each separate array.
            sort(left);
            sort(middle);
            sort(right);

            // Merging all off the separate arrays into the original array.
            merge(arr, left, middle, right);

            //Base case if there are less than 3 numbers to sort just swap them.
        } else if (numberOfElements == 2) {
            if (arr[0].compareTo(arr[1]) >= 0) {

                T temp = arr[0];

                arr[0] = arr[1];
                arr[1] = temp;

            }
        }

    }

    // This method merges the left, middle and right arrays into
    // one array using the original array as a place holder.
    private void merge(T[] arr, T[] left, T[] middle, T[] right) {

        //Indexes for the left, middle and right arrays,
        int L = 0;
        int M = 0;
        int R = 0;

        // index of array place holder
        // -1 because I increment as soon as I enter the while loop.
        int arrIndex = -1;

        //Loops until arrIndex is n-1 of the arr length
        while (arrIndex < arr.length) {

            boolean lowestFound = false;// used to only enter an if statement if lowest of L, M and R hasn't been found yet this iteration,
                                        // if a lowest was found then lowest found is set to true and the while loop will not
                                        // enter any if statements the remainder of the loop.

            arrIndex++;

            if(L < left.length && lowestFound == false) {
                if (M < middle.length && R < right.length) {
                    if (left[L].compareTo(middle[M]) <= 0 && left[L].compareTo(right[R]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = left[L];
                        L++;

                    }
                } else if (M < middle.length) {
                    if (left[L].compareTo(middle[M]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = left[L];
                        L++;

                    }
                }else if (R < right.length){
                    if (left[L].compareTo(right[R]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = left[L];
                        L++;
                    }
                }else {

                    lowestFound = true;
                    arr[arrIndex] = left[L];
                    L++;

                }
            }

            if (M < middle.length && lowestFound == false) {
                if (L < left.length && R < right.length) {
                    if (middle[M].compareTo(left[L]) <= 0 && middle[M].compareTo(right[R]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = middle[M];
                        M++;

                    }
                } else if (L < left.length) {
                    if (middle[M].compareTo(left[L]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = middle[M];
                        M++;

                    }
                }else if (R < right.length){
                    if (middle[M].compareTo(right[R]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = middle[M];
                        M++;
                    }
                }else {

                    lowestFound = true;
                    arr[arrIndex] = middle[M];
                    M++;

                }
            }

            if (R < right.length && lowestFound == false) {
                if (M < middle.length && L < left.length) {
                    if (right[R].compareTo(middle[M]) <= 0 && right[R].compareTo(left[L]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = right[R];
                        R++;

                    }
                } else if (M < middle.length) {
                    if (right[R].compareTo(middle[M]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = right[R];
                        R++;

                    }
                }else if (L < left.length){
                    if (right[R].compareTo(left[L]) <= 0) {

                        lowestFound = true;
                        arr[arrIndex] = right[R];
                        R++;
                    }
                } else {

                    lowestFound = true;
                    arr[arrIndex] = right[R];
                    R++;

                }
            }
        }//end of while loop
    }//end of method

    /**
     * returns the sorted array
     * @return a sortered array of anytype
     */
    public T[] getSortedArray(){
        return unsortedArray;
    }
}
