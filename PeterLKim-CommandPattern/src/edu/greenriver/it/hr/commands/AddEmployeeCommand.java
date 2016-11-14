package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.HumanResources;
import edu.greenriver.it.hr.OfficeStaff;
import edu.greenriver.it.hr.employees.Employee;

/**
 * Created by peter on 11/12/2016.
 * This command adds employees to the HumanResource namesToApplicant map.
 */
public class AddEmployeeCommand extends HRCommand {

    HumanResources hr;

    /**
     * Constructor
     * @param emp Employee
     * @param hr HumanResource
     */
    public AddEmployeeCommand(Employee emp, HumanResources hr) {
        super(emp);
        this.hr = hr;
    }

    /**
     * executes the command
     */
    @Override
    public void execute() {
        hr.addApplicant(emp);
        System.out.println("New employee added to system \n");
    }
}
