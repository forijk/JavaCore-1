package cn.mldn.message;

import java.util.UUID;

public class UUIDDemo
{
    public static void main(String[] args)
    {
        UUID uid = UUID.randomUUID();
        
        System.out.println(uid.toString());
    }
}
