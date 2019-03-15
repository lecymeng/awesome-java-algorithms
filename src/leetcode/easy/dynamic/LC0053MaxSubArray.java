package leetcode.easy.dynamic;

/**
 * @author Weicools Create on 2018.11.12
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * desc: https://leetcode-cn.com/problems/maximum-subarray/description/
 * tag: 数组、分治算法、动态规划
 */
class LC0053MaxSubArray {

  public int maxSubArray (int[] nums) {
    int len = nums.length, dp = nums[0], max = dp;
    for (int i = 1; i < len; i++) {
      dp = nums[i] + (dp > 0 ? dp : 0);
      if (dp > max) {
        max = dp;
      }
    }
    return max;
  }

  public static void main (String[] args) {
    LC0053MaxSubArray s = new LC0053MaxSubArray();
    System.out.println(s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
  }
}
