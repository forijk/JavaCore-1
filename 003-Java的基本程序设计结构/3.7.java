import java.util.*;
/**
 * this program demonstrates console inout
 */
public class InputTest {  // className is same of filename
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name: ");
        String name = in.nextLine();

        // get second input 
        System.out.print("How old are you: ");
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello," + name + ". Next year, you`ll be " + (age + 1));
        System.out.printf("Hello, %s. New year ,you`ll be %d", name, age);

    }
}