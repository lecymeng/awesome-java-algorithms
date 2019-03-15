package sort;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.11.13
 *
 * desc: 希尔排序
 */
class ShellSort {
  /**
   * 基本思想：
   * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
   * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
   *
   * 希尔排序的原理:
   * 根据需求，如果你想要结果从小到大排列，它会首先将数组进行分组，
   * 然后将较小值移到前面，较大值移到后面，最后将整个数组进行插入排序，
   * 这样比起一开始就用插入排序减少了数据交换和移动的次数，
   *
   * 可以说希尔排序是加强版的插入排序 拿数组5, 2, 8, 9, 1, 3，4来说
   * 数组长度为7，当increment为3时，数组分为两个序列5，2，8和9，1，3，4，
   * 第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
   * 此例子是按照从小到大排列，所以小的会排在前面，第一次排序后数组为5, 1, 3, 4, 2, 8，9
   * 第一次后increment的值变为3/2=1,此时对数组进行插入排序， 实现数组从大到小排
   *
   * 时间复杂度O(n^1.5）
   */
  public void shellSort (int[] num) {
    int temp, j;
    int size = num.length;
    for (int increment = size; increment > 0; increment /= 2) {
      for (int i = increment; i < size; i++) {
        temp = num[i];
        for (j = i; j >= increment; j -= increment) {
          // 从小到大排
          if (temp < num[j - increment]) {
            num[j] = num[j - increment];
          } else {
            break;
          }
        }
        num[j] = temp;
      }
    }
  }

  public static void main (String[] args) {
    ShellSort ss = new ShellSort();
    int[] num = { 2, 1, 3, 7, 6, 5 };
    ss.shellSort(num);
    System.out.println(Arrays.toString(num));
  }
}
