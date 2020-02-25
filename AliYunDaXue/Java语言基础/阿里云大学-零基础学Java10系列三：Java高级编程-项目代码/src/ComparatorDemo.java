import java.util.Arrays;
import java.util.Comparator;

class NoComparablePerson
{
    private String name;
    private int age;
    public NoComparablePerson(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }
    
    //无参构造、setter getter省略
    
    @Override
    public String toString()
    {
        return "NoComparablePerson [name=" + name + ", age=" + age + "]\n";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

class PersonComparator implements Comparator<NoComparablePerson>
{
    //定义排序规则
    @Override
    public int compare(NoComparablePerson o1, NoComparablePerson o2)
    {
        // TODO Auto-generated method stub
        return o1.getAge() - o2.getAge();
    }
}

public class ComparatorDemo
{
    public static void main(String[] args)
    {

        System.out.println("\n\nComparator比较器：在不修改原有 不含比较器的类的情况下，增加类比较功能： " );
        NoComparablePerson noComparablePersonArray[] = new NoComparablePerson[]
                {
                        new NoComparablePerson("Person-A", 80),
                        new NoComparablePerson("Person-B", 50),
                        new NoComparablePerson("Person-C", 100),
                };
        //注释放开：
        Arrays.sort(noComparablePersonArray, new PersonComparator());
        System.out.println("\n整形排序结果：\n " + Arrays.toString(noComparablePersonArray));
        
        
        
    }
}
