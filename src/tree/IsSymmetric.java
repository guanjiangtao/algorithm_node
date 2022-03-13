package tree;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && check(node1.right, node2.left) && check(node2.right, node1.left);
    }
}
