package hello.fucking.tree;

/**
 * @author weicools
 * @date 2021.04.27
 */
public class CalcTreeNodeCount {
    public static void main(String[] args) {
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
