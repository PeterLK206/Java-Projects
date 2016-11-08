package edu.greenriver.it.linkedlist;

import java.util.*;

/**
 * MyLinkedList<T> is an implementation of a doubly linked list.
 *
 * @param <T> This element represents the type of object used for the data structure.
 */
public class MyLinkedList<T> implements List<T>, Iterable<T> {
    // part #1 methods below...

    public Node<T> head;
    private Node<T> tail;
    private int size;
    private int modCount = 0;

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
     * Class used to create node object, Necessary for a linked list.
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
         * @param prev    this is a reference pointer to the previous node
         * @param next    this is a reference pointer to the next node
         */
        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    // part #2 methods below...

    /**
     * Class that adds all collections to a this linked list.
     *
     * @param other Another collection the is not this one.
     * @return returns a boolean value that determines weather or not it has been completed successfully
     */
    @Override
    public boolean addAll(Collection<? extends T> other) {

        for (T element : other) {
            add(element);
        }

        return true;
    }

    /**
     * Adds all collections to this linked list starting at the specified index.
     *
     * @param index index of where to start storing the other collection
     * @param other another collection that is not this one.
     * @return returns a boolean value that determines weather or not it has been completed successfully
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> other) {

        if (index < 0) {
            throw new IllegalArgumentException("Arguments must be GREATER THAN or Equal to zero.");
        }

        int counterIndex = index;

        for (T element : other) {

            add(counterIndex, element);
            counterIndex++;
        }

        return true;
    }

    /**
     * Checks whether all of the items in the other collections are also all in this linked list.
     *
     * @param other another collection that is not this one.
     * @return returns a boolean value that determines weather or not it has been completed successfully
     */
    @Override
    public boolean containsAll(Collection<?> other) {

        for (Object element : other) {

            if (!contains(element)) {
                return false;
            }
        }

        return true;

    }

    /**
     * removes all items in the collection that match the items in the other collections.
     *
     * @param other another collection that is not this one.
     * @return returns a boolean value that determines weather or not it has been completed successfully.
     */
    @Override
    public boolean removeAll(Collection<?> other) {

        for (Object element : other) {
            remove(element);
        }

        return true;

    }

    /**
     * removes all elements that are not in other.
     *
     * @param other another collection that is not this one.
     * @return returns a boolean value that determines weather or not it has been completed successfully
     */
    @Override
    public boolean retainAll(Collection<?> other) {
        clear();

        for (Object element : other) {
            add((T) element);
        }

        return true;

    }

    /**
     * Returns a linked list with the data between fromIndex and toIndex
     *
     * @param fromIndex The starting point index
     * @param toIndex   The ending point index
     * @return A new linked list with the data between fromIndex and toIndex
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {

        if (fromIndex < 0 || toIndex < 0) {
            throw new IllegalArgumentException("Arguments must be GREATER THAN zero.");
        }

        MyLinkedList<T> newLinkedList = new MyLinkedList<>();

        Node<T> current = head;

        for (int i = 0; i < fromIndex + 1; i++) {
            current = current.next;
        }

        int count = fromIndex;

        while (count != toIndex + 1) {
            newLinkedList.add(current.element);
            current = current.next;
            count++;
        }

        return newLinkedList;
    }

    /**
     * Takes all elements in the linked list and creates/stores them into an array and returns the array
     *
     * @return array of all linkedlist items.
     */
    @Override
    public Object[] toArray() {
        Object[] toArr = new Object[size];
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            toArr[i] = current.next.element;

            current = current.next;
        }

        return toArr;
    }

    /**
     * Takes in an array and stores all elements from this linked list and stores them in the array and returns the array.
     *
     * @param toFill array being passed in.
     * @param <T>    The type of array.
     * @return returns the filled array.
     */
    @Override
    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] toFill) {

        Node<T> current = (Node<T>) head;

        for (int i = 0; i < size; i++) {
            toFill[i] = current.next.element;
            current = current.next;
        }

        return toFill;
    }

    /**
     * The iterator method required to make your class iterable.
     *
     * @return returns an Iterator class
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator(head, this);
    }

    /**
     * The iterator cass is used to make your class iterable.
     */
    public class MyLinkedListIterator implements Iterator<T> {

        private Node<T> head;
        private MyLinkedList<T> list;
        private int currentPosition = 0;
        private int currentModCount;

        /**
         * constructor of the MyLinkedListIterator
         *
         * @param head the head node.
         * @param list this linked list.
         */
        public MyLinkedListIterator(Node<T> head, MyLinkedList<T> list) {
            this.head = head;
            this.list = list;

            currentModCount = list.modCount;
        }

        /**
         * checks to see if there is a next value.
         *
         * @return if there is a next value then returns true if there isnt a next value then returns false.
         */
        @Override
        public boolean hasNext() {

            if (list.modCount != currentModCount) {
                throw new ConcurrentModificationException("You can not change a Linked List while iterating over it");
            }

            return currentPosition < list.size();
        }

        /**
         * returns the next element in the list.
         *
         * @return next element in the list.
         */
        @Override
        public T next() {

            if (list.modCount != currentModCount) {
                throw new ConcurrentModificationException("You can not change a Linked List while iterating over it");
            }

            T nextElement = head.next.element;

            currentPosition++;
            head = head.next;

            return nextElement;
        }
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
