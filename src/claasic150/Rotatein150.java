import java.util.Arrays;

public class Rotatein150 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,100,3,9};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if(k == 0) return;
        int change = 0, len = nums.length, cur = 0, dest = (cur + k)%len;
        if(len == 1) return;
        int temp = nums[cur];
        while (change < len) {
            int num = nums[dest];
            nums[dest] = temp;
            temp = num;
            change++;
            dest = (dest + k) % len;
            if(dest == cur) {
                nums[cur] = temp;
                cur++;
                change++;
                dest = (cur + k)%len;
                temp = nums[cur];
            }
        }
    }

    public static void rotate1(int[] nums, int k) {
        while(k > 0) {
            int len = nums.length;
            int temp = nums[len-1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if(k == 0)
            return;
        if(k == 1) {
            int t = nums[nums.length-1];
            for (int i = nums.length-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = t;
            return;
        }
        if(k > 1) {
            rotate(nums, 1);
            rotate(nums, k-1);
        }
    }
}
