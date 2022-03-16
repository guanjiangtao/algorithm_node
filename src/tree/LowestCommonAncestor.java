package tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = root;
        while (true) {
            // 根据二叉搜索树的特性，我们可以判断,如果p和q都小于treeNode
            if (p.val < treeNode.val && q.val < treeNode.val) {
                treeNode = treeNode.left;
                // 如果p和q都大于treeNode，则在右侧
            } else if (p.val > treeNode.val && q.val > treeNode.val) {
                treeNode = treeNode.right;
            } else {
                break;
            }
        }
        return treeNode;
    }
}
