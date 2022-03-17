package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int val = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                // 这是重点，注意读题：返回所有左叶子之和。
                if (node.left.left == null && node.left.right == null) {
                    val+= node.left.val;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return val;
    }
}
