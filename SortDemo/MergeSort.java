import java.util.Arrays;

public class MergeSort {

    // 归并排序函数
    public void sort(int arr[], int left, int right) {
        if (left < right) {
            // 找到中间点，将数组分成两部分
            int middle = (left + right) / 2;

            // 对左半部分进行归并排序
            sort(arr, left, middle);
            // 对右半部分进行归并排序
            sort(arr, middle + 1, right);

            // 合并两个排序好的部分
            merge(arr, left, middle, right);
        }
    }

    // 合并两个子数组的函数
    // 第一个子数组是 arr[left...middle]
    // 第二个子数组是 arr[middle+1...right]
    void merge(int arr[], int left, int middle, int right) {
        // 找出两个子数组的大小
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 创建临时数组
        int L[] = new int[n1];
        int R[] = new int[n2];

        // 复制数据到临时数组中
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        // 合并临时数组

        // 初始化三个指针
        int i = 0, j = 0;

        // 初始合并数组的索引
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制剩余的L[]的元素，如果有的话
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // 复制剩余的R[]的元素，如果有的话
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(arr));

        //这里没有写静态方法
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("归并排序后的数组：" + Arrays.toString(arr));
    }
}

/*
归并排序是一种分治算法，它将数组分成两半，对每一半递归地应用归并排序，
然后将两个排序好的半部分合并成一个最终的排序数组。
 */