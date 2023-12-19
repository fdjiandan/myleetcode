import java.util.Arrays;
import java.util.Collections;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = new int[]{-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            return nums;
        }
        int[] result = new int[len];
        int[] L = new int[len];
        int[] R = new int[len];
        L[0] = 1; R[len-1] = 1;
        for (int i = 0; i < len - 1; i++) {
            L[i+1] = L[i] * nums[i];
        }
        for (int i = len - 1; i > 0; i--) {
            R[i-1] = R[i] * nums[i];
        }
        for (int i = 0; i < len; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
