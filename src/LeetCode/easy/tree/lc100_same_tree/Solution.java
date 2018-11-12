package LeetCode.easy.tree.lc100_same_tree;

import LeetCode.easy.tree.TreeNode;

/**
 * @author Weicools Create on 2018.11.12
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 * 输入:      1          1
 * /           \
 * 2             2
 *
 * [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 *
 * [1,2,1],   [1,1,2]
 * 输出: false
 *
 * desc: https://leetcode-cn.com/problems/same-tree/description/
 * tag: 树、深度优先搜索
 */
class Solution {
  public boolean isSameTree (TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }

    if (p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(1);

    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(2);
    q.right = new TreeNode(1);

    System.out.println(s.isSameTree(p, q));
  }
}
