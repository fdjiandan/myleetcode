import java.util.LinkedList;
import java.util.Queue;

public class BalancedStringSplit {

    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int num = 0;
        int len = s.length();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if(queue.isEmpty()) {
                queue.add(c);
            } else {
                Character in = queue.peek();
                if(in == c) {
                    queue.add(c);
                } else {
                    queue.poll();
                    if(queue.isEmpty()) {
                        num++;
                    }
                }
            }
        }
        if(queue.isEmpty())
            return num;
        return 0;
    }
}
