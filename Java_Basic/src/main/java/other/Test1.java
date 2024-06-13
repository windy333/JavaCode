package other;

//将数组中的第一位元素移动到末尾
public class Test1 {
    public void moveNum(int[] nums){
        int temp=nums[0];
        for(int i=0;i<nums.length-1;i++){
            nums[i]=nums[i+1];
        }
       nums[nums.length-1]=temp;
    }

    public  void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Test1 test1=new Test1();
        int[] nums = {7, 2, 4, 5, 0, 1};
        test1.printArray(nums);
        test1.moveNum(nums);
        test1.printArray(nums);
    }
}



