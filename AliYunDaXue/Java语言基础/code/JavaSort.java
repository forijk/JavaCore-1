
public class JavaSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 9, 5, 4, 3, 6, 7, 2, 1, 10, 7, 0 };
        ArrayUtils.sort(arr);
        ArrayUtils.printArray(arr);
    }

}

class ArrayUtils{
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        } 
    }

    public static void printArray(int[] temp){
        for (int x=0;x<temp.length;x++){
            System.out.print(temp[x] + ",");
        }
    }
}