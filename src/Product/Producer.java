package Product;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{

    private Queue<Product> queue;
    private int MaxSize;

    public Producer(Queue queue, int maxSize) {
        this.queue = queue;
        this.MaxSize = maxSize;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (queue.size() == MaxSize) {
                try {
                    System.out.println("仓库已经满了，生产暂停了。。。");
                    queue.wait();
                    System.out.println("仓库有空余了，可以开工了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int i = new Random().nextInt();
            queue.add(new Product("product " + i));
            System.out.println("produce : product " + i );
            if (queue.size() == 1)
                queue.notifyAll();
        }
    }
}
