import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsin150 {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        List<String> ss = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(ss);
        return String.join(" ", ss);
    }

    public static String reverseWords1(String s) {
        String[] ss = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            String a = ss[i].trim();
            if(!a.isEmpty()) {
                res.append(a);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}
