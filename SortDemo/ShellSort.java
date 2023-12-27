import java.util.Arrays;

public class ShellSort {
    //希尔排序
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));
        shellSort(data);
        System.out.println("希尔排序后的数组：" + Arrays.toString(data));
    }
}
