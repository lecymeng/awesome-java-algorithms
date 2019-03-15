package swordoffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import swordoffer.data.TreeNode;

/**
 * Created by Weicools on 2018/4/22.
 * <p>
 * desc: 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * preOrder = [3,9,20,15,7]
 * inOrder =  [9,3,15,20,7]
 *
 * link: https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class SO04ReConstructBinaryTree {
    /*
    前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
    左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
    */
    private Map<Integer, Integer> inOrderNumsIdx = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderNumsIdx.put(inOrder[i], i);
        }

        return reConstructBinaryTree(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL == preR) {
            System.out.println(preL + " " + pre[preL]);
            return new TreeNode(pre[preL]);
        }

        if (preL > preR || inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        int inIdx = inOrderNumsIdx.get(root.val);
        int leftTreeSize = inIdx - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in, inL + leftTreeSize + 1, inR);
        System.out.println(Arrays.toString(pre) + preL + " " + preR + " ");
        System.out.println(Arrays.toString(in) + inL + " " + inR + " ");
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        SO04ReConstructBinaryTree s = new SO04ReConstructBinaryTree();
        s.reConstructBinaryTree(preOrder, inOrder);
    }
}
