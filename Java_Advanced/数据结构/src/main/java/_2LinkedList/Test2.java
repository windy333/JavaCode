package _2LinkedList;

import java.util.LinkedList;

/**
 * LinkedList实现了Queue和Deque接口，提供了队列和双端队列的操作。
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 t= new Test2();
        t.showQueue();
        System.out.println("\n");
        t.showDequeue();
    }

    //队列是遵循先进先出（FIFO）原则的集合，一般是对头部进行操作
    public void showQueue(){
        LinkedList<String> queue = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            queue.offer(String.valueOf(i));
        }
        System.out.println(queue);

        System.out.println("Peek: " + queue.peek()); //返回队首元素但不删除
        System.out.println("Poll: " + queue.poll()); //返回并移除队首元素
        System.out.println("Element:" + queue.element());//返回队首元素，如果队列是空会报错

        queue.remove();//移除队首元素
        queue.remove(7);
        queue.remove("4");

        // 队列中剩余的元素(一种查询写法)
        while (!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }
    }


    public void showDequeue(){
        LinkedList<String> deque = new LinkedList<>();

        //添加
        deque.offerFirst("A"); // 在队列头部插入一个元素
        deque.offerLast("E");  // 在队列尾部插入一个元素
        deque.push("L");
        deque.push("I");
        System.out.println(deque);


        //查询or修改
        // 查看双端队列两端的元素但不移除
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        //删除
        // 移除并返回双端队列两端的元素
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());
        deque.pop(); //删除队首元素
        deque.removeFirstOccurrence("A"); //删除指定元素第一次出现的位置，返回类型是boolean，对应last
        System.out.println(deque);


        // 移除队列中的剩余元素
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }

    }
}





