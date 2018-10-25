package LeetCode.easy.math.lc009_palindrome_number;

/**
 * @author Weicools Create on 2018.10.24
 *
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * desc: https://leetcode-cn.com/problems/palindrome-number/description/
 * tag: math
 */
public class Solution {
  /**
   * 题意是判断一个有符号整型数是否是回文，也就是逆序过来的整数和原整数相同，
   * 首先负数肯定不是，最普通的方法就是直接算出他的回文数，然后和给定值比较即可。
   */
  public boolean isPalindrome (int x) {
    if (x < 0) {
      return false;
    }

    int copyX = x, result = 0;
    while (copyX > 0) {
      result = result * 10 + copyX % 10;
      copyX /= 10;
    }

    return x == result;
  }

  public boolean isPalindrome2 (int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    int halfReverseX = 0;
    while (x > halfReverseX) {
      halfReverseX = halfReverseX * 10 + x % 10;
      x /= 10;
    }
    return halfReverseX == x || halfReverseX / 10 == x;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.isPalindrome(121));
  }
}
