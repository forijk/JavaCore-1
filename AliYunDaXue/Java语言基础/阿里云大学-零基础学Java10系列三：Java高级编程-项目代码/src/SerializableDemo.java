import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
class SerialPerson implements Serializable
{
    /**
     * 
     */
    //private static final long serialVersionUID = 1L;//不同虚拟机上避免反序列化问题，不重要，可以压制
    private transient String name;
    private int age;
    
    public SerialPerson(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }

    @Override
    public String toString()
    {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    
}

public class SerializableDemo
{
    private static final File SAVE_FILE = new File("d:" + File.separator + "test" + File.separator + "serializableDemo.txt");
    
    public static void saveObject(Object obj) throws Exception
    {
        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);//序列化
        oos.close();
    }  
    
    public static Object loadObject() throws Exception
    {
        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();//序列化
        ois.close(); 
        return obj;
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.88 对象序列化基本概念：");
        
        //saveObject(new SerialPerson("Leoo", 28));//序列化测试
        System.out.println(loadObject());//反序列化测试
    }
}
