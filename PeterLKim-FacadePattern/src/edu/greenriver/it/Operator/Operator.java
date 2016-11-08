package edu.greenriver.it.Operator;

import edu.greenriver.it.StringOperators.StringOperations;

/**
 * Created by peter on 10/27/2016.
 * This is a class that helps run chain methods for behaviors of the String Operations.
 */
public class Operator {

    private static String[] subject;

    /**
     * Operator constructor.
     * @param subject string array being passed in
     */
    public Operator(String[] subject) {
        this.subject = subject;
    }

    /**
     * Returns an Operator's subject field.
     * @return Returns an Operator's subject field.
     */
    public String[] getSubject() {
        return subject;
    }

    /**
     * filters subject and returns a operator class.
     * @param search subject
     * @return operator
     */
    public Operator filter(String search){
        return new Operator(StringOperations.filter(subject, search));
    }

    /**
     * removesDuplicates from a subject.
     * @return Operator
     */
    public Operator removeDuplicates(){
        return new Operator(StringOperations.removeDuplicates(subject));
    }

    public Operator resize(int length){
        return new Operator(StringOperations.resize(subject, length));
    }
}
