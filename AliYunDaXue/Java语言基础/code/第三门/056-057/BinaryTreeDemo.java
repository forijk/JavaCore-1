
import java.util.Arrays;
/**
 * BinaryTreeDemo
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree<Person> bt = new BinaryTree<Person>();

        bt.add(new Person("小强-1", 80));
        bt.add(new Person("小强-2", 90));
        bt.add(new Person("小强-3", 70));
        bt.add(new Person("小强-4", 100));
        bt.add(new Person("小强-5", 50));

        System.out.println(Arrays.toString(bt.toArray()));
    }
}


class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "【Person对象】：name=" + name + ",age=" + age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;  // 升序
        // return person.age - this.age;  // 降序
    }
}



class BinaryTree<T extends Comparable<T>> {

    private class Node {  //存放的是什么呢？
        private Comparable<T> data;  // 存放Comparable，可以比较大小，强制性向下转型，比较数据
        private Node parent; // 父节点
        private Node left; 
        private Node right;

        public Node(Comparable<T> data) {  //构造方法直接负责进行数据的存储
            this.data = data;
        }

        /**
         * 保存节点到适当的位置
         * @param newNode
         */
        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T)this.data) <=0 ) {  // 比当前节点数据小
                if (this.left == null) {  // 没有左子树
                    this.left = newNode;  // 报存父节点
                    newNode.parent = this;
                } else {  // 需要向做继续判断
                    this.left.addNode(newNode); // 继续向下判断
                }
            } else {  // 比根节点的数据大
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }

            }
        }

        /**
         * 实现所有数据的额获取处理，按照中序遍历的形式来完成
         */
        public void toArrayNode(){
             if (this.left != null) {
                 this.left.toArrayNode();
             }
             BinaryTree.this.retuenData[BinaryTree.this.foot ++ ] = this.data;

             if (this.right != null) {
                this.right.toArrayNode();
             }
        }

        /**
         * 获取要删除的节点对象
         * @param data 节点对象
         * @return 要删除的节点对象，对象一定存在
         */
        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T)this.data) == 0) {
                return this; // 找到了
            } else if (data.compareTo((T)this.data) < 0) {  // 左边有数据
                if (this.left != null) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                }else {
                    return null;
                }
            }
        }
    }

    private Node root; //根节点
    // 数据保存完之后，另外一个目的即使输出数据
    private int count;  // 保存数据的个数
    private Object[] retuenData; // 返回数据，展示有哪些数据
    private int foot = 0 ; // 角标，返回数据的时候要使用
    /**
     * 进行数据的保存
     * @param data
     * @exception NullPinterException 保存数据为空时的异常
     */
    public void add(Comparable<T> data) {
        if (data==null) {
            throw new NullPointerException("保存的数据不允许为空");
        }
        // 首先，所有的数据本省不具有节点关系的匹配，那么一定更要将其包装在Node类中
        Node newNode = new Node(data); // 保存节点

        if (this.root == null) {
            this.root = newNode;
        } else { // 要为其保存到一个合适的节点
            this.root.addNode(newNode); // 交给Node类负责处理
        }

        this.count ++;
    }

    //进行数据的返回
    /**
     * 以对象数组的形式返回全部数据，如果没有数据返回null
     * @return
     */
    public Object[] toArray() {
        if (this.count == 0) { // 如果数据总数为0，表示没有数据，返回null
            return null;
        }
        
        this.retuenData = new Object[this.count];  // 保存长度为数组长度
         this.foot = 0;  // 角标清零     
        // 直接通过Node类负责,从根节点开始
        this.root.toArrayNode();
        return retuenData;
    }

    public void remove(Comparable<T> data)  {
        if (this.root == null) {
            return;
        } else {
            if (this.root.data.compareTo((T)data) == 0) {
                // 要删除的是根节点
                // 和第4种情况是一样的，左右都有节点
                Node moveNode = this.root.left; //
                while (moveNode.left != null) {
                    moveNode = moveNode.left; // 一直向左找，就可以确定删除节点的右边的最小节点
                }
                moveNode.parent = null;
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                this.root = moveNode;

                removeNode.parent.left = moveNode;
                moveNode.parent.left = null; // 断开原本的连接
                moveNode.parent = removeNode.parent; // 改变父节点
                moveNode.right = removeNode.right; // 改变原始节点的右节点指向
                moveNode.left = removeNode.left;
            } else {
                // 找到要删除的节点
                Node removeNode = this.root.getRemoveNode(data); // 找到要删除的节点
                if (removeNode != null) {
                    // 情况1
                    if (removeNode.left == null || remove.right == null) {
                        removeNode.parent.left = null;
                        removeNode.parent.right = null;
                        removeNode.parent = null; // 父节点直接断掉
                    } else if (removeNode.right == null || removeNode.left != null) { // 左边不为空
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    } else if (removeNode.right != null || removeNode.left == null) { // 右边不为空
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    } else { // 两边都有节点 ，找到右边节点中最左边的节点，改变其指向
                        Node moveNode = removeNode.left; //
                        while (moveNode.left != null) {
                            moveNode = moveNode.left; // 一直向左找，就可以确定删除节点的右边的最小节点
                        }
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null; // 断开原本的连接
                        moveNode.parent = removeNode.parent; // 改变父节点
                        moveNode.right = removeNode.right; // 改变原始节点的右节点指向
                        moveNode.left = removeNode.left;
                    }
                }
            }
        }
        this.count--;
    }
}
