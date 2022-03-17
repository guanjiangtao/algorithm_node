package tree;

import java.util.LinkedList;
import java.util.Queue;

// 层次遍历 嘎嘎乱杀（翻车。）
public class MaxPathSum_待处理 {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = root.val, max1 = 0, max2 = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(root.left);
                max1 += root.left.val + max;
            }
            if (node.right != null) {
                queue.offer(root.right);
                max2 += root.right.val + max;
            }
            max = Math.max(max1, max2);
        }
        return max;
    }
}
