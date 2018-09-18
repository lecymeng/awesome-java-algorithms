package LeetCode.easy.数组.旋转数组;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * desc:
 */
public class Solution {
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
    Solution solution = new Solution();
    int[] num = { 1, 2, 3, 4, 5, 6, 7 };
    solution.rotate(num, 3);
    System.out.println(Arrays.toString(num));
  }
}
