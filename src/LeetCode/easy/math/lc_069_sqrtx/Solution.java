package LeetCode.easy.math.lc_069_sqrtx;

/**
 * @author Weicools Create on 2018.11.12
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 *
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * desc: https://leetcode-cn.com/problems/sqrtx/description/
 * tag: 数学、二分查找
 */
class Solution {
  public int mySqrt (int x) {
    long n = x;
    while (n * n > x) {
      n = (n + x / n) / 2;
    }

    return (int) n;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(8));
    System.out.println(s.mySqrt(9));
    System.out.println(s.mySqrt(12));
    System.out.println(s.mySqrt(16));
  }
}
