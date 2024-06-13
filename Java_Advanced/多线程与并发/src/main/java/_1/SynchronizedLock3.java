package _1;

//类锁：指synchronize修饰静态的方法或指定锁对象为Class对象

public class SynchronizedLock3 implements Runnable {
    static SynchronizedLock3 instance1 = new SynchronizedLock3();
    static SynchronizedLock3 instance2 = new SynchronizedLock3();

    @Override
    public void run() {
        // 所有线程需要的锁都是同一把
        synchronized (SynchronizedLock3.class) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}

