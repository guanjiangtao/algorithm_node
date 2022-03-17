package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchBST {
    /**
     * 二叉搜索树
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.val == val) {
                return treeNode;
            }
            // 待确认的值大于当前节点则返回右子树，
            if (treeNode.val < val && treeNode.right != null) {
                queue.offer(treeNode.right);
            } else if (treeNode.val > val && treeNode.left != null) {
                queue.offer(treeNode.left);
            }
        }
        return null;
    }
}
