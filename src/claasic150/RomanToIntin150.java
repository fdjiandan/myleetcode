import java.util.*;

public class RomanToIntin150 {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('V', 5);
        roman.put('I', 1);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int val = roman.get(c);
            if(i < len - 1 && val < roman.get(s.charAt(i+1))) {
                res -= val;
            } else {
                res += val;
            }
        }
        return res;
    }
}
