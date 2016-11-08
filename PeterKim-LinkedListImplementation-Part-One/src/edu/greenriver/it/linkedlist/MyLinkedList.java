package edu.greenriver.it.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * MyLinkedList<T> is an implementation of a doubly linked list.
 *
 * @param <T> This element represents the type of object used for the data structure.
 */
public class MyLinkedList<T> implements List<T> {
    // part #1 methods below...


    public Node<T> head;
    private Node<T> tail;
    private int size;
    private int modCount;

    /**
     * MyLinkedList Constructer it initiates a new linked list.
     */
    public MyLinkedList() {
        Node<T> start = new Node<T>(null, null, null);
        Node<T> end = new Node<T>(null, start, null);
        start.next = end;

        this.head = start;
        this.tail = end;

        size = 0;
        modCount++;
    }

    /**
     * This method adds a element to the end of the list.
     *
     * @param newElement element of anytype stored in the data property of a Node object
     * @return a boolean value that determins whether or not the value has been added
     */
    @Override
    public boolean add(T newElement) {
        Node<T> newNode = new Node<T>(newElement, null, null);

        if (size == 0) {
            head.next = newNode;
            newNode.prev = head;

            newNode.next = tail;
            tail.prev = newNode;

        } else {

            tail.prev.next = newNode;
            newNode.prev = tail.prev;

            newNode.next = tail;
            tail.prev = newNode;

        }

        size++;
        modCount++;

        return true;
    }

    /**
     * Adds a value at the given index to the link list.
     *
     * @param index      the index at where the value will be added
     * @param newElement element of anytype stored in the data property of a Node object
     */
    @Override
    public void add(int index, T newElement) {
        if (size > index) {

            Node<T> newNode = new Node<T>(newElement, null, null);

            Node<T> currentNode = head;

            for (int i = 0; i < index + 1; i++) {
                currentNode = currentNode.next;

            }

            newNode.prev = currentNode.prev;
            newNode.next = currentNode;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;

            size++;
            modCount++;

        } else {

            throw new IllegalArgumentException("The index value is larger then the total elements in the Link List.");

        }

    }

    /**
     * Checks wether the boolean is empty or now empty
     *
     * @return a boolean value that idicates whether or not the list has anything in it.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * method that returns the total size of the linked list.
     *
     * @return returns the size of the linked list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * this method resets all the values in the linked list except the modcount to clear the linked list
     */
    @Override
    public void clear() {
        Node<T> start = new Node<T>(null, null, null);
        Node<T> end = new Node<T>(null, start, null);
        start.next = end;

        this.head = start;
        this.tail = end;

        size = 0;
        modCount++;
    }

    /**
     * This method searches the linked list for a value and returns the index of that value in the linked list.
     *
     * @param search The object that is being searched for.
     * @return The index at where the value was found.
     */
    @Override
    public int indexOf(Object search) {
        Node<T> currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;

            if (currentNode.element.equals(search)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * This method checks to see if a specific object exists in the linked list.
     *
     * @param search The object that is being checked to see if it exists in the linked list.
     * @return a boolean value that represents whether the item is or is not in the linked list.
     */
    @Override
    public boolean contains(Object search) {
        Node<T> currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;

            if (currentNode.element.equals(search)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method gets the data from the index at a specific index.
     *
     * @param index index of the item you are looking for.
     * @return returns the element of the node in the linked list and the give index.
     */
    @Override
    public T get(int index) {

        if (index < 0) {
            throw new IllegalArgumentException("Arguments must be GREATER THAN zero.");
        }

        Node<T> currentNode = head;

        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.element;
    }

    /**
     * This method finds the element at the given index and replaces the value with the given value.
     *
     * @param index index of the item you are looking to set
     * @param value the new value to be stored in the element at the given index
     * @return returns the old value.
     */
    @Override
    public T set(int index, T value) {
        if (index < 0) {
            throw new IllegalArgumentException("Arguments must be GREATER THAN zero.");
        }

        if (index > size) {
            throw new IllegalArgumentException("Arguments must be Less THAN zero.");
        }

        Node<T> currentNode = head;

        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }

        T oldValue;

        oldValue = currentNode.element;
        currentNode.element = value;

        modCount++;
        return oldValue;
    }

    /**
     * Removes an element that has been passed thru the peraameters
     *
     * @param search the item being checked agaist the linked list
     * @return returns a boolean that determins whether or not the item has been removed.
     */
    @Override
    public boolean remove(Object search) {
        Node<T> currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;

            if (currentNode.element.equals(search)) {

                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                currentNode.next = null;
                currentNode.prev = null;

                size--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes item at the give index
     *
     * @param index the index of the item you are looking to remove.
     * @return returns the node element value you removed.
     */
    @Override
    public T remove(int index) {
        Node<T> currentNode = head;
        T nodeValue;

        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }

        nodeValue = currentNode.element;

        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        currentNode.next = null;
        currentNode.prev = null;

        size--;
        modCount++;
        return nodeValue;
    }

    /**
     * Class used to create node object, Nessasary for a linked list.
     *
     * @param <T> This is a field for AnyType
     */
    public class Node<T> {

        private T element;
        private Node<T> prev;
        private Node<T> next;

        /**
         * Node constructor it is used to initiate a node object
         *
         * @param element this is for representing the data stored in the node.
         * @param prev    this is a refference pointer to the preveous node
         * @param next    this is a refference pointer to the next node
         */
        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    // part #2 methods below...

    @Override
    public boolean addAll(Collection<? extends T> other) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> other) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public boolean containsAll(Collection<?> other) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public boolean removeAll(Collection<?> other) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public boolean retainAll(Collection<?> other) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] toFill) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    // extra credit below...

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public int lastIndexOf(Object search) {
        throw new UnsupportedOperationException("This method is not supported.");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("This method is not supported.");
    }
}
