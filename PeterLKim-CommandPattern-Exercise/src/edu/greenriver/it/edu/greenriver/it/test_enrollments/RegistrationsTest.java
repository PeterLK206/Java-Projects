package edu.greenriver.it.edu.greenriver.it.test_enrollments;

import edu.greenriver.it.commands.CommandType;
import edu.greenriver.it.commands.DropCommand;
import edu.greenriver.it.commands.ICommand;
import edu.greenriver.it.commands.RegisterCommand;
import edu.greenriver.it.registrations.GRClass;
import edu.greenriver.it.registrations.Student;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by peter on 11/11/2016.
 */
public class RegistrationsTest {

    private static Queue<ICommand> commandQueue = new LinkedBlockingQueue<ICommand>();
    private static Stack<ICommand> undoStack = new Stack<ICommand>();
    private static Scanner console = new Scanner(System.in);
    private static Student[] students;
    private static GRClass[] classes;

    public static void main(String[] args) {
        students = getStudents();
        classes = getClasses();

        printMenuAndChoose();
    }

    public static void printMenuAndChoose(){

        while (true) {
            printMenu();
            makeUserChoice();
        }
    }

    public static void printMenu(){

        CommandType[] types = CommandType.values();
        for (int i = 0; i < types.length ; i++) {
            System.out.println((i+1) + ": " + types[i].toString());
        }

        System.out.println("x: execute all commands in the command queue");

        System.out.println("z: undo");
    }

    public static void makeUserChoice(){
        String choice = console.nextLine();

        switch (choice) {
            case "1":
                registerStudent();
                break;
            case "2":
                dropStudent();
                break;
            case "x":
                executeQueueOfCommands();
                break;
            case "z":
                undoLastCommand();
                break;
        }
    }

    public static void undoLastCommand() {
        if (!undoStack.isEmpty()){

            ICommand last = undoStack.pop();
            last.unexecute();

        }
    }

    public static void executeQueueOfCommands() {
        while(!commandQueue.isEmpty()){
            ICommand command = commandQueue.remove();
            command.execute();

            undoStack.push(command);
        }

    }

    public static void registerStudent(){
        ICommand register = new RegisterCommand(getStudentFromUser(), getClassFromUser());
        commandQueue.add(register);
    }

    public static void dropStudent() {
        ICommand drop = new DropCommand(getStudentFromUser(), getClassFromUser());
        commandQueue.add(drop);
    }

    public static Student getStudentFromUser(){
        System.out.println("Enter a student name: ");
        String studentName = console.nextLine();

        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(studentName)){
                return students[i];
            }
        }
        throw new IllegalStateException("Error finding student: " + studentName);
    }

    public static GRClass getClassFromUser() {
        System.out.println("Enter a class name: ");
        String className = console.nextLine();

        for (int i = 0; i < classes.length; i++) {
            if (classes[i].getName().equals(className)){
                return classes[i];
            }
        }
        throw new IllegalStateException("Error finding class: " + className);
    }

    public static GRClass[] getClasses() {
        return new GRClass[] {new GRClass("IT 426", "TC 120", 4), new GRClass("IT 333", "TC 206", 4), new GRClass("IT 301", "KC 309", 4)};
    }

    public static Student[] getStudents(){
        return new Student[] {new Student("Lindsey"), new Student("Barrack"), new Student("Tyler"), new Student("Susan"), new Student("Joseph")};
    }
}
