package edu.greenriver.it.StringOperators;

import java.util.HashSet;
import java.util.Set;

/**
 * This class controls all the string opertions for removeDups, resize and , filter
 * Created by peter on 10/26/2016.
 */
public class StringOperations {

    /**
     * this method removes duplicates from an array.
     * @param values String array
     * @return new String array with duplicates removed.
     */
    public static String[] removeDuplicates(String[] values) {

        Set<String> temp = new HashSet<>();

        for (String s : values) {
            temp.add(s);
        }

        String[] newArr = temp.toArray(new String[temp.size()]);

        return newArr;
    }

    /**
     * this method resizes the array
     * @param values array being resized
     * @param newLength new length of array
     * @return resized array
     */
    public static String[] resize(String[] values, int newLength) {

        String[] newArr;


             newArr = new String[newLength];
            for (int i = 0; i < newLength; i++) {
                newArr[i] = values[i];
            }

            return newArr;


    }

    /**
     * this filters a specific query from the array
     * @param values value being filtered
     * @param search array of values
     * @return new array
     */
    public static String[] filter(String[] values, String search) {

        int occurrence = 0;

        for (int i = 0; i < values.length; i++) {
            if(values[i].equals(search)){
                values[i] = "";
                occurrence++;
            }
        }

        for (int i = 0; i < values.length ; i++) {
            if(values[i].equals("")){
                for (int j = i; j < values.length-1 ; j++) {

                        values[j] = values[j + 1];

                }
            }
        }

        String[] newValues = new String[values.length - occurrence];
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = values[i];
        }
        return newValues;
    }

}
