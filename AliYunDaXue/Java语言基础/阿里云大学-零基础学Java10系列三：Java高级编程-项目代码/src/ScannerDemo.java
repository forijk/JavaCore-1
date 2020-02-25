import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ScannerDemo
{
    public static void main(String[] args) throws ParseException, FileNotFoundException
    {
        System.out.println("Lesson 6.87 Scanner扫描流：——键盘数据输入");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年龄：");
        if(scan.hasNextInt())
        {
            int age = scan.nextInt();
            System.out.println("年龄：" + age);
        }
        else
        {
            System.out.println("请输入正确的年龄！");
        }
        
        System.out.println("请输入信息：");
        if(scan.hasNext())
        {
            String msg = scan.next();
            System.out.println("输入的信息：" + msg);
        }
        
        System.out.println("请输入生日：yyyy-MM-dd");
        if(scan.hasNext("\\d{4}-\\d{2}-\\d{2}"))
        {
            String birthStr = scan.next("\\d{4}-\\d{2}-\\d{2}");
            System.out.println("输入的信息：" + new SimpleDateFormat("yyyy-MM-dd").parse(birthStr));
        }
        
        scan.close();
        
        scan = new Scanner(new File("d:" + File.separator + "test" + File.separator + "scannerTest.txt"));
        scan.useDelimiter("\n");//设置读取分隔符
        while(scan.hasNext())
        {
            System.out.println(scan.next());
        }
        
        scan.close();
    }
}
