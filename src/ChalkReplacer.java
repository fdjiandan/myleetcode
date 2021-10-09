public class ChalkReplacer {

    public static void main(String[] args) {
        int[] chalk = new int[]{5};
        int k = 1;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int j : chalk) {
            sum += j;
        }
        k %= sum;
        int num = 0;
        sum = 0;
        while(num < chalk.length) {
            sum += chalk[num];
            if(sum > k) {
                break;
            }
            num++;
        }
        return num;
    }
}
