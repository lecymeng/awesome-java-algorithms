package LeetCode.easy.数组.存在重复;

public class Solution {
    public boolean containsDuplicate(int[] nums) {

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums1));
        System.out.println(solution.containsDuplicate(nums2));
    }
}
