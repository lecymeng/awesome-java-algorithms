package Sorts;

import java.util.Arrays;

/**
 * Created by weicools on 2018/3/12.
 * <p>
 * desc: 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] num = {3, 2, 6, 8, 4, 5, 9};
        System.out.println("------SelectSort-----");
        System.out.println(Arrays.toString(num));
        selectSort(num);
    }

    /**
     * 选择排序：
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
     *
     * @param numArray 待排序数组
     */
    private static void selectSort(int[] numArray) {
        int size = numArray.length;
        int temp;

        for (int i = 0; i < size; i++) {
            int k = i;  //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numArray[j] < numArray[k]) {
                    k = j;
                }
            }

            //交换两个数
            temp = numArray[i];
            numArray[i] = numArray[k];
            numArray[k] = temp;
        }

        System.out.println("---------------------");
        System.out.println(Arrays.toString(numArray));
    }
}
