package edu.greenriver.it.commands;

import edu.greenriver.it.registrations.GRClass;
import edu.greenriver.it.registrations.Student;

/**
 * Created by peter on 11/11/2016.
 */
public class DropCommand extends AbstractEnrollmentCommand implements ICommand{

    public DropCommand(Student student, GRClass aClass) {
        super(student, aClass);
    }

    @Override
    public void execute() {
            dropStudent();
    }

    public void unexecute() {

        if (!somethingChanged) {
            registerStudent();
        }
    }
}
