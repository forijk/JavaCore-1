package cn.mldn.demo;

class MyThread extends Thread { //线程主题类
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() { // 线程的主体方法
        // TODO Auto-generated method stub 
        super.run();
        for (int x=0;x<10;x++) {
            System.out.println(this.title + "运行,X = " + x);
            Thread.currentThread()
        }
    }
}
public class ThreadDemo {

    public static void main(String[] args) {
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}