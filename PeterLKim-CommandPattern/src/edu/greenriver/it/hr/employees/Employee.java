package edu.greenriver.it.hr.employees;

/**
 * This is the Employee class, it is used to create employee objects that store the name and type of employee.
 */
public class Employee
{
    private String name;
    private EmployeeType type;

    /**
     * Constructor
     * @param name String
     */
    public Employee(String name)
    {
        this.name = name;
    }
    
    //getters/setters

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public EmployeeType getType()
    {
        return type;
    }

    public void setType(EmployeeType type)
    {
        this.type = type;
    }

    public String toString()
    {
        return name + " (" + type + ")";
    }
}
