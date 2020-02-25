
public class StringBufferCase
{
    public static void main(String[] args)
    {
        System.out.println("StringBufferÊ¹ÓÃ°¸Àý£º");
        
        StringBuffer buf = new StringBuffer();
        for(int x = 'a'; x <= 'z'; x++)
        {
            buf.append((char)(x));
        }
        buf.reverse().delete(0, 5);
        System.out.println(buf);
    }
}
