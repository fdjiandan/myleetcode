import java.util.HashMap;
import java.util.Map;

public class IntToRomanin150 {

    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int pos = 1;
        StringBuilder res = new StringBuilder();
        Map<Integer, Character> roman = new HashMap<>();
        roman.put(1, 'I');
        roman.put(5, 'V');
        roman.put(10, 'X');
        roman.put(50, 'L');
        roman.put(100, 'C');
        roman.put(500, 'D');
        roman.put(1000, 'M');
        roman.put(5000, '-');
        roman.put(10000, '-');
        while (num != 0) {
            int val = num % 10;
            char one = roman.get(pos);
            char five = roman.get(pos * 5);
            char ten = roman.get(pos*10);
            if(val == 9) {
                res.append(ten).append(one);
            }
            if(val < 9 && val >= 5) {
                val -= 5;
                for (int i = 0; i < val; i++) {
                    res.append(one);
                }
                res.append(five);
                val = 0;
            }
            if(val == 4) {
                res.append(five).append(one);
            }
            if(val < 4) {
                for (int i = 0; i < val; i++) {
                    res.append(one);
                }
            }
            pos *= 10;
            num /= 10;
        }
        return res.reverse().toString();
    }
}
