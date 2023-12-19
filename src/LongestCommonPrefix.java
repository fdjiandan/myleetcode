public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","flight"};
        System.out.printf(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        StringBuilder max = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int len = Math.min(s.length(), max.length());
            int pos = 0;
            while (pos < len && s.charAt(pos) == max.charAt(pos)) {
                pos++;
            }
            max.delete(pos, max.length());
            if(pos == 0) {
                break;
            }
        }
        return max.toString();
    }
}
