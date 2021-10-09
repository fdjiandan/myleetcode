public class GetSum {

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        int sum = 0;
        int plus = 0;
        int l = 0;
        while(a > 0 || b > 0) {
            int t1 = a % 2;
            int t2 = b % 2;
            int n = t1 ^ t2 ^ plus;
            for (int i = 0; i < l; i++) {
                n = n << 1;
            }
            sum = sum ^ n;
            if((t1 == 1 && t2 == 1) || (t1 == 1 && plus == 1) || (t2 == 1 && plus == 1))
                plus = 1;
            a = a >> 1;
            b = b >> 1;
            l++;
        }
        if(plus > 0) {
            for (int i = 0; i < l; i++) {
                plus = plus << 1;
            }
            sum = sum ^ plus;
        }
        return sum;
    }
}
