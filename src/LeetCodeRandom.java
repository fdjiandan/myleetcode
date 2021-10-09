import java.util.Random;

public class LeetCodeRandom {

    public static void main(String[] args) {
        int[] num = new int[]{1,3};
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = total + num[i];
            total = num[i];
        }
        for (int i = 0; i < 4; i++) {
            int r = new Random().nextInt(total) + 1;
            int index = 0;
            for (int j = 0; j < num.length; j++) {
                if(num[j] >= r) {
                    index = j;
                    System.out.println(index);
                    break;
                }
            }
        }
    }
}
