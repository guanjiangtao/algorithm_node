package Array;

import javax.crypto.MacSpi;
import java.util.*;

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

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
//       merge(new int[][]{{1,4},{1, 4}});
    }
}
