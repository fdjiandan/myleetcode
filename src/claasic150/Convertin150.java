public class Convertin150 {
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(s.length() == 1)
            return s;
        int col = s.length();
        char[][] cons = new char[numRows][col];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                cons[i][j] = ' ';
            }
        }
        int count = 0;
        int cur = 0;
        //int add = 2 * numRows - 2;
        while (count < s.length()) {
            for (int i = 0; i < numRows && count < s.length(); i++) {
                cons[i][cur] = s.charAt(count++);
            }
            int l = numRows - 2;
            cur += 1;
            for (int i = 1; i < numRows - 1 && count < s.length(); i++) {
                cons[l--][cur++] = s.charAt(count++);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if(cons[i][j] != ' ') {
                    res.append(cons[i][j]);
                }
            }
        }
        return res.toString();
    }
}
