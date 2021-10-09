import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int[] res = smallK2(arr, 0);
        System.out.println(Arrays.toString(res));
    }

    public static int[] smallK2(int[] arr, int k) {
        if(k <= 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int j : arr) {
            queue.add(j);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if(!queue.isEmpty())
                res[i] = queue.poll();
        }
        return res;
    }

    public static int[] smallK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
