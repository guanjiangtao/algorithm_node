package tree;

public class Tree2str_待处理 {
    private Integer preCount = 0;

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        preOrder(root, buffer);

        return buffer.deleteCharAt(buffer.length() - 1).append(")").toString();
    }

    public void preOrder(TreeNode node, StringBuffer buffer) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                buffer.append(node.val);
                for (int i = 0; i < preCount; i++) {
                    buffer.append(")");
                }
                buffer.append("(");
                preCount = 0;
            } else {
                buffer.append(node.val).append("(");
                preCount += 1;
            }
            preOrder(node.left, buffer);
            preOrder(node.right, buffer);
        }
    }
}
