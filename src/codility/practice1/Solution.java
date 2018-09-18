package codility.practice1;

import java.util.Arrays;

/**
 * Created by Weicools on 2018/4/28.
 * <p>
 * desc:
 */
public class Solution {
  public int getPeriod (int n) {
    int[] d = new int[32];//根据题目数字范围
    int l = 0;
    int p;
    while (n > 0) {
      d[l] = n % 2;
      n /= 2;
      l++;
    }

    System.out.println(Arrays.toString(d) + ", " + "BinaryLength: " + l);

    for (p = 1; p <= l / 2; ++p) {// p < l + 1
      int i;
      boolean ok = true;
      for (i = 0; i < l - p; ++i) {
        if (d[i] != d[i + p]) {
          ok = false;
          break;
        }
      }
      if (ok) {
        return p;
      }
    }
    return -1;
  }

  public static void main (String[] args) {
    Solution solution = new Solution();
    System.out.println("955 Binary Period: " + solution.getPeriod(955));
    System.out.println("120 Binary Period: " + solution.getPeriod(120));
    System.out.println("119 Binary Period: " + solution.getPeriod(119));
    System.out.println("36 Binary Period: " + solution.getPeriod(36));
    System.out.println("10 Binary Period: " + solution.getPeriod(10));
  }
}
