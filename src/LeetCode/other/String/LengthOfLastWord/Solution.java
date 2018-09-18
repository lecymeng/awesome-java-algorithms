package LeetCode.other.String.LengthOfLastWord;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * desc:
 */
public class Solution {
  public int lengthOfLastWord (String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int len = s.length();
    int lastLen = 0;
    for (int i = len - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        if (lastLen > 0) {
          return lastLen;
        }
      } else {
        lastLen++;
      }
    }

    return lastLen;
  }

  public static void main (String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.lengthOfLastWord("hello me "));
    System.out.println(solution.lengthOfLastWord("hello world"));
  }
}
