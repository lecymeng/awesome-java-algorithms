package LeetCode.easy.tree.lc111_min_depth_of_binary_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.13
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * desc: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 * tag: 树、深度优先搜索、广度优先搜索
 */
class Solution {
  public int minDepth (TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lD = minDepth(root.left);
    int rD = minDepth(root.right);
    if (lD != 0 && rD != 0) {
      return 1 + Math.min(lD, rD);
    }
    return lD + rD + 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);
    System.out.println(s.minDepth(treeNode));
  }
}
