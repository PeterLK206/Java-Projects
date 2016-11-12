package edu.greenriver.it.commands;

import edu.greenriver.it.registrations.GRClass;
import edu.greenriver.it.registrations.Student;

/**
 * Created by peter on 11/11/2016.
 */
public abstract class AbstractEnrollmentCommand implements ICommand {
    protected Student student;
    protected GRClass aClass;
    protected boolean somethingChanged;

    public AbstractEnrollmentCommand(Student student, GRClass aClass) {
        this.student = student;
        this.aClass = aClass;
    }

    public void registerStudent() {

        aClass.registerStudent(student);

        System.out.println(student.getName() + " registered for " + aClass.getName());
    }

    public void dropStudent() {

        somethingChanged = aClass.dropStudent(student);

        System.out.println(student.getName() + " dropped from " + aClass.getName());
    }
}
