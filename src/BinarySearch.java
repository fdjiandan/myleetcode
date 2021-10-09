public class BinarySearch {
    public static void main(String[] args) {

        int[] nums = new int[]{9,10};
        System.out.println(search(nums, 10));

    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int max = nums.length - 1;
        int min = 0;
        while (min <= max) {
            int mid = ( min + max) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }
}
