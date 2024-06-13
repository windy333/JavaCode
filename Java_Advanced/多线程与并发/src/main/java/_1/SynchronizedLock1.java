package _1;

/*锁是一种用于控制并发访问的机制。它可以用来保护共享资源，确保在同一时间只有一个线程可以
访问该资源，从而避免并发访问导致的数据不一致或竞态条件的问题。*/

//对象锁：手动指定锁定对象，也可是是this,也可以是自定义的锁
public class SynchronizedLock1 implements Runnable {
    static SynchronizedLock1 instance = new SynchronizedLock1();
    // 创建2把锁
    Object block1 = new Object();
    Object block2 = new Object();

    public void run() {
        // 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
        synchronized (this.block1) {
            System.out.println("block1锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1锁," + Thread.currentThread().getName() + "结束");
        }
        synchronized (this.block2) {
            System.out.println("block2锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2锁," + Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
