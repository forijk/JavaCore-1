import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo
{
    //新文件后缀
    public static final String FILE_TYPE = ".jpg";
    
    public static void listDir(File file)
    {
        if(file.isDirectory())
        {
            File result[] = file.listFiles();
            
            if(result != null)
            {
                for(int i = 0; i < result.length; i++)
                {
                    listDir(result[i]);
                }
            }
        }
        
        //获得完整路径
        System.out.println(file);
    }
    
    public static void renameDir(File file)
    {
        if(file.isDirectory())
        {
            File results[] = file.listFiles();
            if(results != null)
            {
                //对目录中所有文件进行重命名
                for(int i = 0; i < results.length; i++)
                {
                    renameDir(results[i]);
                }
            }
        }
        else
        {
            //如果是文件，重命名
            if(file.isFile())
            {
                //File newFile = new File(file.getParentFile(file.getName().lastIndexOf(".")));
                String fileName = null;
                if(file.getName().contains("."))
                {
                    fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + FILE_TYPE;
                }
                else
                {
                    fileName = file.getName() + FILE_TYPE;
                }
                
                File newFileName = new File(file.getParentFile(), fileName);
                
                file.renameTo(newFileName);
                //System.out.println(fileName);
            }
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println("6.67 6.68 File文件类：");
               
        //File newFile = new File("d:\\JavaFileTest.txt");
        //File newFile = new File("d:/JavaFileTest.txt");//linux风格的路径分隔符，目前也是支持的
        File newFile = new File("d:" + File.separator + "hello" + File.separator + "world" + File.separator + "JavaFileTest.txt"); //File类中的旧版本路径分隔符,推荐
        
        //递归创建不存在的父路径
        if (!newFile.getParentFile().exists())
        {
            newFile.getParentFile().mkdirs();
        }
        
        if(newFile.exists())
        {
            System.out.println(newFile.length());
            newFile.delete();
        }
        else
        {
            System.out.println(newFile.createNewFile());
            System.out.println(newFile.canRead());
            System.out.println(newFile.canWrite());
            System.out.println(newFile.canExecute());
            System.out.println(newFile.length());
        }  
        
        System.out.println("\n文件属性读取：");
        File picFile = new File("d:\\test.jpg");
        System.out.println("fileLength:" +picFile.length());
        System.out.println("lastModified:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(picFile.lastModified()));
        System.out.println("isFile:" +picFile.isFile());
        System.out.println("isDirectory:" +picFile.isDirectory());
        
        System.out.println("\n遍历目录");
        File dirFile = new File("d:" + File.separator);
        if(dirFile.isDirectory())
        {
            File result[] = dirFile.listFiles();
            for(int i = 0; i < result.length; i++)
            {
                System.out.println(result[i]);
            }
        }
        
        System.out.println("\n列出目录结构：[递归实现]");
        File baofengFile = new File("d:" + File.separator + "暴风影音" + File.separator);
        listDir(baofengFile);
        
        System.out.println("\n批量修改文件名称：——如果没有后缀，追加；如果有后缀，以最后一个点进行截取");
        File changeTypeFile = new File("d:" + File.separator + "test" + File.separator);
        listDir(changeTypeFile);
        
        long startTime = System.currentTimeMillis();
        renameDir(changeTypeFile);
        long stopTime = System.currentTimeMillis();
        System.out.println("操作耗时[ms]：" + (stopTime - startTime));
      
        listDir(changeTypeFile);
    }
}
