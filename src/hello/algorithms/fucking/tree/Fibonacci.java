package hello.algorithms.fucking.tree;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int result = fibonacci.fib0(20);
        System.out.println(result);

        int result1 = fibonacci.fib1(20);
        System.out.println(result1);

        int result2 = fibonacci.fib2(20);
        System.out.println(result2);

        int result3 = fibonacci.fib3(20);
        System.out.println(result3);
    }

    int fib0(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib0(n - 1) + fib0(n - 2);
    }

    int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        return fib1Helper(nums, n);
    }

    int fib1Helper(int[] nums, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        nums[n] = fib1Helper(nums, n - 1) + fib1Helper(nums, n - 2);
        return nums[n];
    }

    int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    int fib3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + curr;
            pre = curr;
            curr = sum;
        }
        return curr;
    }
}
