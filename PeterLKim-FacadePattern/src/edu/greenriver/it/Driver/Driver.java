package edu.greenriver.it.Driver;

import edu.greenriver.it.Facade.Facade;
import edu.greenriver.it.Operator.Operator;
import edu.greenriver.it.StringOperators.StringOperations;
import edu.greenriver.it.StringOperators.StringParsing;
import edu.greenriver.it.StringOperators.StringRegex;
import edu.greenriver.it.ValidationType.ValidationType;

/**
 * Created by peter on 10/26/2016.
 * Driver class to run the facade class.
 */
public class Driver {

    /**
     * The main class that drives the program.
     * @param args console arguments
     */
    public static void main(String[] args) {

        //Validate the following emails:
        String emailTest = "my_email@gmail.com";
        String emailTest1 = "e@e.com";
        String emailTest2 = "catch@22@.msn.com";

        //Validate the following zip codes:
        String zipcodeTest = "99999";
        String zipcodeTest1 = "88888-0000";
        String zipcodeTest2 = "9999";
        String zipcodeTest3 = "xxxxx";

        //Use an operator object to reduce the following array:
        String[] testStringArr = {"blue", "red", "white", "blue", "yellow", "yellow", "", "red", "red"};

        Facade validateEmail = new Facade();

        System.out.println("Start of Email Validation:\n");

        System.out.println("    is \"" + emailTest + "\" a valid email: " + validateEmail.validate(ValidationType.EMAIL, emailTest) + "\n");
        System.out.println("    is \"" + emailTest1 + "\" a valid email: " + validateEmail.validate(ValidationType.EMAIL, emailTest1) + "\n");
        System.out.println("    is \"" + emailTest2 + "\" a valid email: " + validateEmail.validate(ValidationType.EMAIL, emailTest2) + "\n");

        Facade validateZipcode = new Facade();

        System.out.println("Start of Zipcode Validation:\n");

        System.out.println("    is \"" + zipcodeTest + "\" a valid zipcode: " + validateZipcode.validate(ValidationType.ZIPCODE, zipcodeTest) + "\n");
        System.out.println("    is \"" + zipcodeTest1 + "\" a valid zipcode: " + validateZipcode.validate(ValidationType.ZIPCODE, zipcodeTest1) + "\n");
        System.out.println("    is \"" + zipcodeTest2 + "\" a valid zipcode: " + validateZipcode.validate(ValidationType.ZIPCODE, zipcodeTest2) + "\n");
        System.out.println("    is \"" + zipcodeTest3 + "\" a valid zipcode: " + validateZipcode.validate(ValidationType.ZIPCODE, zipcodeTest3) + "\n");

        Facade getMyOperator = new Facade();

        System.out.println("start of String[] operations:\n");

        System.out.print("    Before operation call: (");

        for (String s : testStringArr) {

                System.out.print(" " + s + ",");

        }

        System.out.print(")\n");

        Operator myOperator = getMyOperator.getOperator(testStringArr);

        String[] newArr = myOperator.filter("yellow").resize(5).getSubject();


        System.out.print("    After operation call: (");

        for (String s2 : newArr) {

                System.out.print(" " + s2 + ",");

        }

        System.out.print(")\n");


    }
}
