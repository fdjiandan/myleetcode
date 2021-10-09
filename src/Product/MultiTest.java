package Product;

import java.util.LinkedList;
import java.util.Queue;

public class MultiTest {

    public static void main(String[] args) {
        Queue<Product> queue = new LinkedList<Product>();
        for (int i = 0; i < 100; i++) {
            new Thread(new Consumer(queue, 100)).start();
            new Thread(new Producer(queue, 100)).start();
        }
    }
}
