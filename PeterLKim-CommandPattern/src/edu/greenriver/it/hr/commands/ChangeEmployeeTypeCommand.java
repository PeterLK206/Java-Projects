package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.OfficeStaff;
import edu.greenriver.it.hr.employees.Employee;
import edu.greenriver.it.hr.employees.EmployeeType;

import java.util.Random;

/**
 * Created by peter on 11/12/2016.
 * This command changes the employee type randomy.
 */
public class ChangeEmployeeTypeCommand extends HRCommand {

    /**
     * Constructor
     * @param emp Employee
     */
    public ChangeEmployeeTypeCommand(Employee emp) {
        super(emp);
    }

    /**
     * executes the command
     */
    @Override
    public void execute() {

        int randomNum = 100 + (int)(Math.random() * 100);
        if ((randomNum % 2) == 0) {
            OfficeStaff.changeEmployeeStatus(emp, EmployeeType.HOURLY);
        } else {
            OfficeStaff.changeEmployeeStatus(emp, EmployeeType.SALARY);
        }

        System.out.println("Employee status changed to " + emp.getType());

    }
}