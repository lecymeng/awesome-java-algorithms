package LeetCode.easy.数组.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * desc: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 *
 * 给定 num = [2, 7, 11, 15], target = 9
 * 因为 num[0] + num[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * https://leetcode.com/problems/two-sum/solution/
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */
public class Solution {
  public int[] twoSum1 (int[] num, int target) {
    int len = num.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if ((num[i] + num[j]) == target) {
          return new int[] { i, j };
        }
      }
    }

    return null;
  }

  public int[] twoSum2 (int[] num, int target) {
    int len = num.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      int temp = target - num[i];
      if (map.containsKey(temp)) {
        return new int[] { map.get(temp), i };
      }

      map.put(num[i], i);
    }

    return null;
  }

  public static void main (String[] args) {
    Solution solution = new Solution();
    int[] num = { 2, 7, 11, 15 };
    System.out.println(Arrays.toString(solution.twoSum2(num, 9)));
  }
}
