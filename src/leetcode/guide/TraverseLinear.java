package leetcode.guide;

/**
 * @author weicools
 */
public class TraverseLinear {

    /**
     * 数组遍历框架，典型的线性迭代结构：
     */
    public void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 迭代访问 arr[i]
            System.out.println(arr[i]);
        }
    }

}
