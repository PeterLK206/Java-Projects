package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.OfficeStaff;
import edu.greenriver.it.hr.employees.Employee;

/**
 * Created by peter on 11/12/2016.
 * This command checks the background of an Employee
 */
public class BackgroundCheckCommand extends HRCommand{

    /**
     * Constructor
     * @param emp Employee
     */
    public BackgroundCheckCommand(Employee emp) {
        super(emp);
    }

    /**
     * This method executes the command.
     */
    @Override
    public void execute() {

        OfficeStaff.backgroundCheck(this.emp);

    }
}
