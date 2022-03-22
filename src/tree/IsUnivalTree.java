package tree;

import java.util.LinkedHashSet;
import java.util.Set;

public class IsUnivalTree {
    // 遍历 + set如果出现size大于1则代表不是单值
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> integers = new LinkedHashSet<>();
        check(root, integers);
        return integers.size() == 1;
    }

    public void check(TreeNode root, Set<Integer> integers) {
        if (root != null) {
            integers.add(root.val);
            check(root.left, integers);
            check(root.right, integers);
        }
    }
}
