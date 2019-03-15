package swordoffer.数组.数组中重复的数字;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是第一个重复的数字 2。
 * <p>
 * 要求复杂度为 O(N) + O(1)，时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 */
public class Solution {
    /*
    解题思路：
    这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上

    以 (2, 3, 1, 0, 2, 5) 为例：

    position-0 : (2,3,1,0,2,5) // 2 <-> 1
                 (1,3,2,0,2,5) // 1 <-> 3
                 (3,1,2,0,2,5) // 3 <-> 0
                 (0,1,2,3,2,5) // already in position
    position-1 : (0,1,2,3,2,5) // already in position
    position-2 : (0,1,2,3,2,5) // already in position
    position-3 : (0,1,2,3,2,5) // already in position
    position-4 : (0,1,2,3,2,5) // nums[i] == nums[nums[i]], exit
    遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复。

    复杂度：O(N) + O(1)
    */
    private boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (nums[i] != i && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }

            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                duplication[0] = nums[i];
                return true;
            }
        }

        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] dup = new int[10];

        Solution solution = new Solution();
        solution.duplicate(nums, 7, dup);

        System.out.println("" + dup[0]);
    }
}
