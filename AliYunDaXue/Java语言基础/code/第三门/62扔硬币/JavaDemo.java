import java.util.Random;

/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        Coin coin = new Coin();
        coin.throwsCoin(1000);
        System.out.println(coin.getFront());
        System.out.println(coin.getBack());
    }
}

/**
 * 获取随机数的方法
 * 正面数
 * 反面数
 */

class Coin {
    private int front;
    private int back;

    private Random random = new Random();

    public void throwsCoin(int num) {
        for (int i = 0;i < num;i++) {
            int coinNum = random.nextInt(2);
            if (coinNum == 0) {
                this.front ++;
            } else {
                this.back ++;
            }
        }
    }

    public int getFront () {
        return this.front;
    }

    public int getBack() {
        return this.back;
    }

}