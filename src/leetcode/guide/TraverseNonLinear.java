package leetcode.guide;

/**
 * @author weicools
 */
public class TraverseNonLinear {
    /**
     * 基本的单链表节点
     */
    private static class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 链表遍历框架，兼具迭代和递归结构：
     * 迭代方式
     */
    public void traverseNode(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代访问 p.val
            System.out.println(p.val);
        }
    }

    /**
     * 递归方式
     */
    public void traverseNode2(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        // 递归访问 head.val
        traverseNode2(head.next);
    }

    /**
     * 基本的二叉树节点
     */
    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    /**
     * 二叉树遍历框架，典型的非线性递归遍历结构：
     */
    void traverseTree(TreeNode root) {
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    /**
     * 基本的 N 叉树节点
     */
    private static class TreeNodes {
        int val;
        TreeNodes[] children;
    }

    /**
     * N 叉树遍历框架，典型的非线性递归遍历结构：
     * N 叉树的遍历又可以扩展为图的遍历，因为图就是好几 N 叉棵树的结合体。
     * 你说图是可能出现环的？这个很好办，用个布尔数组 visited 做标记就行了
     */
    void traverseTrees(TreeNodes root) {
        System.out.println(root.val);
        for (TreeNodes child : root.children) {
            traverseTrees(child);
        }
    }
}
