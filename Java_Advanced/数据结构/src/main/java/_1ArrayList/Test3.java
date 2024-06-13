package _1ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * 为追求效率，ArrayList没有实现同步(synchronized)，如果需要多个线程并发访问，
 * 用户可以手动同步，也可使用Vector替代。
 */
public class Test3 {
    public static void main(String[] args) {

        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        synchronizedList.add("Apple");
        synchronizedList.add("Banana");
        synchronizedList.add("Orange");
        synchronized (synchronizedList) {
            // 在同步块内对列表进行操作
            for (String fruit : synchronizedList) {
                System.out.println(fruit);
            }
        }

        //vector例子
        System.out.println();
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        for(String fruit : vector){
            System.out.println(fruit);
        }

    }
}
