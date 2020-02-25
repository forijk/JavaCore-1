import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

class FileUtil
{
    private File srcFile;
    private File desFile;
    
    public FileUtil(String src, String des)
    {
        this(new File(src), new File(des));
    }
    
    public FileUtil(File srcFile, File desFile)
    {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    
    
    private boolean copyFileImpl(File srcFile, File desFile) throws Exception
    {
        //创建文件夹
        if(!desFile.getParentFile().exists())
        {
            desFile.getParentFile().mkdirs();
        }
        
        InputStream input = null;
        OutputStream output = null;
        try
        {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            
            /*
             * JDK1.9
             * input.transferTo(output);
             * */
            
            int len = 0;
            byte cpyBuf[] = new byte[1024];//拷贝缓冲区
            while((len = input.read(cpyBuf)) != -1)
            {
                output.write(cpyBuf, 0, len);
            }  
            
            return true;
        }catch (Exception e)
        {
            throw e;
        }finally
        {
            if(input != null)
            {
                input.close();
            }
            if(output != null)
            {
                output.close();
            }           
        }
    }
    
    public boolean copy() throws Exception
    {
        if(!this.srcFile.exists())
        {
            System.out.println("源文件不存在！");
            return false;
        }
                
        return this.copyFileImpl(this.srcFile, this.desFile);
    }
  
    
    private void copyImpl(File file) throws Exception
    {
        if(file.isDirectory())
        {
            File results[] = file.listFiles();
            if(results != null)
            {
                for(int x = 0; x < results.length; x++)
                {
                    copyImpl(results[x]);
                }
            }
        }
        else//文件
        {
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "");
            File newFile = new File(this.desFile, newFilePath);
            this.copyFileImpl(file,  newFile);
        }
    }
    
    public boolean copyDir() throws Exception
    {
        this.copyImpl(this.srcFile);
        try
        {
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}

//
public class fileCopyDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.79.文件拷贝：");
        
        if(args.length != 2)
        {
            System.out.println("入参错误： java JavaAPIDemo 拷贝源文件路径  拷贝目标文件路径");
            System.exit(1);
        }

        long start = System.currentTimeMillis();

        FileUtil fu = new FileUtil(args[0], args[1]);
        if(new File(args[0]).isFile())//文件拷贝
        {
            System.out.println(fu.copy() ? "文件拷贝成功！" : "文件拷贝失败！");
        }
        else//目录拷贝
        {
            System.out.println(fu.copyDir() ? "文件拷贝成功！" : "文件拷贝失败！");
        }
        
        long end = System.currentTimeMillis();
        System.out.println("拷贝完成的时间(毫秒) = " + (end - start));
    }
}
