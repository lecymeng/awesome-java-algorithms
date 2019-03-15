package leetcode.easy.array;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * desc: https://leetcode-cn.com/problems/rotate-array/description/
 */
public class LC0189RotateArray {
  public void rotate (int[] num, int k) {
    k %= num.length;
    reverse(num, 0, num.length - 1);
    reverse(num, 0, k - 1);
    reverse(num, k, num.length - 1);
  }

  private void reverse (int[] num, int start, int end) {
    while (start < end) {
      int temp = num[start];
      num[start] = num[end];
      num[end] = temp;
      start++;
      end--;
    }
  }

  public static void main (String[] args) {
    LC0189RotateArray solution = new LC0189RotateArray();
    int[] num = { 1, 2, 3, 4, 5, 6, 7 };
    solution.rotate(num, 3);
    System.out.println(Arrays.toString(num));
  }
}
