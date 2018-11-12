package LeetCode.easy.string.lc038_count_and_say;

/**
 * @author Weicools Create on 2018.11.12
 * 38. 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 * desc: https://leetcode-cn.com/problems/count-and-say/description/
 * tag: 字符串
 */
class Solution {
  public String countAndSay (int n) {
    String str = "1";
    while (--n > 0) {
      int times = 1;
      StringBuilder sb = new StringBuilder();
      char[] chars = str.toCharArray();
      int len = chars.length;
      for (int i = 1; i < len; i++) {
        if (chars[i - 1] == chars[i]) {
          times++;
        } else {
          sb.append(times).append(chars[i - 1]);
          times = 1;
        }
      }

      str = sb.append(times).append(chars[len - 1]).toString();
    }

    return str;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //System.out.println(s.countAndSay(1));
    //System.out.println(s.countAndSay(2));
    //System.out.println(s.countAndSay(3));
    //System.out.println(s.countAndSay(4));
    System.out.println(s.countAndSay(5));
  }
}
