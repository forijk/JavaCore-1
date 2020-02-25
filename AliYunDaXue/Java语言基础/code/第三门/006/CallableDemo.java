import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * CallableDemo
 */
public class CallableDemo {

    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<>(new MyThread());
        new Thread(task).start();
        System.out.println("线程返回数据" + task.get());
    }
}

class MyThread implements Callable<String>{
    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        for (int x=0;x<10;x++){
            System.out.println("*****线程执行、x="+x);

        }
        return "线程执行完毕";
    }
}