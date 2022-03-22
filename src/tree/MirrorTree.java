package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.poll();
            TreeNode right = root.right;
            treeNode.right = treeNode.left;
            treeNode.left = right;
            if (treeNode.left != null) {
                treeNodes.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodes.offer(treeNode.right);
            }
        }
        return root;
    }
}
