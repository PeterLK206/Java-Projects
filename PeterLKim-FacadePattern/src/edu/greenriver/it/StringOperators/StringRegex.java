package edu.greenriver.it.StringOperators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to validate specific fields
 * Created by peter on 10/26/2016.
 */
public class StringRegex {

    /**
     * method that validates email
     * @param subject subject being validated
     * @return boolean value determining if it is valid
     */
    public static boolean isEmail(String subject){

        String emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
        return regexHelperClass(emailPattern, subject);
    }

    /**
     * method that validates zipcode
     * @param subject subject being validated
     * @return boolean value determining if it is valid
     */
    public static boolean isZipCode(String subject){

        String zipCodePattern = "^\\d{5}(-\\d{4})?$";
        return regexHelperClass(zipCodePattern, subject);
    }

    /**
     * method that validates phonenumber
     * @param subject subject being validated
     * @return boolean value determining if it is valid
     */
    public static boolean isPhoneNumber(String subject){

        String phoneNumberPattern = "^(\\d{3}-?\\d{3}-?\\d{4})$";
        return regexHelperClass(phoneNumberPattern, subject);
    }

    /**
     * method that validates url
     * @param subject subject being validated
     * @return boolean value determining if it is valid
     */
    public static boolean isUrl(String subject){

        String urlPattern = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
        return regexHelperClass(urlPattern, subject);
    }

    //method used to reduce redundancy
    private static boolean regexHelperClass(String expression, String stringToCheck){

        Pattern checkRegex = Pattern.compile(expression);
        Matcher regexMatcher = checkRegex.matcher(stringToCheck);

        return regexMatcher.find();
    }
}
