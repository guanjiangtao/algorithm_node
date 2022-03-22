package tree;

public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        check(root, buffer);
        return Integer.parseInt(buffer.toString());
    }


    public void check(TreeNode node, StringBuffer stringBuffer) {
        if (node == null) {
            return;
        }
        if(node.left == null && node.right == null ){
            stringBuffer.append(node.val);
            return;
        }
        check(node.left, stringBuffer);
        check(node.right, stringBuffer);
    }
}
