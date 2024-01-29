public class IsPalindromein150 {

    public static void main(String[] args) {

        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s.length() <= 1)
            return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char sc = s.charAt(start);
            char ec = s.charAt(end);
            if(!Character.isLetterOrDigit(sc)) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(ec)) {
                end--;
                continue;
            }
            if(ec == sc || Character.toLowerCase(sc) == Character.toLowerCase(ec)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
