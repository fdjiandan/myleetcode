import java.util.Arrays;

public class IsValidSudoku {

    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9];
        int[][] lie = new int[9][9];
        int[][] squqre = new int[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(line[i], 0);
            Arrays.fill(lie[i], 0);
            Arrays.fill(squqre[i], 0);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(lie[c-'0'][j] == 1 || line[i][c-'0'] == 1)
                        return false;
                    lie[c-'0'][j] = 1;
                    line[i][c-'0'] = 1;
                    int n = i / 3 * 3 + j / 3;
                    if(squqre[n][c - '0'] == 1)
                        return false;
                    squqre[n][c-'0'] = 1;
                }
            }
        }
        return true;
    }
}
