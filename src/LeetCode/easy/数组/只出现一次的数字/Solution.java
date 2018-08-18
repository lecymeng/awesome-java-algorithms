package LeetCode.easy.数组.只出现一次的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weicools Create on 2018.08.18
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 */
class Solution {
  public int singleNumber (int[] num) {
    int length = num.length;
    Map<Integer, Integer> map = new HashMap<>(length);
    for (int aNum : num) {
      if (map.containsKey(aNum)) {
        map.put(aNum, map.get(aNum) + 1);
      } else {
        map.put(aNum, 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return -1;
  }

  public static void main (String[] args) {
    int[] num1 = { 2, 2, 1 };
    int[] num2 = { 4, 1, 2, 1, 2 };

    Solution solution = new Solution();
    System.out.println(solution.singleNumber(num1));
    System.out.println(solution.singleNumber(num2));
  }
}
