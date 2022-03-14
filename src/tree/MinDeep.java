package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDeep {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    public class QueueNode {

        private TreeNode node;

        private int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }

    public int minDepth1(TreeNode root) {
        Queue<QueueNode> queue = new LinkedList<>();
        int min = 0;
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode node1 = queueNode.getNode();
            if (node1.right == null && node1.left == null) {
                return queueNode.depth;
            }

            if (node1.right != null) {
               queue.offer(new QueueNode(node1.right, queueNode.depth + 1));
            }
            if (node1.left != null) {
                queue.offer(new QueueNode(node1.left, queueNode.depth + 1));
            }
        }
        return 0;
    }
}
