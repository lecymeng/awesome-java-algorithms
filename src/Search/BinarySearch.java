package Search;

import java.util.Arrays;

/**
 * Created by weicools on 2018/3/22.
 * <p>
 * desc: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 6, 8, 9, 16};
        System.out.println("-----BinarySearch-----");
        System.out.println(Arrays.toString(num));
        System.out.println("查找2所在位置：" + binarySearch(2, num));
        System.out.println("查找4所在位置：" + binarySearch(4, num));
    }

    private static int binarySearch(int searchValue, int[] numArray) {
        int low = 0;
        int high = numArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchValue == numArray[middle]) {
                return middle;
            } else if (searchValue < numArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
