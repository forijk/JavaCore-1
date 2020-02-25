import cn.mldn.demo.factory.Factory;
import cn.mldn.demo.service.INumberService;

public class NumberCompareDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.91 数字大小比较：输入3整数，求3整数最大最小值，输入错误时可以重新输入");
        
        INumberService numberService = Factory.getInstance();
        int result [] =  numberService.stat(5);
        System.out.println("最大值：" + result[0] + "、" + "最小值" + result[1]);
    }
}
