public class Jumpin150 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        int start = 0;
        int n = 0;
        while (start < len - 1) {
            int cur = nums[start];
            if(start + cur >= len - 1) {
                return n+1;
            }
            int max = start;
            int temp = start;
            for (int i = 1; i <= cur && i < len; i++) {
                int v = start + i + nums[start + i];
                if(v > max) {
                    max = v;
                    temp = start + i;
                }
            }
            start = temp;
            n++;
        }
        return n;
    }
}
