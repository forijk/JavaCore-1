import java.util.Random;
import java.util.Arrays;
/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String [] args) {
        int[] result = NumberFactory.create(5);
        System.out.println(Arrays.toString(result));
    }
}

class NumberFactory{
    private static Random random = new Random();
    /**
     * 
     * @param len The size of a Array  will created by us
     * @return 
     */
    public static int[] create(int len) {
        int[] data = new int[len];
        int foot = 0;
        while (foot<data.length) {
            int num = random.nextInt(30);
            if (num != 0 ) {
                data[foot++] = num;
            }
        }
        return data;
    }
} 