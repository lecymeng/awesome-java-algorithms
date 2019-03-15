package sort;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.11.13
 *
 * desc: 插入排序
 */
class InsertSort {
  /**
   * 基本思想：
   * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的
   * 合适位置（从后向前找到合适位置后），直到全部插入排序完为止
   *
   * 时间复杂度O(n*n) 性能上优于冒泡排序和选择排序
   */
  public void insertSort (int[] num) {
    int size = num.length;
    int temp, j;
    for (int i = 1; i < size; i++) {
      temp = num[i];
      // 假如temp比前面的值小，则将前面的值后移
      for (j = i; j > 0 && temp < num[j - 1]; j--) {
        num[j] = num[j - 1];
      }
      num[j] = temp;
    }
  }

  public static void main (String[] args) {
    InsertSort is = new InsertSort();
    int[] num = { 2, 1, 3, 7, 6, 5 };
    is.insertSort(num);
    System.out.println(Arrays.toString(num));
  }
}
