/**
 * BaDaoDemo
 */
public class BaDaoDemo {

    public static void main(String[] args) throws Exception {
        Thread mainThread = Thread.currentThread();
        Thread th = new Thread(() -> {
            for (int x=0;x<100;x++) {
                if (x==3) { //霸道来了
                    try {
                        mainThread.join(); // 霸道要先玩
                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "来了，x=" + x );
            }
        },"玩耍的线程");
        th.start();
        for (int i=0;i<100;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "霸道的家伙来了，i=" + i );
        }
    }
}