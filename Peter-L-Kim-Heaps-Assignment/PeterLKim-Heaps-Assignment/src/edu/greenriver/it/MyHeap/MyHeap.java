package edu.greenriver.it.MyHeap;

/**
 * Created by peter on 5/20/2016.
 * This class is an implementation of a ternary heap
 */


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This is a ternary heap class
 * @param <T> and Element of any type
 */
public class MyHeap<T extends Comparable<T>> implements Queue<T> {
    public static final int DEFAULT_HEAP_SIZE = 10;

    private T[] heapArr;
    private int size;
    private int nextIndex = 1;

    /**
     * The constructor for my ternary heap
     */
    public MyHeap() {
        heapArr = (T[]) new Comparable[DEFAULT_HEAP_SIZE + 1];
        size = 0;
    }

    /**
     * This is the add method used to add elements to the heap
     *
     * @param newElement and element of any type
     * @return a boolean value that tell you the item has been added
     */
    @Override
    public boolean add(T newElement) //insert() operation
    {
        if (nextIndex == heapArr.length) {
            resize();
        }

        heapArr[nextIndex] = newElement;

        percolateUp(nextIndex);

        nextIndex++;
        size++;
        return true;
    }

    /**
     * This is a method that lets you look at the element in index 1 without removing it.
     *
     * @return returns the element in postion 1
     */
    @Override
    public T peek() //findMin() operation
    {
        if(size == 0){
            throw new NoSuchElementException("This heap is empty");
        }

        return heapArr[1];
    }

    /**
     * This element removes an item from index 1
     *
     * @return returns the removed element
     */
    @Override
    public T remove() //deleteMin() operation
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is Empty");
        }

        //save our element to return
        T element = heapArr[1];

        //move the last element in the heap (size) to the first spot
        swap(1, size);

        //alter size
        size--;
        nextIndex--;

        percolateDown(1);

        return element;
    }

    /**
     * Give the size of the heap
     *
     * @return returns the size of the heap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * checks to see if the heap is empty or not.
     *
     * @return a boolean value indicating whether or not the heap is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * clears the heap and makes a new heap with no elements inside.
     */
    @Override
    public void clear() {
        size = 0;
        nextIndex = 1;
        heapArr = (T[]) new Comparable[DEFAULT_HEAP_SIZE + 1];
    }

    //Moves elements up if they are smaller than its parent
    private void percolateUp(int index) {

        while (index > 1) {
            int parentIndex = (index + 1) / 3;

            if (heapArr[index].compareTo(heapArr[parentIndex]) < 0) {

                swap(index, parentIndex);

            }

            index = parentIndex;
        }

    }

    //Moves elements down if they are bigger then its children
    private void percolateDown(int index) {

        while (index < (size + 1)/3 ) {

            int left = (3 * index) - 1;
            int middle = 3 * index;
            int right = (3 * index) + 1;

            int indexToCheck = 0;

            //If LEFT is less than both RIGHT and MIDDLE it is the index to check
            if (left < size && heapArr[left].compareTo(heapArr[right]) <= 0 && heapArr[left].compareTo(heapArr[middle]) <= 0) {

                indexToCheck = left;
            }

            //If MIDDLE is less than both LEFT and RIGHT it is the index to check
            else if (middle < size && heapArr[middle].compareTo(heapArr[left]) <= 0 && heapArr[middle].compareTo(heapArr[right]) <= 0) {

                indexToCheck = middle;
            }

            //If RIGHT is less than both LEFT and MIDDLE it is the index to check
            else if (right < size && heapArr[right].compareTo(heapArr[left]) <= 0 && heapArr[right].compareTo(heapArr[middle]) <= 0) {

                indexToCheck = right;
            }

            if(heapArr[indexToCheck].compareTo(heapArr[index]) < 0){
                //swap
                swap(indexToCheck, index);

                //move to that child node and do the same
                index = indexToCheck;

            }else{
                break;//exit loop, heap order is complete
            }

        }

    }

    //Swaps the elements if two different indices
    private void swap(int first, int second) {
        T temp = heapArr[first];
        heapArr[first] = heapArr[second];
        heapArr[second] = temp;
    }

    //Resizes the heapArr if the heap grows bigger than the heapsize
    private void resize() {

        T[] newBinaryHeap = (T[]) new Comparable[heapArr.length * 2];

        for (int i = 0; i < heapArr.length; i++) {
            newBinaryHeap[i] = heapArr[i];
        }

        heapArr = newBinaryHeap;
    }

    //ignore methods below this

    @Override
    public boolean remove(Object search) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean contains(Object search) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public T poll() {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public T element() {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean offer(T e) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Method not supported.");
    }
}

