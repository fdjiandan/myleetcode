public class CanJumpin150 {

    public static void main(String[] args) {
        int[]  nums = new int[]{1,0};
        System.out.printf(String.valueOf(canJump(nums)));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;
        int n = nums[0];
        for (int i = 1; i < len; i++) {
            n = n - 1;
            if(n < 0)
                return false;
            n = Math.max(n, nums[i]);
        }
        return n >= 0;
    }

    public static boolean canJump1(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            for (int j = i + 1; j <= i + n && j < len; j++) {
                result[i][j] = 1;
            }
        }
        result[0][0] = 1;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += result[j][i];
            }
            if( sum == 0 ) {
                return false;
            }
        }
        return true;
    }
}
