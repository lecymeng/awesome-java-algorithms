package swordoffer.递归和循环.跳台阶;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 一只青蛙一次可以跳上 1级台阶，也可以跳上 2级
 * 求该青蛙跳上一个 n级的台阶总共有多少种跳法
 */
public class Solution {
    /**
     * 复杂度：O(N) + O(N)
     */
    public int jumpFloor1(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    /**
     * 复杂度：O(N) + O(1)
     */
    public int jumpFloor2(int n) {
        if (n <= 1) {
            return n;
        }

        int pre1 = 0, pre2 = 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jumpFloor1(5));
        System.out.println(s.jumpFloor2(5));
    }
}
