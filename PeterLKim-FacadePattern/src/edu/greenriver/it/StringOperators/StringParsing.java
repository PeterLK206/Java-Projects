package edu.greenriver.it.StringOperators;

/**
 * Created by peter on 10/26/2016.
 * This class parses the string where it will take the value before or after a delimiter value.
 */
public class StringParsing {

    /**
     * This will return the value before the delimiter.
     * @param subject value being parsed
     * @param delimiter valued used to parse data
     * @return new value after parse
     */
    public static String before(String subject, String delimiter) {

        int lastOccurrence = subject.indexOf(delimiter);

        return parserHelper(subject, lastOccurrence);
    }

    /**
     * This will return the value before the delimiter
     * @param subject value being parsed
     * @param delimiter value used to parse data
     * @return new value after parse
     */
    public static String after(String subject, String delimiter) {

        int lastOccurrence = subject.indexOf(delimiter) + delimiter.length();

        return parserHelper(subject, lastOccurrence);
    }

    //Helper class to reduce redundancy
    private static String parserHelper(String subject, int cutOffPoint) {
        char[] subjectToArr = subject.toCharArray();

        char[] newWord = new char[cutOffPoint];

        for (int i = 0; i < newWord.length; i++) {

            newWord[i] = subjectToArr[i];

        }

        return String.copyValueOf(newWord);
    }
}
