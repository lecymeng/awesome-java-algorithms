package leetcode.guide.dynamic;

/**
 * @author weicools
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci.Solution solution = new Fibonacci().new Solution();
        solution.fib(4);
        solution.fibMemo(4);
        solution.fibDp(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }

        /**
         * 带备忘录的递归解法
         *
         * 耗时的原因是重复计算，那么我们可以造一个「备忘录」，
         * 每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；每次遇到一个子问题先去「备忘录」里查一查，
         * 如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了
         *
         * 一般使用一个 数组 或者 哈希表（字典）充当这个「备忘录」，思想都是一样的。
         */
        public int fibMemo(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            int[] memo = new int[n + 1];
            return fibMemoHelper(n, memo);
        }

        private int fibMemoHelper(int n, int[] memo) {
            if (n == 1 || n == 2) {
                return 1;
            }

            if (memo[n] != 0) {
                return memo[n];
            }

            memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
            return memo[n];
        }

        /**
         * dp 数组的迭代解法
         *
         * 有了上一步 「备忘录」 的启发，我们可以把这个 「备忘录」 独立出来成为一张表 dp，
         * 在这张表上完成 「自底向上」 的实现
         */
        public int fibDp(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
