package swordoffer.位运算.二进制中1的个数;

/**
 * Created by Weicools on 2018/4/22.
 * <p>
 * desc: 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class Solution {
    /*Integer.bitCount()*/
    public int numberOf1(int n) {
        return Integer.bitCount(n);
    }

    /*
    O(logM) 时间复杂度解法，其中 M 表示 1 的个数。

    该位运算是去除 n 的位级表示中最低的那一位。

    n       : 10110100
    n-1     : 10110011
    n&(n-1) : 10110000
    */
    public int getNumberOf1(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getNumberOf1(2));
        System.out.println(s.getNumberOf1(3));
        System.out.println(s.getNumberOf1(8));
        System.out.println(s.getNumberOf1(16));
    }
}
