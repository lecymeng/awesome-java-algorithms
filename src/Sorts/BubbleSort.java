package Sorts;

import java.util.Arrays;

/**
 * @author weicools @date 2018/3/12
 *
 * desc: 冒泡排序
 */
public class BubbleSort {
  public static void main (String[] args) {
    BubbleSort bs = new BubbleSort();
    int[] num = { 3, 2, 6, 8, 4, 5, 9 };
    bs.bubbleSort(num);
    System.out.println(Arrays.toString(num));
  }

  /**
   * 基本思想:
   * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
   * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
   * 在这一点，最后的元素应该会是最大的数
   * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
   * 针对所有的元素重复以上的步骤，除了最后一个
   *
   * > 加入标记状态 flag 若在一次冒泡中，没有交换 则说明可以停止 减少运行时
   *
   * 时间复杂度O(n*n)
   */
  private void bubbleSort (int[] num) {
    int temp;
    int size = num.length;
    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - 1 - i; j++) {
        if (num[j] > num[j + 1]) {
          temp = num[j];
          num[j] = num[j + 1];
          num[j + 1] = temp;
        }
      }
    }
  }
}
