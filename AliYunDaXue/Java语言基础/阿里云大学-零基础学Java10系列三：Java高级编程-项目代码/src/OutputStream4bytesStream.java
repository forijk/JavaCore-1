import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStream4bytesStream
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 73 : OutputStream字节输出流：");
        File outputFile  = new File("d:" + File.separator + "test" + File.separator + "outputStream.txt");
        
        if(!outputFile.getParentFile().exists())
        {
            //父目录不存在，则创建
            outputFile.getParentFile().mkdirs();
        }
        
        //利用try catch自动关闭处理——是否只用自动关闭处理，取决于项目整体结构
        try(OutputStream outputStream = new FileOutputStream(outputFile, true))//true： 追加
        {
            String str = "Hello Leooooooooooo!\r\n";
            outputStream.write(str.getBytes());//将字符串变为直接数组
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
