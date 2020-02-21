package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of lambda
 * @version 0.1 2020-2-11
 * @author Zhang shan
 */
public class LambdaTest {

    public static void main(String[] args) {
        String[] students = new String[] {"Mary","Lily","Zhangshan","Eath","PingYin","Mars","Venus"};
        System.out.println(Arrays.toString(students));

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        
        Arrays.sort(students,(first,second)->(first.length()-second.length()));
        System.out.println(Arrays.toString(students));

        Timer t = new Timer(1000, event->{
            System.out.println("The Time is " + new Date());
        });

        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
        
    }
}

