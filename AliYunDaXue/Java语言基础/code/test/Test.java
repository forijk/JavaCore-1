// class Test {
//     static int i;

//     public static void main(String args[]) {
//         System.out.println(i);
//     }
// }
public class Test {
    public int aMethod() {
        private int i = 0;
        i++;
        return i;
    }

    public static void main(String args[]) {
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}