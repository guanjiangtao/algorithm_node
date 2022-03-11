package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int cur = 0;
        int len = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 是否包含当前key，如果包含，则拿出当前Key所在的index
            if (charMap.containsKey(s.charAt(i))) {
                // 这里的cur记录的是滑动窗口的游标位置，需要和数组的位置作区分，容易搞混。
                cur = Math.max(cur,charMap.get(s.charAt(i)) + 1);
            }
            charMap.put(s.charAt(i), i);
            // 同样这里i也是需要 + 1区分真实位置和数组位置
            len = Math.max(len, i - cur + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
