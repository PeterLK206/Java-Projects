package edu.greenriver.it.hr.commands;

import edu.greenriver.it.hr.OfficeStaff;
import edu.greenriver.it.hr.employees.Employee;

/**
 * Created by peter on 11/12/2016.
 */
public class ReferenceCheckCommand extends HRCommand{

    public ReferenceCheckCommand(Employee emp) {
        super(emp);
    }

    @Override
    public void execute() {
        OfficeStaff.referenceCheck(emp);
    }
}
