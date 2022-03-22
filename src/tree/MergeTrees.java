package tree;

import java.util.LinkedList;
import java.util.Queue;

// todo
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        TreeNode newTreeNode = new TreeNode();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            newTreeNode.val = node1.val + node2.val;
            if (node1.left != null) {
                queue1.offer(node1.left);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
            }
            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (node2.right != null) {
                queue2.offer(node2.right);
            }
            if (node1.left == null || node1.right == null) {
                queue1.offer(new TreeNode(0));
            }
            if (node2.left == null || node2.right == null) {
                queue2.offer(new TreeNode(0));
            }
        }
        return root1;
    }
}
