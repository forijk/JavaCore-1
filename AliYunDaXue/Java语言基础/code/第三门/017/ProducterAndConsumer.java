/**
 * ProducterAndConsumer
 */
public class ProducterAndConsumer {

    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Producer implements Runnable {
    private Message msg;
    public Producer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i<100;i++) {
            if (i%2==0) {
                this.msg.set("王健","宇宙大帅哥");
                // this.msg.setTitle("王健");
                // try {
                //     Thread.sleep(1000);
                // } catch (InterruptedException e) {
                //     //TODO: handle exception
                //     e.printStackTrace();
                // }
                // this.msg.setContent("宇宙大帅哥");
            }else{
                this.msg.set("小高","猥琐第一人，常态保持");
                // this.msg.setTitle("小高");

                // try {
                //     Thread.sleep(1000);
                // } catch (InterruptedException e) {
                //     //TODO: handle exception
                //     e.printStackTrace();
                // }
                // this.msg.setContent("猥琐第一人，常态保持");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg;
    public Consumer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i<100;i++) {
                // try {
                //     Thread.sleep(1000);
                // } catch (InterruptedException e) {
                //     //TODO: handle exception
                //     e.printStackTrace();
                // }
            System.out.println(this.msg.get());

            // System.out.println(this.msg.getTitle() + "-" + this.msg.getContent());
        }
    }
}

class Message {
    private String title;
    private String content;
    private boolean flag=true;
     //true 允许生产，不允许消费
     //false 允许消费，不允许生产
    // 增加同步锁
    public synchronized void set(String title,String content){
        if (this.flag == true){
            this.content = content;
            this.title = title;
            this.flag =false;
            super.notify();
        }
        try {
            super.wait();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public synchronized String get() {
        if (flag == true){
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return this.title + " - " + this.content;
        } finally {
            flag = true;
            super.notify();
        }
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
}
}


