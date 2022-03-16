package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    /**
     * 二叉树层次遍历模版
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            String path = queue1.poll();
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                list.add(path);
            }
            if (node.left != null) {
                queue.offer(node.left);
                queue1.offer(path + "->" + node.left.val);
            }

            if (node.right != null) {
                queue.offer(node.right);
                queue1.offer(path + "->" + node.right.val);
            }
        }
        return list;
    }
}
