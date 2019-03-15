package swordoffer;

import java.util.Arrays;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级……它也可以跳上 n 级
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 *
 * link: https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class SO09JumpFloor2 {
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
        SO09JumpFloor2 s = new SO09JumpFloor2();
        System.out.println(s.jumpFloorII(5));
    }
}
