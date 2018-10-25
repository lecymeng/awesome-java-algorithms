package SwordOffer.字符串.表示数值的字符串;

/**
 * Created by Weicools on 2018/4/22.
 * <p>
 * desc: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，string "+100","5e2","-123","3.1416" 和 "-1E-16" 都表示数值。
 * 但是 "12e","1a3.14","1.2.3","+-5" 和 "12e+4.3" 都不是。
 */
public class Solution {
    public boolean isNumeric(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumeric("5e2"));
        System.out.println(s.isNumeric("+100"));
        System.out.println(s.isNumeric("3.1416"));
        System.out.println(s.isNumeric("1.2.3"));
    }
}
