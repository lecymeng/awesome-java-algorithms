package LeetCode.String.StringIPAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc: 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址
 * Given `"25525511135"`
 * return `["255.255.11.135", "255.255.111.35"]`. (Order does not matter)
 * <p>
 * 注意 ：中间IP位置不能以0开始，0.01.01.1非法，应该是0.0.101.1或者0.0.10.11
 */
public class Solution {
    /*
    方法一：直接三种循环暴力求解
    方法二：深度搜索，回溯
    */

    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int start) {
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

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0"); // to eliminate cases like "00", "10"
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String IP = "25525511135";
        List<String> r = solution.restoreIpAddresses(IP);

        for (String s : r) {
            System.out.println(s);
        }
    }
}
