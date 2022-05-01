import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String subStr = "";
        here:
        for (int i = 0; i < strs[0].length(); i++) {
            String temp = strs[0].substring(0,i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(temp)) {
                    break here;
                }
            }
            subStr = temp;
        }
        return subStr;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        here:
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    break here;
                }
                set.add(strs[j].charAt(i));
            }
            // 无重复
            if (set.size() == 1) {
                stringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }
            set.clear();
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix1(new String[]{"flower","flow","flight"}));
//        System.out.println(longestCommonPrefix1(new String[]{"cdog","cracecar","car"}));
        System.out.println(longestCommonPrefix1(new String[]{"ab","a"}));

    }
}
