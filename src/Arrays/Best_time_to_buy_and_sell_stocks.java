package Arrays;

public class Best_time_to_buy_and_sell_stocks {

    public static void main(String[] args) {
        int[] prices = { 7,6,4,3,1 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int currentProfit = 0, maxProfit = 0, mini = prices[0];
        for (int i = 0; i < prices.length; i++) {
            currentProfit = prices[i] - mini;
            maxProfit = Math.max(maxProfit, currentProfit);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }

}
