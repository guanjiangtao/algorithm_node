package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    /**
     * 获取路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root, targetSum);
    }

    public boolean check(TreeNode root, int targetSum){
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return check(root.left, targetSum - root.val) && check(root.right, targetSum - root.val);
    }

    public boolean check1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer val = queue1.poll();
            if (node.left == null && node.right == null) {
                if (val == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                queue1.offer(node.left.val + val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queue1.offer(node.right.val + val);
            }
        }
        return false;
    }
}
