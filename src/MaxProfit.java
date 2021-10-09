public class MaxProfit {

    public static void main(String[] args) {
        int[] stock = new int[]{7,1,6,3,5,4};
        System.out.println(maxProfit(stock));
    }

    public static int maxProfit(int[] stock) {
        if(stock.length == 0)
            return 0;
        int k = 0;
        int base = stock[0];
        int buy = 1;
        while(buy < stock.length) {
            while (buy < stock.length && stock[buy] <= base) {
                base = stock[buy];
                buy++;
            }
            if(buy == stock.length)
                break;
            int sell = base;
            while(buy < stock.length && stock[buy] > base) {
                base = stock[buy];
                buy++;
            }
            k += base - sell;
        }
        return k;
    }
}
