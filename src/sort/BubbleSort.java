package sort;

import java.util.Arrays;

/**
 * Created by weicools on 2018/03/2018/3/12.
 * <p>
 * desc: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {3, 2, 6, 8, 4, 5, 9};
        System.out.println(Arrays.toString(num));
        bubbleSort(num);
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     * 针对所有的元素重复以上的步骤，除了最后一个
     * @param num 需要排序的整型数组
     */
    private static void bubbleSort(int[] num) {
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

        System.out.println(Arrays.toString(num));
    }
}
