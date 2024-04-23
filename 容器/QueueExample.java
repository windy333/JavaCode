import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // 创建一个LinkedList作为队列使用
        Queue<String> queue = new LinkedList<>();

        // 添加元素
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        // 访问队列头部元素但不移除
        System.out.println("Head of queue: " + queue.peek());

        // 移除队列头部元素
        while (!queue.isEmpty()) {
            System.out.println("Poll: " + queue.poll());
        }
    }
}
