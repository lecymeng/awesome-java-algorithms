package codility.practice3;

/**
 * Created by Weicools on 2018/4/27.
 * <p>
 * desc:
 */
public class Solution {
  public int solution (int[] A) {
    int len = A.length;
    int[] result = new int[2];
    result[0] = result[1] = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      if (A[i] + i > result[0]) {
        result[0] = A[i] + i;
      }
    }

    for (int j = 0; j < len; j++) {
      if (A[j] - j > result[1]) {
        result[1] = A[j] - j;
      }
    }

    return result[0] + result[1];
  }

  public int solution1 (int[] A) {
    int maxValue = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        if (A[i] + A[j] + (i - j) > maxValue) {
          maxValue = A[i] + A[j] + (i - j);
        }
      }
    }

    return maxValue;
  }

  public static void main (String[] args) {
    Solution solution = new Solution();
    int[] nums = { 1, 3, -3 };
    int[] test1 = { 2, 4, 2, 6, 7 };
    System.out.println(solution.solution(nums));
    System.out.println(solution.solution(test1));
    System.out.println(solution.solution1(test1));
  }
}
