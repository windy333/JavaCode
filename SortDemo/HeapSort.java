import java.util.Arrays;

public class HeapSort {
    //堆排序
    public void sort(int arr[]) {
        int n = arr.length;

        // 构建堆(重新排列数组)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 一个接一个地从堆中提取元素
        for (int i = n - 1; i > 0; i--) {
            // 将当前根移动到末尾
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 在缩减堆上调用Max heapify
            heapify(arr, i, 0);
        }
    }

    // 对以节点i为根的子树进行堆积，节点i是arr[]中的索引。N是堆的大小
    void heapify(int arr[], int n, int i) {
        int largest = i; // 将最大的值初始化为根
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // 左节点比根大
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // 右子节点比目前为止的最大节点大
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // 最大节点不是根
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归地堆积受影响的子树
            heapify(arr, n, largest);
        }
    }


    public static void main(String args[]) {
        int data[] = {12, 11, 13, 5, 6, 7};
        int n = data.length;
        System.out.println("原始数组：" + Arrays.toString(data));

        HeapSort ob = new HeapSort();
        ob.sort(data);

        System.out.println("堆排序后的数组：" + Arrays.toString(data));
    }
}

/*
堆排序是一种基于比较的排序算法，它使用二叉堆的概念。在这个过程中，首先将待排序的数组
构造成一个最大堆，然后将堆顶元素（即当前最大值）与堆的最后一个元素交换，之后缩小堆的
范围（排除掉已经排好的最大元素）并重新调整剩余元素，使其满足最大堆的性质。这个过程重
复进行，直到整个数组变成有序序列。
 */
