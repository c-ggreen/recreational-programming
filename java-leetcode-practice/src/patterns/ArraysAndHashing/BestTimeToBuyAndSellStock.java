// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

package patterns.ArraysAndHashing;

public class BestTimeToBuyAndSellStock {
    public int solution(int[] prices) {
        int maximum = 0;
        int minimumBuy = 0;
        if (prices.length < 2)
            return maximum;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                minimumBuy = prices[i];
                continue;
            }
            if (minimumBuy > prices[i]){
                minimumBuy = prices[i];
                continue;
            }
            int profit = prices[i] - minimumBuy;
            if (profit > maximum)
                maximum = profit;
        }

        return maximum;
    }
}
