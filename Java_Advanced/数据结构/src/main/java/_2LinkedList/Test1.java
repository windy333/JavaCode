package _2LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList同时实现了List接口和Deque接口，也就是说它既可以看作一个顺序容器，
 * 又可以看作一个队列(Queue)，同时又可以看作一个栈(Stack)。
 *
 * LinkedList底层通过双向链表实现，双向链表的每个节点用内部类Node表示。LinkedList
 * 通过first和last引用分别指向链表的第一个和最后一个元素。注意这里没有所谓的哑元，
 * 当链表为空的时候first和last都指向null。
 *
 */

public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //添加
        list.add("A");
        list.add("B");
        list.addFirst("0");
        list.addLast("final");
        list.add(3,"C");

        //toArray
        String[] strings = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
        //toString
        System.out.println(list);
        System.out.println();

        //查找
        System.out.println("first element of list: " + list.getFirst());
        System.out.println("last element of list: " + list.getLast());
        System.out.println("element of index 4 in the list："+list.get(4));
        //第一次出现的位置，最后一次出现的位置对应lastIndexOf
        System.out.println("index of C in the list: " + list.indexOf("C"));


        //修改
        System.out.println();
        list.set(0,"first");
        System.out.println(list);

        //删除
        System.out.println();
        list.removeFirst();
        list.removeLast();
        list.remove("A");
        list.remove(0);
        System.out.print(list);


        //addAll(需要进行一个转换)
        System.out.println("\n");
        String[] fruits={"Cherry","Orange","Pineapple"};
        list.addAll(0,Arrays.asList(fruits));
        list.add(null);
        for(String str:list){
            System.out.println(str);
        }

        //gc
        list.clear();

    }
}
