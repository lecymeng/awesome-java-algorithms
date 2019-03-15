package swordoffer.动态规划.斐波那契数列;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。n<=39
 * <p>
 * 斐波那契数列: 0、1、1、2、3、5、8、13、21...
 * 递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>2，n∈N*）
 */
public class Solution {
    /*
    解题思路
    如果使用递归求解，会重复计算一些子问题。
    例如，计算 f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8) 被重复计算了。

    递归方法是将一个问题划分成多个子问题求解，
    动态规划也是如此，但是动态规划会把子问题的解缓存起来，避免重复求解子问题
    */
    public int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    /*
    考虑到第 i 项只与第 i-1 和第 i-2 项有关，
    因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)
    */
    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int result = 0;
        int pre1 = 0, pre2 = 1;
        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }

        return result;
    }

    /*----------------------------------------*/
    /*
    待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，
    之后就能以 O(1) 时间复杂度得到第 n 项的值了
    */
    private int[] mFib = new int[40];

    public Solution() {
        mFib[0] = 0;//可忽略，默认初始化为0
        mFib[1] = 1;
        for (int i = 2; i < mFib.length; i++) {
            mFib[i] = mFib[i - 1] + mFib[i - 2];
        }
    }

    public int fibonacci(int n) {
        return mFib[n];
    }
    /*----------------------------------------*/

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("第5项：" + s.fibonacci2(5));
        System.out.println("第10项：" + s.fibonacci2(10));
        System.out.println("第20项：" + s.fibonacci2(20));
        System.out.println("第25项：" + s.fibonacci2(25));

        System.out.println("第4项：" + s.fibonacci(4));
        System.out.println("第8项：" + s.fibonacci1(8));
    }
}
