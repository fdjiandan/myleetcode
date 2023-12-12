import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = new int[]{15,21,43,55,61};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 1 && citations[0] >= 1) {
            return 1;
        }
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < len; i++) {
            int index = citations[i];
            int paper = len - i;
            int temp = Math.min(paper, index);
            if (temp < h) {
                break;
            }
            h = temp;
        }
        return h;
    }
}
