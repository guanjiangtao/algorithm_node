package tree;

import java.util.*;

public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new LinkedHashSet<>();
        helper(root, set);
        List<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        if (arr.size() >= 2) {
            return arr.get(1);
        }
        return -1;
    }

    public void helper(TreeNode treeNode, Set<Integer> set) {
        if (treeNode != null) {
            helper(treeNode.left, set);
            set.add(treeNode.val);
            helper(treeNode.right, set);
        }
    }
}
