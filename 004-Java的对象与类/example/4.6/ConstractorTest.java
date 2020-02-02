import java.util.*;
import java.util.jar.Attributes.Name;

/**
 * This program demonstrates object construction.
 */

public class ConstractorTest {
 
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();
        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getNameO + ",id=" + e.getldO + ",salary:" + e.getSalaryO);
    }
}

class Employee {
    private static int nextId;

    private int id;
    private String name= ""; // instance field initialization
    private double salary;

    // static initialization block
    {
        id = nextId;
        nextId++;
    }

    // three overloaded constructors
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // calls the Employee(String, double) constructor 
        this("Employee #" + nextId,s);
    }

    // the default constructor
    public Employee() {
        // name initialized to "" --see above
        // salary not explicitly set --initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
    
}

