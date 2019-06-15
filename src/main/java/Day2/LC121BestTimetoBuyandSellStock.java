package Day2;

import java.util.Arrays;

public class LC121BestTimetoBuyandSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * time = O(n)
     * space = O(1)
     */

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;
        int min = prices[0];

        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }

        return res;
    }


    // follow up 1: 不限制交易次数，那么只要相邻的两个价格后一个大于前一个，就可以交易，这他妈叫薄利多销
    public static int maxProfitF1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }



    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit1(new int[]{7,6,4,3,1}));

        System.out.println(maxProfitF1(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitF1(new int[]{1,2,3,4,5}));
        System.out.println(maxProfitF1(new int[]{7,6,4,3,1}));
    }
}
