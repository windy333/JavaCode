import java.util.Arrays;

public class QuickSort {
    //快速排序法
    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap.swap(arr, i, index);
                index++;
            }
        }
        swap.swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));

        quickSort(data,0, data.length-1);
        System.out.println("快速排序后的数组：" + Arrays.toString(data));
    }

}
