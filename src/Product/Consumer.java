package Product;

import java.util.Queue;

public class Consumer implements Runnable{

    private Queue<Product> queue;
    private int MaxSize;

    public Consumer(Queue queue, int maxSize) {
        this.queue = queue;
        this.MaxSize = maxSize;
    }

    @Override
    public void run() {
        synchronized(queue) {
            while (queue.isEmpty()) {
                try {
                    System.out.println("没有库存了，无法消费了，等待生产。。。。。。");
                    queue.wait();
                    System.out.println("有库存了，可以消费了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("consume : " + queue.poll().getName());
            if (queue.size() == MaxSize - 1)
                queue.notifyAll();

        }
    }
}
