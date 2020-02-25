/**
 * SleepDemo
 */
public class SleepDemo {

    public static void main(String[] args) throws Exception {


        for (int num=0;num <5;num++){
            new Thread(()->{
                for (int x =0;x<10;x++) {
                    System.out.println(Thread.currentThread().getName() + "、"+ x);
                    try {  // 强制处理
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                }
            },"线程对象" + num).start();
        }
    }
}

