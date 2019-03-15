package leetcode.easy.array;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 * solution: https://leetcode.com/problems/move-zeroes/solution/
 * https://leetcode-cn.com/problems/move-zeroes/description/
 * tag: 数组、双指针
 */
class LC0283MoveZeroes {
  public void moveZeroes (int[] num) {
    for (int i = 0, j = 0; i < num.length; i++) {
      if (num[i] != 0) {
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
        j++;
      }
    }
  }

  public static void main (String[] args) {
    int[] num1 = { 0, 1, 0, 3, 12 };

    LC0283MoveZeroes solution = new LC0283MoveZeroes();
    solution.moveZeroes(num1);
    System.out.println(Arrays.toString(num1));
  }
}
