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
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            int node1Val = node1 != null ? node1.val : 0;
            int node2Val = node2 != null ? node2.val : 0;
            if (node1Val == 0) {
                node1 = new TreeNode(node1Val + node2Val);
            } else {
                node1.val = node1Val + node2Val;
            }
            System.out.println(node1.val);
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);
        }
        return root1;
    }
}
