package tree;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepthLeft(TreeNode root) {
        if (root == null){
            return 0;
        }
        return maxDepthLeft(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepthLeft(treeNode));
    }
}
