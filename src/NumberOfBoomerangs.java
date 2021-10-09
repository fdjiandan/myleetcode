import java.util.Arrays;

public class NumberOfBoomerangs {

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{-1,-1},{1,1},{2,0},{0,2},{-2,0},{0,-2}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        if(points.length < 3)
            return 0;
        int boomer = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            int[] start = points[i];
            int[] dis = new int[len];
            for (int j = 0; j < len; j++) {
                int x = start[0] - points[j][0];
                int y = start[1] - points[j][1];
                int d = x * x + y * y;
                dis[j] = d;
            }
            Arrays.sort(dis);
            int base = dis[0];
            int count = 1;
            for (int j = 1; j < len; j++) {
                if(dis[j] != base) {
                    boomer += (count - 1) * count;
                    base = dis[j];
                    count = 1;
                }
                else {
                    count++;
                }
            }
            boomer += (count - 1) * count;
        }
        return boomer;
    }
}
