import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Reader4CharInput
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.76 Reader字符输入流：");
        
        File readerFile  = new File("d:" + File.separator + "test" + File.separator + "ReaderTest.txt");
        if(readerFile.exists())
        {
            Reader in = new FileReader(readerFile);
            char data[] = new char[1024];
            int len = in.read(data);
            System.out.println("读取输入内容： " + new String(data, 0, len));
            in.close();
        }
        
    }
}
