package edu.greenriver.it.Driver;

import edu.greenriver.it.MyHeap.MyHeap;

/**
 * Created by peter on 5/22/2016.
 *
 * This class is written to initiate the program
 */
public class Driver {

    /**
     * Main method used to initiate the program
     *
     * @param args We dont use these arguments they are for the console.
     */
    public static void main(String[] args) {
        MyHeap<Integer> triHeap = new MyHeap<>();

        for (int i = 0; i < 20; i++) {

            int num = (int) Math.round(Math.random() * 10);
           // System.out.println(num);
           triHeap.add(num);
        }

        while(!triHeap.isEmpty()){

            System.out.println(triHeap.remove());
        }
    }


}
