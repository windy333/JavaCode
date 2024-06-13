public class halfSearch {
    //折半查找
    public static int halfSearch(int[] arr,int key){
        int min,max,mid;
        min=0;
        max=arr.length-1;
        mid=(min+max)/2;
        while(arr[mid]!=key){
            if(arr[mid]>key)
                min=mid+1;
            else if(arr[mid]<key)
                max=mid-1;
            if(max<min)
                return -1;
        }

        return mid;
    }
}
