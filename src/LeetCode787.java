import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode787 {

    public static void main(String[] args) {
       int[][] edges = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
       int k = 1;
       int n = 3;
       int min = -1;
       int price = 0;
       int value = findCheapestPrice(n, edges, 0, 2, k, min, price);
        System.out.println(value);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k, int min, int price) {
        if(k < 0) {
            return min;
        }
        for (int i = 0; i < n; i++) {
            int[] flight = flights[i];
            if(flight[1] == dst) {
                if(flight[0] == src) {
                    int t = price + flight[2];
                    if(min == -1)
                        min = t;
                    else if(min > t) {
                        min = t;
                    }
                }
                else {
                    int base = flight[2] + price;
                    if(min == -1 || min > base) {
                        int find = findCheapestPrice(n, flights, src, flight[0], k-1, min, base);
                        if(find != -1 && find < min)
                            min = find;
                    }
                }
            }
        }
        return min;
    }

}
