package LeetCode.String.ValidPalindrome;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example
 * `"A man, a plan, a canal: Panama"` is a palindrome
 * `"race a car"` is *not* a palindrome.
 *
 * 判断一个字符串是不是回文串
 */
public class Solution {
    /*
    字符串的回文判断问题，由于字符串可随机访问，故逐个比较首尾字符是否相等最为便利，即常见的『两根指针』技法。
    两步走：
    1. 找到最左边和最右边的第一个合法字符(字母或者字符)
    2. 一致转换为小写进行比较
    */
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().isEmpty()){
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            // isLetterOrDigit 字母或者数字
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
