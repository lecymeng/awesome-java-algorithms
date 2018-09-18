package LeetCode.easy.字符串.字符串中的第一个唯一字符;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 * https://leetcode.com/problems/first-unique-character-in-a-string/discuss/
 */
class Solution {
  public int firstUniqChar (String s) {
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (freq[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();

    System.out.println(s.firstUniqChar("leetcode"));
    System.out.println(s.firstUniqChar("loveleetcode"));
  }
}
