
/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main (String [] args) {
        StringBuffer buffer = new StringBuffer();
        for (int x = 'a'; x <= 'z'; x++) {
            buffer.append((char)x);
        }
        buffer.reverse().delete(0, 5);
        System.out.println(buffer);
    }
}
// 不考虑 并发问题