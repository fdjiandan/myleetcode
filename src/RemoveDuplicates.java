import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(removeNums(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeNums(int[] nums) {
        if(nums.length == 0)
            return 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            while (end < nums.length && nums[end] == nums[start]) {
                end++;
            }
            if(end < nums.length) {
                nums[start + 1] = nums[end];
                start++;
            }
        }
        return start+1;
    }

    public static int removeDulicates(int[] nums) {
        int k = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            boolean find = false;
            for (int i = 0; i < k; i++) {
                if(nums[i] == nums[start]) {
                    find = true;
                }
            }
            if(find) {
                while (end > start) {
                    boolean bak = false;
                    for (int j = 0; j < k; j++) {
                        if(nums[end] == nums[j]) {
                            bak = true;
                            break;
                        }
                    }
                    if(!bak) {
                        int a = nums[start];
                        nums[start] = nums[end];
                        nums[end] = a;
                        start++;
                        k++;
                        end--;
                        break;
                    }
                    end--;
                }
            }
            else {
                start++;
                k++;
            }
        }
        return k;
    }
}
