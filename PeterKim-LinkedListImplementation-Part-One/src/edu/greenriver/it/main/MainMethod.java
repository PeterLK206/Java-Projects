package edu.greenriver.it.main;

import edu.greenriver.it.linkedlist.MyLinkedList;

/**
 * Created by peter on 5/6/2016.
 * Class Main Method
 * This class is used to test all of the methods I created in the linked list.
 */
public class MainMethod {

    private static MyLinkedList<String> list = new MyLinkedList<>();//Linked List

    /**
     * Main is used to initiate the start of a program
     *
     * @param args arguments reserved for console use we are not using these arguments in this application
     */
    public static void main(String[] args) {

        //run the tests
        testAdd();
        testInsert();
        testIsEmpty();
        testSize();
        testClear();
        testIndexOf();
        testContains();
        testGet();
        testSet();
        testRemoveElement();
        testRemoveIndex();
    }

    /**
     * TestAdd() method used to test the add method I created in the linked list.
     */
    public static void testAdd() {
        //this method tests list.add(element)
        list.add("Hello");
        list.add("World");
        list.add("My");
        list.add("Name");
        list.add("is");
        list.add("Peter");

        System.out.println("testAdd():");
        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
        System.out.println();

    }

    /**
     * testInsert() method that test the add(index, element) method I created in the linked list.
     */
    public static void testInsert() {
        //this method tests list.add(index, element)
        list.add(0, "Index-0");
        list.add(1, "Index-1");
        list.add(3, "Index-3");
        list.add(5, "Index-5");

        System.out.println("testInsert():");
        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
        System.out.println();
    }

    /**
     * testIsEmpty() Method that tests whether or not the linked list isEmpty method works.
     */
    public static void testIsEmpty() {
        //this method tests list.isEmpty()

        System.out.println("testIsEmpty():");
        System.out.println(list.isEmpty());

        System.out.println();
        System.out.println();
    }

    /**
     * testSize() method used to test wether or not the size method works.
     */
    public static void testSize() {
        //this method tests list.size()

        System.out.println("testSize():");
        System.out.println(list.size());

        System.out.println();
        System.out.println();
    }

    /**
     * testClear() method used to test wether or not the clear method works.
     */
    public static void testClear() {
        //this method tests list.clear()
        list.clear();

        System.out.println("testClear():");
        System.out.println("size: " + list.size());
        System.out.println("isEmpty? " + list.isEmpty());
        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
    }

    /**
     * testIndexOf() method used to test wether or not the indexOf method works.
     */
    public static void testIndexOf() {
        //this method tests list.indexOf(element)

        //repopulate Link List after clear function
        list.add("Yo-0");
        list.add("Hello-1");
        list.add("World-2");
        list.add("My-3");
        list.add("Name-4");
        list.add("is-5");
        list.add("Peter-6");

        System.out.println("testIndexOf():");
        System.out.println("the string \"Yo-0\" is at index: " + list.indexOf("Yo-0"));
        System.out.println("the string \"Hello-1\" is at index: " + list.indexOf("Hello-1"));
        System.out.println("the string \"World-2\" is at index: " + list.indexOf("World-2"));
        System.out.println("the string \"My-3\" is at index: " + list.indexOf("My-3"));
        System.out.println("the string \"Name-4\" is at index: " + list.indexOf("Name-4"));
        System.out.println("the string \"Is-5\" is at index: " + list.indexOf("is-5"));
        System.out.println("the string \"Peter-6\" is at index: " + list.indexOf("Peter-6"));
        System.out.println("the string \"ValueNotInLinkList\" is at index: ( " + list.indexOf("ValueNotInLinkList") + ") [if value is -1 item was not found]");

        System.out.println();
        System.out.println();

    }

    /**
     * testContains() method used to test wether or not the contains method works.
     */
    public static void testContains() {
        //this method tests list.contains(element)
        System.out.println("testContains():");
        System.out.println("LinkList contains \"Yo-0\" is : " + list.contains("Yo-0"));
        System.out.println("LinkList contains \"Hello-1\" is : " + list.contains("Hello-1"));
        System.out.println("LinkList contains \"World-2\" is : " + list.contains("World-2"));
        System.out.println("LinkList contains \"My-3\" is : " + list.contains("My-3"));
        System.out.println("LinkList contains \"Name-4\" is : " + list.contains("Name-4"));
        System.out.println("LinkList contains \"Is-5\" is : " + list.contains("is-5"));
        System.out.println("LinkList contains \"Peter-6\" is : " + list.contains("Peter-6"));
        System.out.println("LinkList contains \"Value-Not-In-LinkList\" is : " + list.contains("Value-Not-In-LinkList"));

        System.out.println();
        System.out.println();
    }

    /**
     * testGet() method used to test wether or not the get(index) method works.
     */
    public static void testGet() {
        //this method tests list.get(index)
        System.out.println("testGet():");
        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();

        //System.out.println(list.get(20)) numbers that exceed the size get a null pointer error;
        //System.out.println(list.get(-1)); Number that are smaller than zero throw illigalargumentexceptions.
        System.out.println();
        System.out.println();
    }

    /**
     * testSet() method used to test wether or not the set(index, element) method works.
     */
    public static void testSet() {
        //this method tests list.set(index, element)

        // List before any changes
        // "Yo-0"
        //"Hello-1"
        //"World-2"
        //"My-3"
        //"Name-4"
        //"Is-5"
        //"Peter-6"

        System.out.println("testSet():");
        list.set(1, "Woooooooosh"); //sets value in middle of list
        list.set(3, "Magic The Gathering");
        list.set(0, "Lets Play Some Football");//sets value at the front of the list
        list.set(6, "Studio Ghibili"); // sets value at the end of the list.

        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }

        System.out.println();

        //list.set(8, "Index is greater than size"); If list is greater than size throws an illegal arguments exception
        //list.set(-1, "Index below 0"); If index is smaller than 0 throws an illegal arguments exception

        System.out.println();
        System.out.println();

    }

    /**
     * testRemoveElement() method used to test wether or not the remove(element) method works.
     */
    public static void testRemoveElement() {
        //this method tests list.remove(element)
        System.out.println("testRemoveElement():");

        list.remove("Woooooooosh"); //remove element in the middle of the list
        list.remove("Studio Ghibili"); //remove element at the end of the list
        list.remove("Lets Play Some Football"); //remove element at the beginning of list
        list.remove("Cats"); // attempt to remove an element that is not in the list. Nothing Happens

        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }

        System.out.println();
        System.out.println();


    }

    /**
     * testRemoveIndex() method used to test wether or not the remove(index) method works.
     */
    public static void testRemoveIndex() {
        //this method tests list.remove(index)
        System.out.println("testRemoveIndex():");
        list.remove(0); //remove element at the front of the list
        list.remove(2); //remove element that is at the end of the list
        list.remove(list.size() - 1);// remove an element at the end of the list
        //list.remove(list.size()+10); //attempt to remove an element at an index higher than the size null pointer exception;

        for (int i = 0; i < list.size(); i++) {

            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }

        System.out.println();
    }
}


