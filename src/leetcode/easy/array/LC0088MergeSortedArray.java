package leetcode.easy.array;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.09.21
 *
 * 合并有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * desc: https://leetcode.com/problems/merge-sorted-array/description/
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 * tag: 数组、双指针
 */
class LC0088MergeSortedArray {
  /**
   * 依次把大的元素插入到 nums1 的末尾，
   * 确保 nums2 中的元素全部插入到 nums1 即可。
   */
  public void merge (int[] nums1, int m, int[] nums2, int n) {
    int pm = m - 1, pn = n - 1;
    int pMerge = m + n - 1;
    while (pm >= 0 && pn >= 0) {
      nums1[pMerge--] = nums1[pm] > nums2[pn] ? nums1[pm--] : nums2[pn--];
    }

    while (pn >= 0) {
      nums1[pMerge--] = nums2[pn--];
    }
  }

  public static void main (String[] args) {
    LC0088MergeSortedArray s = new LC0088MergeSortedArray();
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int[] nums2 = { 2, 5, 6 };
    s.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
}
