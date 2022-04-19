import java.util.*;

public class ShortestToChar {

    // s = "loveleetcode", c = "e"
    public static int[] shortestToChar(String s, char c) {
        // 获取字符的最短距离
        int[] nums = new int[s.length()];
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexs.add(i);
            }
        }
        int size = indexs.size();
        for (int i = 0; i < s.length(); i++) {
            int min = Math.abs(indexs.get(0) - i);
            for (int j = 1; j < size; j++) {
                int abs = Math.abs(indexs.get(j) - i);
                if (min > abs) {
                    min = abs;
                }
            }
            nums[i] = min;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
