package LeetCode.easy.array.lc035_search_insert_position;

/**
 * @author Weicools Create on 2018.11.12
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * desc: https://leetcode-cn.com/problems/search-insert-position/description/
 * tag: 数组、二分查找
 */
class Solution {
  /**
   * 因为数组已排序，所以我们可以想到二分查找法，
   * 因为查找到的条件是找到第一个等于或者大于 target 的元素的位置，
   * 所以二分法略作变动即可。
   */
  public int searchInsert (int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid = (left + right) / 2;
    while (left <= right) {
      if (target <= nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }

      mid = (left + right) / 2;
    }

    return left;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[] n = { 1, 3, 5, 6 };
    System.out.println(s.searchInsert(n, 5));
    System.out.println(s.searchInsert(n, 2));
    System.out.println(s.searchInsert(n, 4));
  }
}
