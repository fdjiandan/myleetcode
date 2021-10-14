public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int ans = 0;
        while(ans + 1 < len && arr[ans] < arr[ans+1]) {
            ans++;
        }
        return ans;
    }
}
