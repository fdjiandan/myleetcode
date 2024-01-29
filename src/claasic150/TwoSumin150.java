import java.util.Arrays;

public class TwoSumin150 {

    public static void main(String[] args) {

        int[] numbers = new int[]{-1,0};
        int target = -1;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int head = 0, last = numbers.length-1;
        int sum = numbers[head] + numbers[last];
        while(sum != target) {
            if(sum > target) {
                last -= 1;
            }
            if(sum < target) {
                head += 1;
            }
            sum = numbers[head] + numbers[last];
        }
        result[0] = head+1;
        result[1] = last+1;
        return result;
    }
}
