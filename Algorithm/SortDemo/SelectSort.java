import java.util.Arrays;

public class SelectSort {
    //选择排序的第一种写法
    public static void selectSort1(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j])
                    swap.swap(arr,i,j);
            }
        }
    }

    // 选择排序的第二种写法
    public static void selectSort2(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i; // 记录最小元素的索引
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j; // 更新最小元素的索引
                }
            }
            if(i != minIndex){ // 如果最小元素的索引不是i，交换元素
                swap.swap(arr, i, minIndex);
            }
        }
    }

    public static void main(String args[]){
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));
        selectSort1(data);
        System.out.println("选择排序1后的数组：" + Arrays.toString(data));
        selectSort2(data);
        System.out.println("选择排序2后的数组：" + Arrays.toString(data));

    }
}
