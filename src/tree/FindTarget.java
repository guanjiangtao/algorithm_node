package tree;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {
    Set<Integer> sets = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (sets.contains(k - root.val)) {
            return true;
        }
        sets.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
