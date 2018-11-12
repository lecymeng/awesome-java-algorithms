package LeetCode.easy.tree.lc543_diameter_of_binary_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.13
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * desc: https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 * tag: 树
 */
class Solution {
  private int max;

  /**
   * 分别计算左右子树的最大高度，
   * 然后不断迭代出其和的最大值就是最终结果
   */
  public int diameterOfBinaryTree (TreeNode root) {
    diameterHelper(root);
    return max;
  }

  private int diameterHelper (TreeNode node) {
    if (node == null) {
      return 0;
    }
    int l = diameterHelper(node.left);
    int r = diameterHelper(node.right);
    if (l + r > max) {
      max = l + r;
    }

    return Math.max(l, r) + 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(3);
    treeNode.left.left = new TreeNode(4);
    treeNode.left.right = new TreeNode(5);

    System.out.println(s.diameterHelper(treeNode));
  }
}
