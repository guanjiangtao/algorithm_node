package tree;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
    private Integer val = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        check(root, low, high);
        return val;
    }

    public void check(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                val+=root.val;
            }
            check(root.left, low, high);
            check(root.right, low, high);
        }
    }

    /**
     * 按深度优先搜索的顺序计算范围和。记当前子树根节点为 \textit{root}root，分以下四种情况讨论：
     *
     * \textit{root}root 节点为空
     *
     * 返回 00。
     *
     * \textit{root}root 节点的值大于 \textit{high}high
     *
     * 由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于 \textit{high}high，故无需考虑右子树，返回左子树的范围和。
     *
     * \textit{root}root 节点的值小于 \textit{low}low
     *
     * 由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于 \textit{low}low，故无需考虑左子树，返回右子树的范围和。
     *
     * \textit{root}root 节点的值在 [\textit{low},\textit{high}][low,high] 范围内
     *
     * 此时应返回 \textit{root}root 节点的值、左子树的范围和、右子树的范围和这三者之和。
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
