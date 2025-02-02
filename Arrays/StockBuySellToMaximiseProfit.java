package Arrays;

public class StockBuySellToMaximiseProfit {

    // https://www.geeksforgeeks.org/stock-buy-sell/

    // Stock Buy and Sell – Single Transaction Allowed
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

    // Stock Buy and Sell – Multiple Transaction Allowed

    // TC - O(2^n), SC - O(n)
    static int maximumProfit(int[] prices) {
        return maxProfitRec(prices, 0, prices.length - 1);
    }

    private static int maxProfitRec(int[] price, int start, int end) {
        int ans = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr = (price[j] - price[i]) + maxProfitRec(price, start, i - 1) + maxProfitRec(price, j + 1, end);
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }

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


    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 14};
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

        System.out.println(maxProfitSingleBuyAndSell(prices));
        System.out.println(maxProfitMultipleBuyAndSell(prices));
    }

}
