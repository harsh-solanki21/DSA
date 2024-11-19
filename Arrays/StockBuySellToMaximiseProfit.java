package Arrays;

public class StockBuySellToMaximiseProfit {

    // https://www.geeksforgeeks.org/stock-buy-sell/

    // TC - O(N), SC - O(1)
    static int maxProfitMultipleBuyAndSell(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    // TC - O(N), SC - O(1)
    static int maxProfitSingleBuyAndSell(int[] prices) {
        int maxPrice = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxPrice = Math.max(maxPrice, prices[i] - minPrice);
            }
        }
        return maxPrice;
    }


    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 14};
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfitMultipleBuyAndSell(prices));
        System.out.println(maxProfitSingleBuyAndSell(prices));
    }

}
