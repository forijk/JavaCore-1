package cn.mldn.demo;

class MyThread extends Thread//�߳�������
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
			System.out.println(this.title + "���У�x = " + i);
		}
	}
}

public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		MyThread mt = new MyThread("�߳�A");
		mt.start();
		mt.start();
		
		/*
		new MyThread("�߳�A").start();
		new MyThread("�߳�B").start();
		new MyThread("�߳�C").start();
		*/
	}

}
