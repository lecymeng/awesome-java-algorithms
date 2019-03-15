package leetcode.easy.math;

/**
 * @author Weicools Create on 2018.09.18
 *
 * 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 示例1:
 * 输入: 5 输出: True 解释: 1 * 1 + 2 * 2 = 5
 * 示例2:
 * 输入: 3 输出: False
 *
 * desc: https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 * tag: math
 */
class LC0633SumOfSquareNumber {
  public boolean judgeSquareSum (int c) {
    int i = 0, j = (int) Math.sqrt(c);
    while (i <= j) {
      int res = i * i + j * j;
      if (res == c) {
        return true;
      } else if (res < c) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

  public static void main (String[] args) {
    LC0633SumOfSquareNumber s = new LC0633SumOfSquareNumber();
    System.out.println(s.judgeSquareSum(5));
  }
}
