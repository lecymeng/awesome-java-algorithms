package Sorts;

import java.util.Arrays;

/**
 * @author weicools@date 2018/3/12
 *
 * desc: 选择排序
 */
public class SelectSort {
  public static void main (String[] args) {
    int[] num = { 3, 2, 6, 8, 4, 5, 9 };
    SelectSort ss = new SelectSort();
    ss.selectSort(num);
    System.out.println(Arrays.toString(num));
  }

  /**
   * 基本思想：
   * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
   * 然后在剩下的数当中再找最小的与第二个位置的数交换，
   * 如此循环到倒数第二个数和最后一个数比较为止
   *
   * 时间复杂度O(n*n) 性能上优于冒泡排序 交换次数少
   */
  private void selectSort (int[] num) {
    int temp;
    int size = num.length;
    for (int i = 0; i < size; i++) {
      //待确定的位置
      int k = i;
      //选择出应该在第i个位置的数
      for (int j = size - 1; j > i; j--) {
        if (num[j] < num[k]) {
          k = j;
        }
      }

      //交换两个数
      temp = num[i];
      num[i] = num[k];
      num[k] = temp;
    }
  }
}
