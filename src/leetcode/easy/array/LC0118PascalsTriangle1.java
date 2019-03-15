package leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Weicools Create on 2018.11.13
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * desc: https://leetcode-cn.com/problems/pascals-triangle/description/
 * tag: 数组
 */
class LC0118PascalsTriangle1 {
  public List<List<Integer>> generate (int numRows) {
    if (numRows == 0) {
      return Collections.emptyList();
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> sub = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          sub.add(1);
        } else {
          List<Integer> upSub = res.get(i - 1);
          sub.add(upSub.get(j - 1) + upSub.get(j));
        }
      }
      res.add(sub);
    }

    return res;
  }

  public static void main (String[] args) {
    LC0118PascalsTriangle1 s = new LC0118PascalsTriangle1();
    System.out.println(Arrays.toString(s.generate(4).toArray()));
    System.out.println(Arrays.toString(s.generate(5).toArray()));
  }
}
