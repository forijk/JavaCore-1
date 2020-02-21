
/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        IFood food = new Bread();
        food.eat(); //吃
    }
}

interface IFood {  //定义一个食物标准
    public void eat(); //吃
}

class Bread implements IFood {
    public void eat() {
        System.out.println("吃面包");
    }
}

