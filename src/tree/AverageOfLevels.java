package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles = new ArrayList<>();
        if (root == null) {
            return doubles;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        doubles.add((double) root.val);
        while (!queue.isEmpty()) {
            double count = 0;
            int i = 0;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    count += node.left.val;
                    i += 1;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    count += node.right.val;
                    i += 1;
                }
            }
            if (i != 0) {
                doubles.add(count / i);
            }
        }
        return doubles;
    }

    public static void main(String[] args) {
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(averageOfLevels.averageOfLevels(treeNode));
    }
}
