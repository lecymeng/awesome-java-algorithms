package LeetCode.easy.数组.买卖股票的最佳时机II;

/**
 * Created by Weicools on 2018/4/27.
 * <p>
 * desc: 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */
public class Solution {
    /*
    Time complexity : O(n)O(n). Single pass.
    Space complexity : O(1)O(1). Constant space required.
    */
    public int maxProfit(int[] prices) {
        int i = 0;
        int volley, peak;
        int maxProfit = 0;

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            volley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak - volley;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(nums));
    }
}
