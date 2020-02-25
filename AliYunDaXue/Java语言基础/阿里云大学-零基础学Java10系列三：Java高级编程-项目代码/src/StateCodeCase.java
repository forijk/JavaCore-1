import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

class MessageUtil
{
    public static final int CHINA = 1;
    public static final int USA = 2;
    
    //private static final String KEY = "info";
    
    public static Locale getLocale(int num)
    {
        switch(num)
        {
        case CHINA :
            return new Locale("zh", "CN");
        
        case USA :
            return new Locale("en", "US");
        
        default:
            return null;
        }
    }
}

public class StateCodeCase
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 64 : 国家代码 ：执行国际化应用，从命令行输入国家代码 1中国 2美国，根据国家代码显示不同资源文件");
        
        if(args.length != 1)
        {
            System.out.println("invalid input : state code 1-china, 2-usa\n");
            System.exit(1);;
        }
        
        //根据不同的语言环境，实现指定区域的内容接收
        //Locale loc1 = new Locale("en", "US");
        //Locale loc1 = new Locale("cn", "ZH");
        Locale loc = MessageUtil.getLocale(Integer.parseInt(args[0]));
        
        
        //文件名称必须为.properties，读的时候不加入文件后缀
        //获取资源对象：顺序：指定区域 > 默认本地资源 > 公共资源
        ResourceBundle resource4ResourceBundle = ResourceBundle.getBundle("cn.mldn.message.testProperties", loc);
        //读取资源内容
        String val =  resource4ResourceBundle.getString("welcomeStr");
        System.out.println(val);
        
        //带占位符的资源文件，占位符必须做格式化处理
        String valInfo =  resource4ResourceBundle.getString("info"); 
        System.out.println(MessageFormat.format(valInfo, "mldn", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        
    }
}
