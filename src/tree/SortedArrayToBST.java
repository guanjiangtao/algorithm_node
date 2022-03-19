package tree;

// todo
public class SortedArrayToBST {
    /**
     * leetcode https://leetcode-cn.com/problems/minimum-height-tree-lcci/
     * 面试题 04.02. 最小高度树 and 108. 将有序数组转换为二叉搜索树
     * 题目要求，是高度最小的，那么我们尽可能要二叉树的每一层都是满的，这一排列出来的二叉树才会是最小的。
     * 题目是有序的，所以，最快的方案就是每次取中位数，这样就能还原一个平衡的二叉树，且层次最小。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(0, nums.length - 1, nums);
    }

    public TreeNode createTree(int start, int end, int[] nums) {
        if (end < start) {
            return null;
        }
        // 每次取中位数，即可，因为as well know 平衡二叉树的中序遍历，一定是一个从大到小的有序数组
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left= createTree(start, mid - 1, nums);
        node.right = createTree(mid + 1 , end, nums);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}
