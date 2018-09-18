package LeetCode.easy.字符串.回文字符串2;

/**
 * @author Weicools Create on 2018.09.19
 * <p>
 * desc: 可以删除一个字符，判断是否能构成回文字符串。
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
