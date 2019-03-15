package leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weicools Create on 2018/4/26.
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * desc: https://leetcode-cn.com/problems/restore-ip-addresses/description/
 * tag: 字符串
 */
public class LC0093RestoreIPAddress {
    /*
    方法一：直接三种循环暴力求解
    方法二：深度搜索，回溯
    */

  /**
   * @param s the IP string
   * @return All possible valid IP addresses
   */
  public List<String> restoreIpAddresses (String s) {
    List<String> result = new ArrayList<>();
    List<String> list = new ArrayList<>();

    if (s.length() < 4 || s.length() > 12) {
      return result;
    }

    helper(result, list, s, 0);
    return result;
  }

  private void helper (List<String> result, List<String> list, String s, int start) {
    if (list.size() == 4) {
      if (start != s.length()) {
        return;
      }

      StringBuilder sb = new StringBuilder();
      for (String tmp : list) {
        sb.append(tmp);
        sb.append(".");
      }
      sb.deleteCharAt(sb.length() - 1);
      result.add(sb.toString());
      return;
    }

    for (int i = start; i < s.length() && i < start + 3; i++) {
      String tmp = s.substring(start, i + 1);
      if (isValid(tmp)) {
        list.add(tmp);
        helper(result, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isValid (String s) {
    if (s.charAt(0) == '0') {
      // to eliminate cases like "00", "10"
      return s.equals("0");
    }
    int digit = Integer.valueOf(s);
    return digit >= 0 && digit <= 255;
  }

  public static void main (String[] args) {
    LC0093RestoreIPAddress solution = new LC0093RestoreIPAddress();
    String IP = "25525511135";
    List<String> r = solution.restoreIpAddresses(IP);

    for (String s : r) {
      System.out.println(s);
    }
  }
}
