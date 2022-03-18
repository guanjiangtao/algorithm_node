package tree;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        // 1.中序遍历，
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        // 2.拿到值
        return list.get(list.size() - k);
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }
}
