package edu.greenriver.it.commands;

import edu.greenriver.it.registrations.GRClass;
import edu.greenriver.it.registrations.Student;

/**
 * Created by peter on 11/11/2016.
 */
public class RegisterCommand extends AbstractEnrollmentCommand implements ICommand {

    private boolean somethingChanged = false;

    public RegisterCommand(Student student, GRClass aClass) {
        super(student, aClass);
    }

    public void execute() {
        registerStudent();
    }

    @Override
    public void unexecute() {

        if (!somethingChanged) {
            dropStudent();
        }
    }
}
