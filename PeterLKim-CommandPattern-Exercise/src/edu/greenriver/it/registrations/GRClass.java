package edu.greenriver.it.registrations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by peter on 11/11/2016.
 */
public class GRClass {

    //track # of seats, class name and location, enrolled students
    private String name;
    private String location;
    private int seats;

    //student enrolled or on teh waiting list
    private List<Student> enrolledStudents = new ArrayList<Student>();
    private List<Student> waitListedStudents = new ArrayList<Student>();

    public GRClass(String name, String location, int seats) {
        this.name = name;
        this.location = location;
        this.seats = seats;
    }

    public Boolean registerStudent(Student student) {

        //quietly ignore unsuccessful registrations...
        if (!hasStudent(student)) {

            //is the class full?
            if(enrolledStudents.size() == seats){
                waitListedStudents.add(student);
            } else {
                enrolledStudents.add(student);
            }

            return true;

        }

        return false;

    }

    public boolean dropStudent(Student student){
        if (hasStudent(student)) {
            if (waitListedStudents.contains(student)){
                waitListedStudents.remove(student);
            } else {
                enrolledStudents.remove(student);
                if (waitListedStudents.size() > 0){
                    enrolledStudents.add(waitListedStudents.get(0));
                }
            }

            return true;
        }

        return false;
    }

    public boolean hasStudent(Student student){
        return enrolledStudents.contains(student) || waitListedStudents.contains(student);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSeats() {
        return seats;
    }

    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    public List<Student> getWaitListedStudents() {
        return Collections.unmodifiableList(waitListedStudents);
    }

    @Override
    public String toString() {
        return "GRClass{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", seats=" + seats +
                ", enrolledStudents=" + enrolledStudents +
                ", waitListedStudents=" + waitListedStudents +
                '}';
    }
}
