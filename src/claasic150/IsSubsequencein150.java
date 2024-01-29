import com.sun.deploy.util.StringUtils;

public class IsSubsequencein150 {

    public static void main(String[] args) {
        String s = "aaaaaa", t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i));
            if(index == -1)
                return false;
            t = t.substring(index+1);
        }
        return true;
    }
}
