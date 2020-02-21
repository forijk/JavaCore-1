
public class MyClass {
    public static void main(String arguments[]) {
        MyClass C = new MyClass();
        C.amethod(arguments);
    }

    public void amethod(String[] arguments) {
        System.out.println(arguments);
        System.out.println(arguments[1]);
    }
}