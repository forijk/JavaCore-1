// import javax.xml.validation.Validator;

/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("请输入正确的格式:java JavaDemo xxxx@xxx.xxx");
            System.exit(1);
        }
        String email = args[0];
        if (Validator.isEmail(email)) {
            System.out.println("输入的email地址正确");
        } else {
            System.out.println("输入的email地址不正确");
        }
    }
}

class Validator {
    public static boolean isEmail (String email) {
        if(email == null || "".equals(email)) {
            return false;
        }
        String regex = "\\w+@\\w+\\.(com|cn|net)";
        return email.matches(regex);
    }
}