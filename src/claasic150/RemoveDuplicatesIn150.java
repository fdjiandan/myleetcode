public class RemoveDuplicatesIn150 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length, nlen = 1, cur = nums[0], count = 1;
        for (int i = 1; i < length; i++) {
            if(cur == nums[i]) {
                count += 1;
                if(count < 3) {
                    nums[nlen++] = cur;
                }
            } else {
                count = 1;
                cur = nums[i];
                nums[nlen++] = cur;
            }
        }
        return nlen;
    }
}
