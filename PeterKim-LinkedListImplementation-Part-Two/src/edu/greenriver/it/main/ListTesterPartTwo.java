package edu.greenriver.it.main;

import edu.greenriver.it.linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is a class that tests my LinkedList part two methods
 */
public class ListTesterPartTwo
{
    public static MyLinkedList<String> list = new MyLinkedList<>();
    public static ArrayList<String> list2 = new ArrayList<>();

    /**
     * This is the main method used to initiate the whole program.
     * @param args we do not use these arguments in the program.
     */
    public static void main(String[] args)
    {
        list.add("0"); list.add("1");  list.add("2");  list.add("3");  list.add("4");  list.add("5");  list.add("6");  list.add("7");  list.add("8");  list.add("9");
        list2.add("00"); list2.add("11");  list2.add("22");  list2.add("33");  list2.add("44");  list2.add("55");  list2.add("66");  list2.add("77");  list2.add("88");  list2.add("99");

        //run the tests
        testAddAll();
        testContainsAll();
        testInsertAll();
        testRemoveAll();
        testSubList();
        testRetainAll();
        testToArray();
        testToGenericArray();
        testIterator();
    }

    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testAddAll()
    {

        //this method tests list.addAll(collection)

        System.out.println("testAddAll(): \nThis list is before addAll(): ");

        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        list.addAll(list2);

        System.out.println();//new line
        System.out.println();//new line

        System.out.println("This list is after addAll(): ");
        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }


        System.out.println();//new line
        System.out.println();//new line
    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testInsertAll()
    {
        //this method tests list.addAll(index, collection)

        System.out.println("testInsertAll(): \nThis list is before addAll(index, value): ");


        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        list.addAll(5, list2);

        System.out.println();//new line
        System.out.println();//new line

        System.out.println("This list is after addAll(): ");

        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        System.out.println();//new line
        System.out.println();//new line
    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testContainsAll()
    {
        //this method tests list.containsAll(collection)

        System.out.println("testContainsAll():");
        System.out.println("Added list2 as an argument to list.containsAll() and it returned " + list.containsAll(list2));

        System.out.println();
        System.out.println();
    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testRemoveAll()
    {

        //this method tests list.removeAll(collection)
        System.out.println("removeAll(): \nThis list is before removeAll");
        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        System.out.println();
        System.out.println();

        list.removeAll(list2);

        System.out.println("This list is after removeAll");
        for (String s : list) {

            System.out.print(" [" + s + "] ");
        }

        System.out.println();//new line
        System.out.println();//new line
    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testRetainAll()
    {
        //Repopulate List
        list.clear();
        list.add("0"); list.add("1");  list.add("2");  list.add("3");  list.add("4");  list.add("5");  list.add("6");  list.add("7");  list.add("8");  list.add("9");
        list.addAll(list2);
        //Repopulate List

        System.out.println("testRetainAll():");

        System.out.println("Before calling retainAll.");
        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        System.out.println();//new line
        System.out.println();//new line

        list.retainAll(list2);
        System.out.println("after calling retainAll.");
        for (String s : list) {
            System.out.print(" [" + s + "] ");
        }

        //this method tests list.retainAll(collection);
        System.out.println();//new line
        System.out.println();//new line

    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testSubList()
    {
        //this method tests list.subsist(from, to)

        System.out.println("testSubList():");
        for(String s : list.subList(5, 9)){
            System.out.print(" [" + s + "] ");
        }

        System.out.println();
        System.out.println();

    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testToArray()
    {
        //this method tests list.toArray()

        Object[] newArr = list.toArray();

        for(int i = 0; i < newArr.length; i++){

            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(" [" + newArr[i] + "] ");
        }


        System.out.println();
        System.out.println();

    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testToGenericArray()
    {
        //this method tests list.toArray(T[])

        String[] newString = new String[10];

        String[] newerString = list.toArray(newString);

        System.out.println("testToGenericArray():");
        for(int i = 0; i < newerString.length; i++ ){

            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(" [" + newerString[i] + "] ");

        }

        System.out.println();//new line
        System.out.println();//new line
    }


    /**
     * This method tests the addAll method in my linked list.
     */
    public static void testIterator()
    {
        System.out.println("testIterator():");
        //this method tests list.iterator()
        for ( String s : list) {
            System.out.print(" [" + s + "] ");
        }
    }
}
