package Search;

/**
 * Created by weicools on 2018/3/22.
 * <p>
 * desc: 分块查找
 */
public class BlockSearch {
    public static void main(String[] args) {
        int[] st = {3, 1, 5, 8, 6, 9, 14, 26, 12};
        int[] index = {5, 9, 26};
        System.out.println(blockSearch(index, st, 8, 3));
        System.out.println(blockSearch(index, st, 9, 3));
        System.out.println(blockSearch(index, st, 14, 3));
        System.out.println(blockSearch(index, st, 12, 3));
    }

    /**
     * 分块查找：
     * 前提:在每一块中数据元素的存放是任意的，但块与块之间必须是有序的
     * 例如:第一块所有元素比第二块的最小值要小……
     * 建立一个索引表，把每块中最大的关键字值按块的顺序存放在一个辅助数组中，这个索引表也按升序排列
     *
     * @param index       索引表
     * @param st          查找的数组
     * @param searchValue 待查找的值
     * @param m           块大小或者长度
     * @return 待查找值对应的索引
     */
    private static int blockSearch(int[] index, int[] st, int searchValue, int m) {
        // 先查找searchValue所在的块
        int i = -1;
        for (int j = 0; j < index.length; j++) {
            if (searchValue <= index[j]) {
                i = j;
                break;
            }
        }

        // 遍历对应的块，找出searchValue对应的索引
        if (i >= 0) {
            int j = (i > 0) ? m * i : i;
            int len = m * (i + 1);

            // 在确定的块中用顺序查找方法查找searchValue
            for (int k = j; k < len; k++) {
                if (searchValue == st[k]) {
                    System.out.print(searchValue + "所在位置：");
                    return k;
                }
            }
        }

        System.out.println("查找失败");
        return -1;
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
