package LeetCode.String.RotateString;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc: 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * Given `"abcdefg"`.
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * <p>
 * Challenge：Rotate in-place with O(1) extra memory.
 */
public class Solution {
    /*
    常见的翻转法应用题，仔细观察规律可知翻转的分割点在从数组末尾数起的offset位置。
    先翻转前半部分，随后翻转后半部分，最后整体翻转
    */

    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] a, int offset) {
        if (a == null || a.length == 0) {
            return a;
        }

        int len = a.length;
        offset %= len;

        reverse(a, 0, len - 1 - offset);
        reverse(a, len - offset, len - 1);
        reverse(a, 0, len - 1);

        return a;
    }

    private void reverse(char[] c, int start, int end) {
        char temp;
        while (start < end) {
            temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";

        Solution solution = new Solution();
        char[] result = solution.rotateString(s.toCharArray(), 3);

        System.out.println(result);
    }
}
