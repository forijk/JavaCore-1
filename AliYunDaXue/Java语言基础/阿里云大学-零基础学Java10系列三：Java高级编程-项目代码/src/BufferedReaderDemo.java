import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo
{
    public static void main(String[] args) throws IOException 
    {
        System.out.println("Lesson 6.86 BufferedReader������������ʵ�ּ�����������");
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("��������Ϣ��");
        String msg = input.readLine();
        System.out.println(msg);
                
        System.out.println("���������䣺");
        //String�����������ݣ����Խ��з���ĺ�������
        msg = input.readLine();
        if(msg.matches("\\d{1,3}"))
        {
            int age = Integer.parseInt(msg);
            System.out.println("���������Ϊ��" + age);
        }
        else
        {
            System.out.println("��������ȷ�����䣡");
        }
    }
}
