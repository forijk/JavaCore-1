public class ArrayUtil {

    public static void main(String [] args) {
        int[] array = new int []{1,2,3,4,5};
        ArrayTools arr =new  ArrayTools(array);
        System.out.println(arr.getSum());
        System.out.println(arr.getMin());
        System.out.println(arr.getMax());
        System.out.println(arr.getAvg());
        
    }
}

class ArrayTools {
    private int sum;
    private double avg;
    private int min;
    private int max;
    
    public ArrayTools(int[] temp){
        this.min = temp[0];
        this.max = temp[0];
        for (int a:temp) {
            this.sum +=a;
            if(this.min>a) this.min = a;
            if(this.max<a) this.max = a;
        }
        this.avg = this.sum / temp.length;
    }

    public int getSum(){
        return this.sum;
    }

    public double getAvg(){
        return this.avg;
    }

    public int getMin(){
        return this.min;
    }

    public int getMax(){
        return this.max;
    }

    public static void reverse(int[] arr){
        int center  = arr.length / 2;
        int head = 0;
        int tail = arr.length - 1;
        for (int i=0;i<center;i++){
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head ++;
            tail --;
        }
    }
}