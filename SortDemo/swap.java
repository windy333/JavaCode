public class swap {
    /*
    swap 方法是静态的 (static)，不需要创建 swap 类的实例就可以直接调用它。
    在调用类中，使用 swap 类的名称和方法名称来调用它，传递正确的参数。
    */
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
