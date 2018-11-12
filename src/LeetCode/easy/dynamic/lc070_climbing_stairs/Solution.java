package LeetCode.easy.dynamic.lc070_climbing_stairs;

/**
 * @author Weicools Create on 2018.11.10
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * desc: https://leetcode-cn.com/problems/climbing-stairs/description/
 * tag: 动态规划
 */
class Solution {
  /**
   * 我们假设到顶层共有 f(n) 种，那么 f(n) = f(n - 1) + f(n - 2) 肯定是成立的
   * 意思就是我们迈向顶层的最后一步是在倒数第一级台阶或者在倒数第二级台阶
   * 算法我对空间复杂度进行了优化，因为在迭代过程中只需要两个变量即可
   */
  public int climbStairs (int n) {
    int a = 1, b = 1;
    while (--n > 0) {
      b += a;
      a = b - a;
    }
    return b;
  }

  /**
   * 递归方式计算，耗时多
   */
  @Deprecated
  public int climbStairsV0 (int n) {
    if (n > 2) {
      return climbStairs(n - 2) + climbStairs(n - 1);
    } else if (n == 2) {
      return 2;
    }

    return 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    long t1 = System.currentTimeMillis();
    int a = s.climbStairs(44);
    long t2 = System.currentTimeMillis();
    int b = s.climbStairsV0(44);
    long t3 = System.currentTimeMillis();
    System.out.println("result: " + a + ", need:" + (t2 - t1) + "ms");
    System.out.println("result: " + b + ", need:" + (t3 - t2) + "ms");
  }
}
