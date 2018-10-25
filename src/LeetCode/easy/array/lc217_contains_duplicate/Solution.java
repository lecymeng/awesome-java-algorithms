package LeetCode.easy.array.lc217_contains_duplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weicools Create on 2018.04.28
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * sulotion: https://leetcode.com/problems/contains-duplicate/solution/
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 * tag: 数组、哈希表
 */
public class Solution {
  public boolean containsDuplicate (int[] num) {
    int length = num.length;
    Map<Integer, Integer> map = new HashMap<>(length);
    for (int i = 0; i < length; i++) {
      if (map.containsKey(num[i])) {
        return true;
      } else {
        map.put(num[i], i);
      }
    }
    return false;
  }

  public boolean containsDuplicateAnswer(int[] num) {
    for (int i = 0; i < num.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (num[j] == num[i]) {
          return true;
        }
      }
    }
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
