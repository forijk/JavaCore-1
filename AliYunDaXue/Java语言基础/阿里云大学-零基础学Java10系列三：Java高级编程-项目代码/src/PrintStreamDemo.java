import java.io.File;
import java.io.PrintWriter;

public class PrintStreamDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.84 打印流 ：以后程序输出全部使用打印流 ");
        
        File file  = new File("d:" + File.separator + "test" + File.separator + "printStreamTest.txt");
        PrintWriter pwtr = new PrintWriter(file);
        
        pwtr.println("姓名：小强子");
        pwtr.print("年龄：");
        pwtr.println(78);
        
        
        //格式化输出--类似于linux格式化输出
        String name = "Leo";
        int age = 30;
        double salary = 19999.424355;
        pwtr.printf("姓名：%s, 年龄：%d, 收入：%9.2f", name, age, salary);
        
        pwtr.close();
    }
}
