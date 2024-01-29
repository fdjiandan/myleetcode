import sun.java2d.loops.DrawGlyphList;

import java.awt.dnd.DragGestureEvent;
import java.util.Arrays;

public class Candyin150 {
    public static void main(String[] args) {

        int[] ratings = new int[]{3,0,1,2,2,3,4,5};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        if(len <= 1) return 1;
        int[] res = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            res[i] = 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        right[len-1] = 0;
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1]+1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                right[i] = right[i+1]+1;
            } else {
                right[i] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            res[i] = Math.max(left[i], right[i]) + 1;
            result += res[i];
        }
        return result;
    }
}
