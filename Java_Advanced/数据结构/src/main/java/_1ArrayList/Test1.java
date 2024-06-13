package _1ArrayList; /**
 * ArrayList实现了List接口，是顺序容器，即元素存放的数据与放进去的顺序相同，
 * 允许放入null元素，底层通过数组实现。
 */

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        System.out.printf("Before add size of list: %d\n",list1.size());

        list1.add("1");
        list1.add("3");
        System.out.printf("After add(1) size of list: %d\n",list1.size());


       /* 在指定索引位置添加元素，需要先对其后的元素进行移动，然后再插入元素，
            最后size+1(如果容量不足还涉及到扩容，每次右移1位，即扩大约1.5倍)
            该方法有着线性的时间复杂度*/
        list1.add(2,"2");
        System.out.printf("After add(2) size of list: %d\n",list1.size());


        ArrayList<String> list2 = new ArrayList<>(list1);
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.addAll(list1);
        System.out.printf("After copy size of list: %d\n",list2.size());
        //允许添加空值
        list2.add(null);
        System.out.printf("After add(3) size of list: %d\n",list2.size());

    }

}
