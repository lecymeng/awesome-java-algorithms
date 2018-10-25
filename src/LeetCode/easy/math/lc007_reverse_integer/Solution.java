package LeetCode.easy.math.lc007_reverse_integer;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 7. 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 * https://leetcode.com/problems/reverse-integer/solution/
 * tag: 数学
 */
class Solution {
  public int reverse (int x) {
    int y = x;
    if (x < 0) {
      y = -x;
    }
    char[] c = String.valueOf(y).toCharArray();
    StringBuilder builder = new StringBuilder();
    int len = c.length;
    for (int i = len - 1; i >= 0; i--) {
      builder.append(c[i]);
    }

    try {
      int result = Integer.parseInt(builder.toString());
      if (x < 0) {
        result = -result;
      }
      return result;
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public int reverseAnswer (int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
        return 0;
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
        return 0;
      }
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public static void main (String[] args) {
    int x1 = 3124;
    int x2 = 12138;
    int x3 = 121380;

    Solution s = new Solution();
    System.out.println(s.reverse(x1));
    System.out.println(s.reverse(x2));
    System.out.println(s.reverseAnswer(x3));
  }
}
