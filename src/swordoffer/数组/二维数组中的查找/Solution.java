package swordoffer.数组.二维数组中的查找;

import java.util.Arrays;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */

/*
Consider the following matrix:
[
    [1, 4, 7, 11, 15],
    [2, 5, 8, 12, 19],
    [3, 6, 9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
]

Given target = 5, return true.
Given target = 20, return false.
*/

public class Solution {
    /*
    解题思路
    从右上角开始查找。因为矩阵中的一个数，它左边的数都比它小，下边的数都比它大。
    因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。

    复杂度：O(M+N) + O(1)
    */
    private boolean findNum(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = n - 1;

        while (r <= m - 1 && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println("Given target = 5, result: " + solution.findNum(matrix, 5));
        System.out.println("Given target = 20, result: " + solution.findNum(matrix, 20));

        System.out.println(Arrays.toString(matrix[0]));
    }
}
