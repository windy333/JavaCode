package other;

//找出连续最长的1
public class Test3 {
    public int findNum(int[] nums){
        int max=0;
        int current=0;
        for(int x : nums){
            current= x==0?0:current+1;
            max=Math.max(max,current);//存储最大次数出现的连续1的数量
        }

        return max;
    }
}
