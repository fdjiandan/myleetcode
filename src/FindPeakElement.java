public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,3,2,1,5,1};
        System.out.println(findPeakElement(nums, 0, nums.length-1));
    }

    public static int findPeakElement(int[] nums, int start, int end) {
        int len = end - start + 1;
        if(len == 0)
            return -1;
        if(nums.length == 1)
            return 0;
        int mid = start + len/2;
        if(mid == 0) {
            if (nums[mid] > nums[mid + 1])
                return mid;
            else
                return findPeakElement(nums, mid + 1, end);
        }
        if(mid == nums.length - 1) {
            if (nums[mid] > nums[mid - 1])
                return mid;
            else
                return findPeakElement(nums, start, mid - 1);
        }
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
            return mid;
        return Math.max(findPeakElement(nums, start, mid - 1), findPeakElement(nums, mid+1, end));
    }
}
