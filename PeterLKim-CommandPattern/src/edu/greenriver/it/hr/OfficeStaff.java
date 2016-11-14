package edu.greenriver.it.hr;

import edu.greenriver.it.hr.employees.Employee;
import edu.greenriver.it.hr.employees.EmployeeType;

/**
 * This class is used to perform office functions.
 */
public class OfficeStaff
{

    /**
     * Checks background of employee
     * @param employee
     */
    public static void backgroundCheck(Employee employee)
    {
        System.out.println("Background check SUCCESSFUL!");
    }

    /**
     * Checks referenceCheck
     * @param employee
     */
    public static void referenceCheck(Employee employee)
    {
        System.out.println("Reference check VALID!");
    }

    /**
     * Changes Employee Type
     * @param employee
     * @param type
     */
    public static void changeEmployeeStatus(Employee employee, EmployeeType type)
    {
        employee.setType(type);
    }
}
