public class MaxProfitin150 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int value = maxProfit(prices);
        System.out.println(value);
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int buy = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] <= buy) {
                buy = prices[i];
            } else {
                int value = prices[i] - buy;
                if(value >= max) {
                    max = value;
                }
            }
        }
        return max;
    }
}
