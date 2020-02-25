import java.util.Arrays;

class Person implements Comparable<Person>
{
    private String name;
    private int age;
    public Person(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }
    
    //无参构造、setter getter省略
    
    @Override
    public String toString()
    {
        return "Person [name=" + name + ", age=" + age + "]\n";
    }
    
    @Override
    public int compareTo(Person per)
    {
        return this.age - per.age;
    }
}

public class CompareFirstDemo
{
    public static void main(String[] args)
    {
        System.out.println("5.52.比较器问题引入：");
        System.out.println("\n只要是对象数组，均可排序：");
        String strArray[] = new String[] {"X", "A", "S", "P"};
        Arrays.sort(strArray);
        System.out.println("\n字符串排序结果： " + Arrays.toString(strArray));
        
        Integer intArray[] = new Integer[] {5, 2, 9, 1};
        Arrays.sort(intArray);
        System.out.println("\n整形排序结果： " + Arrays.toString(intArray));
        
        System.out.println("\n自定义排序： " );
        Person perArray[] = new Person[]
                {
                        new Person("Person-A", 80),
                        new Person("Person-B", 50),
                        new Person("Person-C", 100),
                };
        
        Arrays.sort(perArray);
        System.out.println("\n整形排序结果：\n " + Arrays.toString(perArray));

    }
}
