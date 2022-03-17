package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        Map<Double, Integer> map = new HashMap<>();
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double min = Math.abs(root.val - target);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            map.put(Math.abs(node.val - target), node.val);
            if (min >= Math.abs(node.val - target)) {
                min = Math.abs(node.val - target);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return map.get(min) != null ? map.get(min) : 0;
    }

    private Double min;
    public int closestValue1(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        Map<Double, Integer> map = new HashMap<>();
        min = Math.abs(root.val - target);
        helper(root, target, map);
        return map.get(min) != null ? map.get(min) : 0;
    }

    public void  helper(TreeNode root, double target, Map<Double, Integer> map) {
        if (root != null) {
            map.put(Math.abs(root.val - target), root.val);
            if (min >= Math.abs(root.val - target)) {
                min = Math.abs(root.val - target);
            }
            helper(root.left, target, map);
            helper(root.right, target, map);
        }
    }
}
