package leetcode.easy.math;

/**
 * @author Weicools Create on 2018.11.12
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * desc: https://leetcode-cn.com/problems/add-binary/description/
 * tag: 数学、字符串
 */
class LC0067AddBinary {
  /**
   * 用 carry 表示进位，从后往前算，依次往前，
   * 每算出一位就插入到最前面即可，
   * 直到把两个二进制串都遍历完即可
   */
  public String addBinary (String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0, pa = a.length() - 1, pb = b.length() - 1;
    while (pa >= 0 && pb >= 0) {
      carry += a.charAt(pa--) - '0';
      carry += b.charAt(pb--) - '0';
      sb.insert(0, (char) (carry % 2 + '0'));
      carry >>= 1;
    }

    while (pa >= 0) {
      carry += a.charAt(pa--) - '0';
      sb.insert(0, (char) (carry % 2 + '0'));
      carry >>= 1;
    }
    while (pb >= 0) {
      carry += b.charAt(pb--) - '0';
      sb.insert(0, (char) (carry % 2 + '0'));
      carry >>= 1;
    }

    if (carry == 1) {
      sb.insert(0, '1');
    }

    return sb.toString();
  }

  public static void main (String[] args) {
    LC0067AddBinary s = new LC0067AddBinary();
    System.out.println(s.addBinary("11", "1"));
    System.out.println(s.addBinary("1010", "1011"));
  }
}
