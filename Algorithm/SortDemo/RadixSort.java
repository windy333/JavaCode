import java.util.Arrays;

public class RadixSort {
    // 基数排序方法
    public static void radixSort(int[] arr) {
        // 找到数组中最大数，并找到最大数的位数
        int max = Arrays.stream(arr).max().getAsInt();
        int maxDigit = getDigit(max);

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; maxDigit / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // 根据每个位数进行计数排序
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 存储排序后的数组
        int[] count = new int[10]; // 计数数组，存储0-9的数据

        // 初始化计数数组
        Arrays.fill(count, 0);

        // 计算每个位数出现的次数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 更改count[i]，现在它包含了这个数在output[]中的正确位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 构建输出数组
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将排序后的数据复制到arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 获取一个整数的位数
    private static int getDigit(int number) {
        int digit = 0;
        while (number != 0) {
            digit++;
            number /= 10;
        }
        return digit;
    }

    public static void main(String[] args) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));
        radixSort(data);
        System.out.println("基数排序后的数组：" + Arrays.toString(data));
    }
}


/*
基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，
然后按每个位数分别比较。
 */