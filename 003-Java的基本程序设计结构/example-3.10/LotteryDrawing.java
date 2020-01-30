import java.util.*;

/**
 * This program demonstrates array manipulation
 * @version 1.20 2020-01-30
 * @author Zhang 
 */

public class LotteryDrawing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you want draw?");
        int n = in.nextInt();

        // fill an array with numbers 1.2.3.4.5.6...
        int[] numbers = new int[n];
        for (int i=0;i < n;i++)
            numbers[i] = i+1;

        // draw k numbers and put them into another array
        int[] result = new int[k];
        for (int i=0;i < k;i++) {
            // make a random index between 0 and n-1
            int r = (int) (Math.random()*n);

            // pick the element at the random location
            result[i] = numbers[r];
            // move the last element into the random location and n--
            numbers[r] = numbers[n-1];
            n--;
        }
        // print the sorted array
        Arrays.sort(result);
        System.out.println("Bet the following combination.It will make you rich!");
        for (int r:result)
            System.out.println(r);
    }
}