import java.util.HashSet;
import java.util.Set;

public class SetZeroesin150 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length;
        Set<Integer> line = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j] == 0) {
                    line.add(j);
                    row.add(i);
                }
            }
        }
        for (Integer i : line
             ) {
            for (int j = 0; j < x; j++) {
                matrix[j][i] = 0;
            }
        }
        for (Integer i : row
             ) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
