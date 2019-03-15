package swordoffer.递归和循环.变态跳台阶;

import java.util.Arrays;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级……它也可以跳上 n 级
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class Solution {
    public int jumpFloorII(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jumpFloorII(5));
    }
}
