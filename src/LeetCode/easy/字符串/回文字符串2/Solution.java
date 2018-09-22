package LeetCode.easy.字符串.回文字符串2;

/**
 * @author Weicools Create on 2018.09.19
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba" 输出: True 示例 2:
 * 输入: "abca" 输出: True 解释: 你可以删除c字符。
 *
 * desc: https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 */
class Solution {
  public boolean validPalindrome (String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }
    }

    return true;
  }

  private boolean isPalindrome (String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.validPalindrome("abca"));
  }
}
