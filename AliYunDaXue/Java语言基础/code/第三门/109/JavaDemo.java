import java.util.HashMap;
import java.util.Iteratorl;
import java.util.Map;

public class BeanUtil {
    private BeanUtil () {};   // 构造方法私有化又什么作用
    public static void setValue (Object obj,Map<String, String> map) {
        Iteratorl<Map.Entry<String,String>> iter = map.entrySet().iterator(); //获取iterator接口的实例
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String fieldKey = null;
            Object currentObject = obj;  // 设置一个当前的操作对象(后面会不断修改其引用)
            try {
                if(entry.getKey().contains(".")) {
                    // 包含点是一种处理，可能会出现级联关系
                        // 依据“.”进行拆分处理，而后一次判断，如果发现getter方法调用返回的是我们的空，则利用setter实例化
                    //不包含是另一种处理
                    String fieldSplit [] = entry.getKey().split(regex:"\\.");
                    // Object currentObject = obj ; // 设置一个当前的操作对象(后面会不断修改其引用)
                    for (int x=0;x < fieldSplit.length-1;x++) { 
                        // 循环每一个属性，但是最后一个是不看的dept.company.name
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtil.initcap(fieldSplit[i]));
                        Object tempReturn = getMethod.invoke(currentObject);
                        if (tempReturn == null) { // 当前对象未实例化，应该调用settr 设置内容
                            class<?> currentType =  currentObject.getClass().getDeclaredFied(fieldSplit[x]).getType(); 
                            Method setMethod =  currentObject.getClass().getDeclaredMethod("set" + StringUtil.initcap(fieldSplit[i]), currentType);
                            tempReturn = currentType.getDeclaredConstructor().newInstance();
                            setMethod.invoke(currentObject,tempReturn);
                        }
                        currentObject = tempReturn;
                    }
                    // 对象属性设置的难点在于要如何获取要操作的对象
                    fieldKey = entry.getKey().subString(entry.getKey().lastIndexOf(".")+1); // 属性
                } else {
                    fieldKey = entry.getKey(); // 直接获取属性的名称
                }
                Field field = currentObject.getClass().getDeclaredFied(fieldKey);
                Method method = currentObject.getDeclaredMethod("set" + StringUtil.initcap(fieldKey),field.getType());
                method.invoke(currentObject,entry.getVlue());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    } 
}

/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        
    }
}

class Emp {
    private String ename;
    private String job;


}

class InputData {
    public static Map<String,String> input () {
        Map<String,String> map = new HashMap<>();
        map.put("ename","张山")
        map.put("job","消防员")
    }
}
