

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "b";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        int leng = s.length();
        int longest = 0;
        int temp = 0;
        String sub = "";
        for (int i = 0; i < leng; i++) {
            int find = sub.indexOf(s.charAt(i));
            if(find == -1) {
                sub += s.charAt(i);
                temp += 1;
            } else {
                longest = Integer.max(longest, temp);
                if(find != sub.length())
                    sub = sub.substring(find + 1) + s.charAt(i);
                else
                    sub = "";
                temp = sub.length();
            }
        }
        longest = Integer.max(longest, temp);
        return longest;
    }
}
