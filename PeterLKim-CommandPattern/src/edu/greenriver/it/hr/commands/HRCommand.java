package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.employees.Employee;

/**
 * This is the abstract class method. All commands for this application extends this class.
 */
public abstract class HRCommand {

    protected Employee emp;

    /**
     * executes a command.
     */
    public abstract void execute();

    /**
     * Constructor
     * @param emp Employee
     */
    public HRCommand(Employee emp) {
        this.emp = emp;
    }
}
