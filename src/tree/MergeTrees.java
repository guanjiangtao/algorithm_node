package tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

// todo
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            r1.val += r2.val;
            // 如果两边右侧都不为null，则塞两边
            if(r1.left!=null && r2.left!=null){
                queue.add(r1.left);
                queue.add(r2.left);
            }
            // 如果r1为空则赋值一下
            else if(r1.left==null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if(r1.right!=null && r2.right!=null) {
                queue.add(r1.right);
                queue.add(r2.right);
            }
            else if(r1.right==null) {
                r1.right = r2.right;
            }
        }
        return root1;
    }

    /**
     * 递归竟然非递归效率搞
     */
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees1(root1.left, root2.left);
        merged.right = mergeTrees1(root2.right, root2.right);

        return merged;
    }
}
