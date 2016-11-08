package edu.greenriver.it.Facade;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import edu.greenriver.it.Operator.Operator;
import edu.greenriver.it.StringOperators.StringRegex;
import edu.greenriver.it.ValidationType.ValidationType;

/**
 * Created by peter on 10/27/2016.
 *
 * The Facade class
 * used to simplify the subsystem behind it.
 */
public class Facade {

    /**
     * Validates the subject string depending on the type of string.
     * @param type Type of data
     * @param subject Data being validated
     * @return boolean if it is valid or not.
     */
    public boolean validate(ValidationType type, String subject){
        switch (type){
            case EMAIL:
                return StringRegex.isEmail(subject);

            case URL:
                return StringRegex.isUrl(subject);

            case PHONENUMBER:
                return StringRegex.isPhoneNumber(subject);

            case ZIPCODE:
                return StringRegex.isZipCode(subject);

            default:
                System.out.println("Invalid Type.");
                return false;
        }
    }

    /**
     * Runs opertions on subject and send it back as an operator.
     * @param subject String array
     * @return Operator with String Array.
     */
    public static Operator getOperator(String[] subject){
        return new Operator(subject);
    }
}
