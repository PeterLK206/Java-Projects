package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.employees.Employee;

/**
 * Created by peter on 11/12/2016.
 * this command prints out the name of the new hire.
 */
public class ConsoleOutputCommand extends HRCommand {

    /**
     * Constructor
     * @param emp Employee
     */
    public ConsoleOutputCommand(Employee emp) {
        super(emp);
    }

    /**
     * This method executes the command.
     */
    @Override
    public void execute() {
        System.out.println("Hiring new employee: " + emp.getName());
    }
}
