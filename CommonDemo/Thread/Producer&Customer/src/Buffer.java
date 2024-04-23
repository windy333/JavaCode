import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> queue;
    private int capacity;

    public Buffer(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // 缓冲区满，生产者等待
        }
        queue.add(value);
        notifyAll(); // 通知消费者有新物品可以消费
    }

    public synchronized int get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // 缓冲区空，消费者等待
        }
        int value = queue.remove();
        notifyAll(); // 通知生产者有空间可以生产
        return value;
    }
}

