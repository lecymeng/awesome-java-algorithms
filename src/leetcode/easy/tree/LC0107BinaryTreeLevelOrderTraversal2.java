package leetcode.easy.tree;

import leetcode.easy.tree.data.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Weicools Create on 2018.11.12
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *  3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回其自底向上的层次遍历为：
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 * desc: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 * tag: 树、广度优先搜索
 */
class LC0107BinaryTreeLevelOrderTraversal2 {
  public List<List<Integer>> levelOrderBottom (TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<TreeNode> nodeList = new LinkedList<>();
    nodeList.add(root);
    while (!nodeList.isEmpty()) {
      int size = nodeList.size();
      List<Integer> sub = new LinkedList();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodeList.remove();
        sub.add(node.val);
        if (node.left != null) {
          nodeList.add(node.left);
        }
        if (node.right != null) {
          nodeList.add(node.right);
        }
      }

      result.add(0, sub);
    }

    return result;
  }

  public static void main (String[] args) {
    LC0107BinaryTreeLevelOrderTraversal2 s = new LC0107BinaryTreeLevelOrderTraversal2();
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);

    List<List<Integer>> res = s.levelOrderBottom(treeNode);
    System.out.println(Arrays.toString(res.toArray()));
  }
}
