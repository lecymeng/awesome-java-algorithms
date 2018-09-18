package LeetCode.easy.字符串.反转字符串中的元音字母;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Weicools Create on 2018.09.18
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * 输入: "hello" 输出: "holle"
 * 示例 2:
 * 输入: "leetcode" 输出: "leotcede"
 * 说明: 元音字母不包含字母"y"。
 *
 * desc: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * 使用双指针，指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
 */
class Solution {
  public String reverseVowels (String s) {
    HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    int i = 0, j = s.length() - 1;
    char[] chars = new char[s.length()];
    while (i <= j) {
      char ci = s.charAt(i);
      char cj = s.charAt(j);
      if (!vowels.contains(ci)) {
        chars[i++] = ci;
      } else if (!vowels.contains(cj)) {
        chars[j--] = cj;
      } else {
        chars[i++] = cj;
        chars[j--] = ci;
      }
    }

    return new String(chars);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.reverseVowels("leetcode"));
  }
}
