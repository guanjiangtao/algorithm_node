package tree;

import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 一层一层遍历
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
    // 空间换时间大师～
    // https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/submissions/
    public int[] levelOrder1(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        val.add(root.val);
        while (!queue.isEmpty()) {
            // 一层一层遍历
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                val.add(node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                val.add(node.right.val);
            }
        }
        int[] arr = new int[val.size()];
        Object[] ar = val.toArray();
        for (int i = 0; i < ar.length; i++) {
            arr[i] = (Integer)ar[i];
        }
        return arr;
    }
}
