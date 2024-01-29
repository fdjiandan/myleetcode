import java.util.Arrays;

public class MaxAreain150 {

    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int start = 0, end = len - 1;
        int max = 0;
        while (start < end) {
            int min = Math.min(height[start], height[end]);
            max = Math.max(max, min * (end-start));
            if(min == height[start]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
