package edu.greenriver.it.hr;

import java.util.*;

import edu.greenriver.it.hr.commands.*;
import edu.greenriver.it.hr.employees.Employee;

/**
 * This class is used to handle stroing commands and managing the todos and the namesToApplicants collections.
 */
public class HumanResources
{
    //list of commands to complete (first come, first serve)
    private List<HRCommand> todos = new ArrayList<HRCommand>();
    
    //list of Employees
    private Map<String, Employee> namesToApplicants = new TreeMap<String, Employee>();
    
    //public methods 
    
    public void testHiringProcess()
    {
        //add command items for adding 10 new applicants to our HR system
        
        //print new employees
    }

    /**
     * Loads all commands for a single employee.
     * @param e
     */
    public void loadAllCommandsForThisEmployee(Employee e){

        todos.add(new ConsoleOutputCommand(e));
        todos.add(new BackgroundCheckCommand(e));
        todos.add(new ReferenceCheckCommand(e));
        todos.add(new ChangeEmployeeTypeCommand(e));
        todos.add(new AddEmployeeCommand(e, this));

    }

    /**
     * Returns an unmodifiable list.
     * @return List<HRCommand>
     */
    public List<HRCommand> getTodos() {

        return Collections.unmodifiableList(todos);
    }

    /**
     * Returns an unmodifiable list.
     * @return Map<String, Employee>
     */
    public Map<String, Employee> getNamesToApplicants() {
        return  Collections.unmodifiableMap(namesToApplicants);
    }

    /**
     * adds an applicant to the namesToApplicant.
     * @param employee
     */
    public void addApplicant(Employee employee)
    {
        namesToApplicants.put(employee.getName(), employee);
    }
}
