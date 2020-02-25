package cn.mldn.demo;

class MyThread extends Thread//线程主体类
{
	private String title;

	public MyThread(String title)
	{
		this.title = title;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println(this.title + "运行：x = " + i);
		}
	}
}

public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		MyThread mt = new MyThread("线程A");
		mt.start();
		mt.start();
		
		/*
		new MyThread("线程A").start();
		new MyThread("线程B").start();
		new MyThread("线程C").start();
		*/
	}

}
