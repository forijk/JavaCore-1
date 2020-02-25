
class IPValidator
{
    private IPValidator() {};
    
    public static boolean validateIP(String ip)
    {
        if((null == ip) ||("".equals(ip)))
        {
            return false;
        }
        
        String regex = "([12]?[0-9]?[0-9]\\.){3}[12]?[0-9]?[0-9]";
        
        //ip地址正则判断正确后，拆分判断点分十进制值范围
        if (ip.matches(regex))
        {
            String result[] = ip.split("\\.");
            for(int x = 0; x < result.length; x++)
            {
                int temp = Integer.parseInt(result[x]);
                if(temp > 255)
                {
                    return false;
                }
            }
            return true;
        }
        return false;     
    }
    
}

public class IPVarifyCase
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 63 : IP[第一位内容只能是无、1、2，后面内容可以是0-9,， 第三位0-9]]验证：");
        
        String IPStr = "192.168.2.3";
        System.out.println(IPValidator.validateIP(IPStr));
    }
}
