package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.11.12
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * desc: https://leetcode-cn.com/problems/length-of-last-word/description/
 * tag: 字符串
 */
class LC0058LengthOfLastWord {
  public int lengthOfLastWord (String s) {
    int pos = s.length() - 1;
    while (pos >= 0 && s.charAt(pos) == ' ') {
      pos--;
    }

    int end = pos;
    while (pos >= 0 && s.charAt(pos) != ' ') {
      pos--;
    }

    return end - pos;
  }

  public static void main (String[] args) {
    LC0058LengthOfLastWord s = new LC0058LengthOfLastWord();
    System.out.println(s.lengthOfLastWord("hi wei hello"));
    System.out.println(s.lengthOfLastWord("hi wei "));
  }
}
