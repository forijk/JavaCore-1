package cn.mldn.demo;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 5.140 HashMap子类：");
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("one", 11);//key重复，覆盖旧key
        map.put("two", 2);
        map.put("three", 3);
        map.put(null, 0);
        map.put("zero", null);
        
        System.out.println(map.put("four", 4));//key不重复返回空
        System.out.println(map.put("four", 44));//key重复，返回旧value
        
        System.out.println(map);
        System.out.println(map.get("one"));
        System.out.println(map.get("ten"));//不存在的key查询
        System.out.println(map.get(null));//存在的key查询
    }
}
