import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.83 RandomAccessFile ： ");
        
        File rafFile  = new File("d:" + File.separator + "test" + File.separator + "randomAccessFileTest.txt");
        RandomAccessFile raf = new RandomAccessFile(rafFile, "rw");
        
        //写
        String names[] = {"zhangsan", "wangwu  ", "lisi    "};
        int ages[] = new int[] {30, 20, 16};
        for(int i = 0; i < names.length; i++)
        {
            raf.write(names[i].getBytes());
            raf.writeInt(ages[i]);
        }
        raf.close();
              
        //读
        {
        raf = new RandomAccessFile(rafFile, "rw");
        raf.skipBytes(24);//第二个数据末尾，读第三个人
        byte[] data = new byte[8];
        int len = raf.read(data);
        System.out.println("姓名：" + new String(data, 0, len).trim() + "年龄： " + raf.readInt());
        }
        
        {
        raf.seek(12);//第一个数据末尾，读二个人
        byte[] data = new byte[8];
        int len = raf.read(data);
        System.out.println("姓名：" + new String(data, 0, len).trim() + "年龄： " + raf.readInt());
        }
  
        {
        raf.seek(0);//读指针调到开头，读第一个人
        byte[] data = new byte[8];
        int len = raf.read(data);
        System.out.println("姓名：" + new String(data, 0, len).trim() + "年龄： " + raf.readInt());
        }
        
        raf.close();
    }
}
