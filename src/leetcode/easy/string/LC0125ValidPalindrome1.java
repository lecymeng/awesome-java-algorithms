package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
 * https://leetcode.com/problems/valid-palindrome/discuss/
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 * tag: 双指针, string
 */
class LC0125ValidPalindrome1 {
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
    LC0125ValidPalindrome1 s = new LC0125ValidPalindrome1();

    System.out.println(s.isPalindrome("0P"));
    System.out.println(s.isPalindrome("race a car"));
    System.out.println(s.isPalindrome("raca1 1a car"));
    System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
  }
}
