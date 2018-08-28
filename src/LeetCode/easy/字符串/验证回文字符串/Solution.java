package LeetCode.easy.字符串.验证回文字符串;

/**
 * @author Weicools Create on 2018.08.18
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
 * https://leetcode.com/problems/valid-palindrome/discuss/
 */
class Solution {
  public boolean isPalindrome (String s) {
    if (s.isEmpty()) {
      return true;
    }
    char[] chars = s.toUpperCase().toCharArray();
    StringBuilder builder = new StringBuilder();
    for (char c : chars) {
      if ((c >= 65 && c <= 90) || (c >= 48 && c <= 57)) {
        builder.append(c);
      }
    }

    char[] newChar = builder.toString().toCharArray();
    int i = 0;
    int j = newChar.length - 1;
    while (i < j) {
      if (newChar[i] != newChar[j]) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public boolean isPalindrome2 (String s) {
    if (s.isEmpty()) {
      return true;
    }

    int head = 0;
    int tail = s.length() - 1;
    char cHead, cTail;
    s = s.toUpperCase();
    while (head <= tail) {
      cHead = s.charAt(head);
      cTail = s.charAt(tail);
      if (!Character.isLetterOrDigit(cHead)) {
        head++;
      } else if (!Character.isLetterOrDigit(cTail)) {
        tail--;
      } else {
        if (cHead != cTail) {
          return false;
        }
        head++;
        tail--;
      }
    }

    return true;
  }

  public static void main (String[] args) {
    Solution s = new Solution();

    System.out.println(s.isPalindrome("0P"));
    System.out.println(s.isPalindrome("race a car"));
    System.out.println(s.isPalindrome("raca1 1a car"));
    System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
  }
}
