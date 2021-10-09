public class LeetCode345 {

    public static void main(String[] args) {

        String s = "leetcodeA";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        if(s.isEmpty())
            return s;
        int length = s.length();
        int search = length - 1;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (vowels.lastIndexOf(s.charAt(i)) >= 0) {
                while (search >= 0 && vowels.lastIndexOf(s.charAt(search)) < 0) {
                    search--;
                }
                res.append(s.charAt(search));
                search--;
            }
            else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
