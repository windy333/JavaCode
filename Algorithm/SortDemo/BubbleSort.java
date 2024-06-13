import java.util.Arrays;

public class BubbleSort {
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap.swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void main(String args[]) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));
        bubbleSort(data);
        System.out.println("冒泡排序后的数组：" + Arrays.toString(data));
    }
}
