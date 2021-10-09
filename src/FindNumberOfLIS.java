public class FindNumberOfLIS {
    public static void main(String[] args) {

        int[] nums = new int[]{1,3,5,4,7};
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        while(n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] cn = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cn[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            
        }
        return 0;
    }
}
