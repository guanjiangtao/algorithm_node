package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

    /**
     * 思路一：中序遍历，拿到从小到大排列，然后直接k-1一波拿出来
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = inOrder(root);
        return inOrder.get(k - 1);
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            helper(root, list);
            list.add(root.val);
            helper(root, list);
        }
    }



    public static void main(String[] args) {

    }
}
