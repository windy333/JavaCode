import java.util.Arrays;

public class InsertSort {
    //插入排序(直接插入)
    public static void insertSort(int[] arr,int length){
        for(int i=1;i<length;i++){
            int key=arr[i];
            int j=i-1;
            while((j>=0) && (key<arr[j])){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String args[]) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));
        //可改变n来改变排序结果
        insertSort(data,8);
        System.out.println("插入排序后的数组：" + Arrays.toString(data));
    }

}
