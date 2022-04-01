package tree;

import java.util.*;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int count = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<String> strings = new LinkedList<>();
            queue.offer(root);
            strings.offer(String.valueOf(root.val));
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String s = strings.poll();
                if (node.left != null) {
                    strings.offer(s +node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    strings.offer(s + node.right.val);
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    count += Integer.parseInt(s);
                }
            }
            return count;
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> strings = new LinkedList<>();
        queue.offer(root);
        strings.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int s = strings.poll();
            if (node.left == null && node.right == null) {
                count += s;
            } else {
                if (node.left != null) {
                    strings.offer(s * 10 +node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    strings.offer(s * 10 + node.right.val);
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}
