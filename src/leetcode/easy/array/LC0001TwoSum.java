package leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * 两数之和
 * desc: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 *
 * 给定 num = [2, 7, 11, 15], target = 9
 * 因为 num[0] + num[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 * tag: 数组、哈希表
 */
public class LC0001TwoSum {
  @Deprecated
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

  @Deprecated
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

  public int[] twoSum (int[] num, int target) {
    int i = 0;
    int j = num.length - 1;
    while (i < j) {
      int sum = num[i] + num[j];
      if (sum == target) {
        return new int[] { i + 1, j + 1 };
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }

    return null;
  }

  public static void main (String[] args) {
    LC0001TwoSum solution = new LC0001TwoSum();
    int[] num = { 2, 7, 11, 15 };
    System.out.println(Arrays.toString(solution.twoSum(num, 9)));
    System.out.println(Arrays.toString(solution.twoSum1(num, 9)));
    System.out.println(Arrays.toString(solution.twoSum2(num, 9)));
  }
}
