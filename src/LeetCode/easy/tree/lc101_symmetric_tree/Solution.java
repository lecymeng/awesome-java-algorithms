package LeetCode.easy.tree.lc101_symmetric_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.12
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明: 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * desc: https://leetcode-cn.com/problems/symmetric-tree/description/
 * tag: 树、深度优先搜索、广度优先搜索
 */
class Solution {
  /**
   * 首先是深搜，比较根结点的左右两棵子树是否对称，
   * 如果左右子树的值相同，那么再分别对左子树的左节点和右子树的右节点，
   * 左子树的右节点和右子树的左节点做比较即可。
   */
  public boolean isSymmetric (TreeNode root) {
    return root == null || isSymmetricHelper(root.left, root.right);
  }

  private boolean isSymmetricHelper (TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return left == right;
    }

    if (left.val != right.val) {
      return false;
    }
    return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
