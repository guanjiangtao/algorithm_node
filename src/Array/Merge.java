package Array;

import java.util.Arrays;

public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] sorted = new int[m + n];
        // 时间 and 空间 O(m + n)
        while (i < m || j < n) {
            if (i == m) {
                k = nums2[j++];
            } else if (j == n) {
                k = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                k = nums1[i++];
            } else {
                k = nums2[j++];
            }
            sorted[i + j - 1] = k;
        }
        System.arraycopy(sorted, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
