package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 *
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * desc: https://leetcode-cn.com/problems/reverse-string/description/
 * discuss: https://leetcode.com/problems/reverse-string/discuss/
 * tag: 双指针、string
 */
class LC0344ReverseString {
  public String reverseString (String s) {
    char[] c = s.toCharArray();
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      char temp = c[i];
      c[i] = c[len - 1 - i];
      c[len - 1 - i] = temp;
    }

    return new String(c);
  }

  public static void main (String[] args) {
    String str1 = "hello";
    String str2 = "hello2";
    LC0344ReverseString s = new LC0344ReverseString();
    System.out.println(s.reverseString(str1));
    System.out.println(s.reverseString(str2));
  }
}
