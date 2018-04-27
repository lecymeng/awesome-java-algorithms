package LeetCode.easy.数组.买卖股票的最佳时机I;

/**
 * Created by Weicools on 2018/4/27.
 * <p>
 * desc: Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
 */
public class Solution {
    /*
    Time complexity : O(n)O(n). Only a single pass is needed.
    Space complexity : O(1)O(1). Only two variables are used.
    */
    public int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(nums));
    }
}
