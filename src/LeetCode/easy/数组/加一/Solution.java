package LeetCode.easy.数组.加一;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.08.18
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * discuss: https://leetcode.com/problems/plus-one/discuss/?query=java&orderBy=none&page=1
 */
class Solution {
  public int[] plusOne (int[] digits) {
    int length = digits.length;
    for (int i = length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] result = new int[length + 1];
    result[0] = 1;
    return result;
  }

  public static void main (String[] args) {
    int[] num1 = { 1, 2, 2, 1 };
    int[] num2 = { 2, 9 };
    int[] num3 = { 4, 9, 5 };
    int[] num4 = { 9, 4, 9, 9, 9 };

    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.plusOne(num1)));
    System.out.println(Arrays.toString(solution.plusOne(num2)));
    System.out.println(Arrays.toString(solution.plusOne(num3)));
    System.out.println(Arrays.toString(solution.plusOne(num4)));
  }
}
