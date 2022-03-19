package tree;

import java.util.*;

// 中序遍历
public class FindMode {
    private Integer base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();


    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> values = map.values().stream().sorted().toList();
        System.out.println(values);
        List<Integer> res = new LinkedList<>();
        map.forEach((k, v) -> {
            System.out.println(v);
            System.out.println(k);
            if (v == values.get(values.size() - 1)) {
                res.add(k);
            }
        });
        Object[] objects = res.toArray();
        int[] arr = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            arr[i] = (int) objects[i];
        }
        return arr;
    }

    public void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            helper(root.left, map);
            int val = root.val;
            if (map.containsKey(val)) {
                int values = map.get(val) + 1;
                map.put(val, values);
            } else {
                map.put(val, 1);
            }
            helper(root.right, map);
        }
    }

    public int[] findMode1(TreeNode root) {
        helper(root);
        int[] model = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            model[i] = answer.get(i);
        }
        return model;
    }

    public void  helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            update(root.val);
            helper(root.right);
        }
    }

    public void update(int x) {
        // 如何和缓存记录的数相同，则+1
        if (base == x) {
            ++count;
            // 如果不同，则给值
        } else {
            base = x;
            count = 1;
        }
        // 记录相同频次的数
        if (count == maxCount) {
            answer.add(base);
        }
        // 如果当前总数，超过了已知总数，则reset maxCount 重新来。
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
