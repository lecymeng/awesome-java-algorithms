package LeetCode.easy.数组.两个数组的交集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * discuss: https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/?page=1&query=java&orderBy=most_posts
 */
class Solution {
  public int[] intersect (int[] num1, int[] num2) {
    Map<Integer, Integer> mapCount = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int curr : num1) {
      Integer prev = mapCount.get(curr);
      mapCount.put(curr, prev == null ? 1 : prev + 1);
    }

    for (int curr : num2) {
      Integer prev = mapCount.get(curr);
      if (prev != null) {
        result.add(curr);
        if (prev == 1) {
          mapCount.remove(curr);
        } else {
          mapCount.put(curr, prev - 1);
        }
      }
    }

    int[] res = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }

    return res;
  }

  public static void main (String[] args) {
    int[] num1 = { 1, 2, 2, 1 };
    int[] num2 = { 2, 2 };
    int[] num3 = { 4, 9, 5 };
    int[] num4 = { 9, 4, 9, 8, 4 };

    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.intersect(num1, num2)));
    System.out.println(Arrays.toString(solution.intersect(num3, num4)));
  }
}
