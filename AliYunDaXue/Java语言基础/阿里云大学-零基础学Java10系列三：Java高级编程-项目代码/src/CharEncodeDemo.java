import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CharEncodeDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.80 编码");
        
        System.getProperties().list(System.out);
        
        OutputStream output = new FileOutputStream("d:" + File.separator + "test" + File.separator + "encodeDemo.txt");
        output.write("中华人民共和国".getBytes());
        output.close();
    }
}
