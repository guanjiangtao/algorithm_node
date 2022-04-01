package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            count++;
        }
        return count;
    }


    public int countNodes1(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root != null) {
            int left = helper(root.left);
            int right = helper(root.right);
            return right + left + 1;
        }
        return 0;
    }
}
