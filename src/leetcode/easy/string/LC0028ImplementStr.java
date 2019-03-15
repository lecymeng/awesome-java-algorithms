package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * desc: https://leetcode-cn.com/problems/implement-strstr/description/
 * tag: 双指针、字符串
 */
class LC0028ImplementStr {
  /**
   * 如果找不到则返回-1，当子串长度大于主串，直接返回-1
   */
  public int strStr (String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }

    int haystackLen = haystack.length();
    int needleLen = needle.length();
    for (int i = 0; ; i++) {
      if (i + needleLen > haystackLen) {
        return -1;
      }

      for (int j = 0; ; j++) {
        if (j == needleLen) {
          return i;
        }

        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
    }
  }

  public static void main (String[] args) {
    LC0028ImplementStr s = new LC0028ImplementStr();
    String haystack = "hello";
    String needle = "ll";

    System.out.println(s.strStr(haystack, needle));
  }
}
