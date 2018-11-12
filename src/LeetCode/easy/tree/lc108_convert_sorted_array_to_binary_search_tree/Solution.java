package LeetCode.easy.tree.lc108_convert_sorted_array_to_binary_search_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.13
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * desc: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * tag: 树、深度优先搜索
 */
class Solution {
  /**
   * 二叉搜索树具有以下性质：
   * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
   * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
   * 任意节点的左、右子树也分别为二叉查找树；
   * 没有键值相等的节点。
   *
   * 所以我们可以用递归来构建一棵二叉搜索树，
   * 每次把数组分为两半，把数组中间的值作为其父节点，
   * 然后把数组的左右两部分继续构造其左右子树。
   */
  public TreeNode sortedArrayToBST (int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return toBSTHelper(nums, 0, nums.length - 1);
  }

  private TreeNode toBSTHelper (int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) >> 1;
    TreeNode treeNode = new TreeNode(nums[mid]);
    treeNode.left = toBSTHelper(nums, left, mid - 1);
    treeNode.right = toBSTHelper(nums, mid + 1, right);
    return treeNode;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[] num = { -10, -3, 0, 5, 9 };
    TreeNode res = s.sortedArrayToBST(num);
    System.out.println(res);
  }
}
