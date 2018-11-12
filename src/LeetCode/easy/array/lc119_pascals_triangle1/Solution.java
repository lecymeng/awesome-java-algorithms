package LeetCode.easy.array.lc119_pascals_triangle1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Weicools Create on 2018.11.13
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * desc: https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 * tag: 数组
 */
class Solution {
  public List<Integer> getRow (int rowIndex) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      res.add(1);
      for (int j = i - 1; j > 0; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }

    return res;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.getRow(3).toArray()));
    System.out.println(Arrays.toString(s.getRow(5).toArray()));
  }
}
