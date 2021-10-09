import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -100, 3, 99};
        rotate2(nums, 2);
        System.out.println(Arrays.toString(nums));

    }
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            for (int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
    
    public static void rotate2(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return;
        int lenth = nums.length;
        int pos = k % lenth;
        int temp = nums[0];
        for (int i = 0; i < lenth; i++) {
            int nt = nums[pos];
            nums[pos] = temp;
            pos = (pos + k) % lenth;
            temp = nt;
        }
    }
}