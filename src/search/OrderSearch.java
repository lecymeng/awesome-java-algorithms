package search;

import java.util.Arrays;

/**
 * Created by weicools on 2018/3/22.
 * <p>
 * desc: 顺序查找
 */
public class OrderSearch {
    public static void main(String[] args) {
        int[] num = {3, 2, 6, 8, 4, 5, 9};
        System.out.println("-----OrderSearch-----");
        System.out.println(Arrays.toString(num));
        System.out.println("查找8所在位置：" + orderSearch(8, num));
        System.out.println("查找5所在位置：" + orderSearch(5, num));
    }

    /**
     * 二分查找
     *
     * @param searchValue 待查找的值
     * @param numArray    array
     * @return 查找结果
     */
    private static int orderSearch(int searchValue, int[] numArray) {
        if (numArray == null || numArray.length < 1) {
            return -1;
        }

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == searchValue) {
                return i;
            }
        }

        return -1;
    }
}
