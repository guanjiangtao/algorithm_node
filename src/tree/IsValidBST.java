package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() == 1 || list.size() == 0) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    // 中序遍历
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node, list);
            list.add(node.val);
            inOrder(node, list);
        }
    }
}
