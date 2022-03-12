package tree;

import java.util.LinkedList;
import java.util.List;

public class Postorder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 每次递归时，先递归访问每个孩子节点，然后再访问根节点即可。
        for (Node node : root.children) {
            helper(node, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        List<Node> nodes = new LinkedList<>();
        Node node = new Node(3);
        List<Node> nodes1 = new LinkedList<>();
        node.children = nodes1;
        nodes1.add(new Node(5));
        nodes1.add(new Node(6));
        nodes.add(node);
        nodes.add(new Node(2));
        nodes.add(new Node(4));
        root.children = nodes;
        Postorder postorder = new Postorder();
        postorder.postorder(root);
    }
}
