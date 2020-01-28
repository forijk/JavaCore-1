import java.util.*;

/**
 * This program demonstrates a <code>do/while</code> loop. 
 * @version 2020.1.20
 * @author you xiao dao
 */

public class Reitirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year?: ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double InterestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;
        // update account balance while user usn`t ready to retire
        do {
            // add this year`s payment and interrest
            balance += payment;
            double interest = balance * InterestRate / 100;
            balance += interest;

            year++;
            // print current balance
            System.out.printf("After year %d,your balance is %,.2f%n", year,balance);
            // ask if ready to retire and get input 
            System.out.printf("Ready to retire? (Y/N)");
            input = in.next();
        } while (input.equals("N"));
    }
}