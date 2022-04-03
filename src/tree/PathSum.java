package tree;

import java.util.*;

public class PathSum {
//    private List<List<Integer>> pathSum = new LinkedList<>();
//    private Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
//    /**
//     * 路径之和 2
//     * @param root
//     * @param targetSum
//     * @return
//     */
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return pathSum;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<Integer> queueSum = new LinkedList<>();
//        queue.offer(root);
//        queueSum.offer(root.val);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            Integer val = queueSum.poll();
//
//            if (node.left == null && node.right == null) {
//                if (val == targetSum) {
//                    getPath(node);
//                }
//            } else {
//                if (node.left != null) {
//                    map.put(node.left, node);
//                    queueSum.offer(val + node.left.val);
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    map.put(node.right, node);
//                    queueSum.offer(val + node.right.val);
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return pathSum;
//    }
//
//    public void getPath(TreeNode node) {
//        List<Integer> temp = new LinkedList<Integer>();
//        while (node != null) {
//            temp.add(node.val);
//            node = map.get(node);
//        }
//        Collections.reverse(temp);
//        pathSum.add(new LinkedList<Integer>(temp));
//    }

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }
}
