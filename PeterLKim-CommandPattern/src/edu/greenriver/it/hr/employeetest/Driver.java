package edu.greenriver.it.hr.employeetest;

import edu.greenriver.it.hr.HumanResources;
import edu.greenriver.it.hr.commands.HRCommand;
import edu.greenriver.it.hr.employees.Employee;

/**
 * Created by peter on 11/12/2016.
 * This is the driver class, the class that runs the program.
 */
public class Driver {

    public static HumanResources hr;

    /**
     * Main method used to start the program
     * @param args
     */
    public static void main(String[] args) {

        hr = new HumanResources();

        loadAllCommands(setEmployees());
        runAllCommands();
        printAllEmployees();

    }

    /**
     * runs all commands in the todos map.
     */
    public static void runAllCommands(){
        for(HRCommand hrc : hr.getTodos()){
            hrc.execute();
        }
    }

    /**
     * creates a employee array with staticly created employees stored in them.
     * @return Employee[]
     */
    public static Employee[] setEmployees(){

        return new Employee[] {new Employee("Peter Kim"), new Employee("Josh Archer"), new Employee("John Smith"), new Employee("Jane Doe"), new Employee("Alex Dune")};

    }

    /**
     * loads all commands for all employees
     * @param empArr
     */
    public static void loadAllCommands(Employee[] empArr){

        for(Employee e : empArr){
            hr.loadAllCommandsForThisEmployee(e);
        }

    }

    /**
     * prints all the empoyees added to the namesToApplicants.
     */
    public static void printAllEmployees() {
        for (Employee e : setEmployees()){

            Employee singleEmployee = hr.getNamesToApplicants().get(e.getName());

            System.out.println( singleEmployee.getName() + " (" + singleEmployee.getType() + ")");

        }
    }

}
