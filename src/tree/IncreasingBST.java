package tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newNode = new TreeNode(-1);
        List<Integer> list = new ArrayList<>();
        check(root, list);

        TreeNode currNode = newNode;
        for (int value : list) {
            // 给当前赋值
            currNode.right = new TreeNode(value);
            // 当前树，指向给right
            currNode = currNode.right;
        }
        return newNode.right;
    }

    public void check(TreeNode root, List<Integer> list) {
        if (root != null) {
            check(root.left, list);
            list.add(root.val);
            check(root.right, list);
        }
    }
}
