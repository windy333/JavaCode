package _1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在main方法中，创建了一个包含1000个线程的线程池，并使用CountDownLatch来等待所有线程执行完成。
 * 每个线程都是通过executorService.execute()方法来执行demo.add()，并在完成后调用countDownLatch.countDown()
 * 来通知主线程该线程已完成。由于count变量没有进行任何线程安全的操作，即使每个线程只是简单地增加
 * count值一次，但由于并发执行，最终计数值可能会不准确。因此，这段代码展示了多线程环境下的线程不
 * 安全问题。
 */

public class ThreadUnsafeDemo {
    private int count = 0;

    public void add() {
        count++;
    }

    public int get() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeDemo demo = new ThreadUnsafeDemo();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                demo.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(demo.get());

    }
}
