package swordoffer;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * link: https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class SO06MinNumberInRotateArray {
    /*
    分治
    复杂度：O(logN) + O(1)，其实空间复杂度不止 O(1)，
    因为分治使用了递归栈，用到了额外的空间，如果对空间有要求就不能用这种方法
    */
    public int minNumberInRotateArray1(int[] nums) {
        return minNumberInRotateArray(nums, 0, nums.length - 1);
    }

    private int minNumberInRotateArray(int[] nums, int first, int last) {
        if (nums[first] < nums[last]) return nums[first];
        if (first == last) return nums[first];
        int mid = first + (last - first) / 2;
        return Math.min(minNumberInRotateArray(nums, first, mid), minNumberInRotateArray(nums, mid + 1, last));
    }

    /*
    二分查找
    复杂度：O(logN) + O(1)
    */
    public int minNumberInRotateArray2(int[] nums) {
        if (nums.length == 0) return 0;
        int l = 0, h = nums.length - 1;
        while (nums[l] >= nums[h]) {
            if (h - l == 1) return nums[h];
            int mid = l + (h - l) / 2;
            if (nums[mid] >= nums[l]) l = mid;
            else h = mid;
        }
        return nums[l];
    }
}
