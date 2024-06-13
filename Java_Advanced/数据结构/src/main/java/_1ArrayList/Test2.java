package _1ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test2 {
    public static void main(String[] args) {
        //初始分配容量，arraylist中不建议频繁add增加开销
        ArrayList<String> list1 = new ArrayList<>(3);
        for (int i = 0; i < 10; i++) {
            list1.add(String.valueOf(i));
        }
        //System.out.println(list1);  tostring的直接用法
        System.out.printf("Size: %d\n", list1.size());


        // 第一种：通过迭代器遍历
        System.out.print("通过迭代器遍历:");
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 第二种：通过索引值遍历
        System.out.print("通过索引值遍历:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        // 第三种：推荐增强for循环遍历
        System.out.print("增强for循环遍历:");
        for(String number : list1){
            System.out.print(number + " ");
        }
        System.out.println();

        // toArray用法
        String[] strings = list1.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
        System.out.println();


        //remove用法
        list1.remove(0);
        list1.remove("4");
        String[] strings2 = list1.toArray(new String[0]);
        System.out.println(Arrays.toString(strings2));


        System.out.println();
        System.out.println("ArrayList contains 6 is: " + list1.contains("6"));
        list1.clear();
        System.out.println("ArrayList is empty: " + list1.isEmpty());

    }
}
