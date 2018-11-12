package LeetCode.easy.tree.lc104_max_depth_of_binary_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.13
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 *
 * desc: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 * tag: 树、深度优先搜索
 */
class Solution {
  public int maxDepth (TreeNode root) {
    if (root == null) {
      return 0;
    }
    int ld = maxDepth(root.left);
    int rd = maxDepth(root.right);
    return Math.max(ld, rd) + 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);
    System.out.println(s.maxDepth(treeNode));
  }
}
