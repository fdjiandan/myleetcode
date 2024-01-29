import java.util.ArrayList;
import java.util.List;

public class SpiralOrderin150 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int x = matrix.length, y = matrix[0].length;
        int num = (Math.min(x, y)) / 2;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < y-1-i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i; j < x-1-i; j++) {
                res.add(matrix[j][y-1-i]);
            }
            for (int j = y-1-i; j > i; j--) {
                res.add(matrix[x-1-i][j]);
            }
            for (int j = x-1-i; j > i; j--) {
                res.add(matrix[j][i]);
            }
        }
        int min = Math.min(x, y);
        if(min % 2 != 0) {
            if(min == x) {
                for (int i = num; i < y-num; i++) {
                    res.add(matrix[num][i]);
                }
            } else {
                for (int i = num; i < x-num; i++) {
                    res.add(matrix[i][num]);
                }
            }
        }
        return res;
    }
}
