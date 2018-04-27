package LeetCode.easy.数组.从排序数组中删除重复项;

import java.util.Arrays;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int temp = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[temp]) {
                temp++;
                nums[temp] = nums[i];
            }
        }

        return temp + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2,2,3,5,6,6};
        int s = solution.removeDuplicates(nums);
        System.out.println(s);
        System.out.println(Arrays.toString(nums));
    }
}
