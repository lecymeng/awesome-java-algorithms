package leetcode.easy.tree;

import leetcode.easy.tree.data.TreeNode;

/**
 * @author Weicools Create on 2018.11.13
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false
 *
 * desc: https://leetcode-cn.com/problems/balanced-binary-tree/description/
 * tag: 树、深度优先搜索
 */
class LC0110BalancedBinaryTree {
  /**
   * 计算左右子树的高度，判断其高度差是否不超过 1 即可，
   * 如果超过 1，就代表其不是高度平衡的，立即返回不是即可，
   * 这里用返回 -1 代表不是
   */
  public boolean isBalanced (TreeNode root) {
    return isBalancedHelper(root) != -1;
  }

  private int isBalancedHelper (TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = isBalancedHelper(root.left);
    if (l == -1) {
      return -1;
    }
    int r = isBalancedHelper(root.right);
    if (r == -1) {
      return -1;
    }

    if (Math.abs(l - r) > 1) {
      return -1;
    }

    return 1 + Math.max(l, r);
  }
}
