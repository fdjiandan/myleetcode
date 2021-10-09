import java.util.*;

public class FindMaximizedCapital {

    public static void main(String[] args) {
        int[] profits = new int[]{5,4,1};
        int[] capital = new int[]{0,0,0};
        int k = 3;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if(!pq.isEmpty())
                w += pq.poll();
            else
                break;
        }
        return w;
    }
}
