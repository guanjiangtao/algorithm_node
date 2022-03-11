package slidingwindow;

import java.util.Arrays;

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        // 如果前n个满足条件。
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        /**
         * // 具体滑动窗口的逻辑
         * 1 1 1 0 0 0 0 0
         * 目标位置：0 0 0 1 1 1 0
         * 第一轮滑动：0 1 1 1 0 0 0
         * 第二轮滑动：0 0 1 1 1 0 0
         * 第三轮滑动：0 0 0 1 1 1 1
         * 满足条件：break
         */
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("def", "abcdefg"));
    }

}
