package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    // 堆栈版本待更新
    public List<Integer> inorderWithStack(TreeNode root) {

        return new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
