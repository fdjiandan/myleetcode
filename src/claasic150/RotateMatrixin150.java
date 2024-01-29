import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class RotateMatrixin150 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1 - 2 * i; j++) {
                int temp = matrix[i][n-1-i-j];
                matrix[i][n-1-i-j] = matrix[i+j][i];
                matrix[i+j][i] = matrix[n-1-i][i+j];
                matrix[n-1-i][i+j] = matrix[n-1-i-j][n-1-i];
                matrix[n-1-i-j][n-1-i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
