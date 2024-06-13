public class getIndex {
    //查找数组中指定值的索引
    public static int getIndex(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(key==arr[i])
                return i;
        }
        return -1;
    }
}
