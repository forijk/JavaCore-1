
//可扩展规则
class Validator
{
    private Validator() {};
    
    public static boolean isEmail(String email)
    {
        if ((null == email) || ("".equals(email)))
        {
            return false;
        }
        
        String regex = "\\w+@\\w+\\.\\w+";
        return email.matches(regex);
    }
}

public class emailVarifyCase
{
    public static void main(String[] args)
    {
        System.out.println("lesson 61 email 验证：");
        
        if(args.length != 1)
        {
            System.out.println("程序入参错误，java emailVarifyCase email");
            System.exit(1); 
        }
        
        String email = args[0];
        if(Validator.isEmail(email))
        {
            System.out.println("email地址正确");
        }
        else
        {
            System.out.println("email地址错误");
        }
    }
}
