package LeetCode.easy.数组.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * https://leetcode.com/problems/two-sum/solution/
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */
public class Solution {
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum2(nums, 9)));
    }
}
