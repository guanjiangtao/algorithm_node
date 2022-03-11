package binarysearch;

/**
 * 找到错误的版本
 */
public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) { // 循环直至区间左右端点相同
            int mid = start + (end - start) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                start = mid; // 答案在区间 [left, mid] 中
            } else {
                end = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return start;
    }

    public static boolean isBadVersion(int version) {
        return version == 1;
    }
}
