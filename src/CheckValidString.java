import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

public class CheckValidString {
    public static void main(String[] args) {
        String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        if(s.isEmpty())
            return true;
        int leftmax = 0;
        int leftmin = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                ++leftmax;
                ++leftmin;
            }
            if(c == ')') {
                --leftmax;
                if(leftmax < 0)
                    return false;
                leftmin = Math.max(leftmin - 1, 0);
            }
            if(c == '*') {
                ++leftmax;
                leftmin = Math.max(leftmin - 1, 0);
            }
        }
        return leftmin == 0;
    }
}
