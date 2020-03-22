import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;


/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("请输入正确的命令格式: java JavaDemo 源文件路径 目标文件路径")
            System.exit(1);
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(args[0], args[1]);   // 传进去的是字符串，可以添加构造方法
        if (new File(args[0]).isFile()){
            System.out.println(fu.copy()? "文件拷贝成功" : "失败");
        }else {
            System.out.println(fu.copyDir()? "文件拷贝成功" : "失败");
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝完成时间" + (end-start));
    }
}

class FileUtil {
    private File srcFile; //源文件路径
    private File desFile; //目标文件路径

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtil(String src,String des) {  // 接收字符串的构造方法
        this(new File(src), new File（des);
    }

    public boolean copy() throws Exception{
        if (!this.srcFile.exists()) {
            System.out.println("源文件不存在")
            return false
        }
        if (!this.desFile.getParentFile().exists()){
            this.desFile.getParentFile().mkdirs();  // 如果目标文件的父级文件不存在，就创建它
        }

        byte[] data = new byte[1024]; // 开辟一个拷贝的缓冲区
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(this.srcFile);
            output = new FileOutputStream(this.desFile);

            int len = 0;
            // do {
            //     len = input.read(data); // 拷贝的内容都在data数组里面
                
            //     // 这里有一个小BUG，要做如下处理
            //     if (len != -1){
            //         output.write(data,0,len);
            //     }

            // }while (len != -1);
            // do... while 很少使用，改变一下
            // 要做的事情有两个
            // 1. 读取数据到数组之中，随后但会读取的个数
            // 2. 判断个数是否是 -1 如果不是则进行写入
            while ((len = input.read(data)) != -1) {
                    output.write(data,0,len);
            }
            // input.transferTo(output); // 注意使用的版本 ，效率更高


            return true
        }catch(Exception e){
            throw e;
        }finally {
            if (input!=null){
                input.close();
            }
            if (output!=null){
                output.close();
            }
        }
    }
    /**
     * 关键在于有一个递归的处理问题，单独放在外面
     */
    public boolean copyDir() throws Exception{
        try {
            this.copyDir(this.srcFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 文件夹Copy的内部实现
     */
    public void copyImp(File file) throws Exception{
        if(file.isDirectory()){
            File results [] = file.listFiles(); // 列出全部目录组成
            if (result != null) {
                for (int i = 0; i < results.length;i++) {
                    copyImp(results[x]);
                }
            }
        } else { // 是文件
            // System.out.Println(file.getPath());
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "");
            File newFile = new File(this.desFile, newFilePath); // 拷贝的目标路径
            this.copyFileImp(file, newFile);
        }

    }


    /**
     * 文件copy的内部实现
     */
    public  boolean copyFileImp(File srcFile,File desFile) throws Exception{

        if (!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();  // 如果目标文件的父级文件不存在，就创建它
        }
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            input.transferTo(output); // 注意使用的版本 ，效率更高
            return true;
        }catch(Exception e){
            throw e;
        }finally {
            if (input!=null){
                input.close();
            }
            if (output!=null){
                output.close();
            }
        }
    }
}