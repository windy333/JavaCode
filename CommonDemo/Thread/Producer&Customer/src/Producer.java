public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

