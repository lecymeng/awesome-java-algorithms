package LeetCode.easy.数组.存在重复;

/**
 * @author Weicools Create on 2018.04.28
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/
 */
public class Solution {
  public boolean containsDuplicate (int[] num) {

    return false;
  }

  public static void main (String[] args) {
    int[] num1 = { 1, 2, 3, 4 };
    int[] num2 = { 1, 2, 3, 1 };

    Solution solution = new Solution();
    System.out.println(solution.containsDuplicate(num1));
    System.out.println(solution.containsDuplicate(num2));
  }
}
