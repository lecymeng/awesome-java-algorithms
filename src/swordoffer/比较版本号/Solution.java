package swordoffer.比较版本号;

/**
 * @author Weicools Create on 2018.09.18
 *
 * desc: 小年糕开发笔试https://jinshuju.net/f/fQfQEN
 * 实现一个比较任意两个软件版本号大小的函数，如 1.2.3a 和 1.2.4b 比较，后者版本号更大，请考虑各种情况，不可以使用系统提供的比较函数
 */
class Solution {
  public static void main (String[] args) {
    Solution m = new Solution();
    System.out.println(m.compareVersion("1.2.3a", "1.2.3b"));
  }

  public int compareVersion (String v1, String v2) {
    String[] v1Array = v1.split("\\.");
    String[] v2Array = v2.split("\\.");
    int v1Length = v1Array.length;
    int v2Length = v2Array.length;
    if (v1Length > v2Length) {
      return 1;
    } else if (v1Length < v2Length) {
      return -1;
    }

    for (int i = 0; i < v1Length; i++) {
      if (v1Array[i].length() > v2Array[i].length()) {
        return 1;
      } else if (v1Array[i].length() < v2Array[i].length()) {
        return -1;
      }

      int val1 = 0, val2 = 0;
      try {
        val1 = Integer.parseInt(v1Array[i]);
        val2 = Integer.parseInt(v2Array[i]);
      } catch (NumberFormatException e) {
        char[] chars1 = v1Array[i].toCharArray();
        char[] chars2 = v2Array[i].toCharArray();
        for (int j = 0; j < chars1.length; j++) {
          val1 += chars1[j];
          val2 += chars2[j];
        }
      }

      if (val1 > val2) {
        return 1;
      } else if (val1 < val2) {
        return -1;
      }
    }

    return 0;
  }
}
