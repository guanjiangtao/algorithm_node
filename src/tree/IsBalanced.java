package tree;

/**
 * 思路
 * 递归检查二叉树高度
 * 每一层高度需要
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return false;
        }

        return Math.abs(height1(root.left) - height1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height1(root.left);
        int right = height1(root.right);

        return Math.max(left, right) + 1;
    }
}
