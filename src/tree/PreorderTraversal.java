package tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        check(root, list);
        return list;
    }

    public  void check(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        check(root.left, list);
        check(root.right, list);
        list.add(root.val);
    }
}
