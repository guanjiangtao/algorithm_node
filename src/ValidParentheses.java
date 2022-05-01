import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new LinkedHashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Deque<Character> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                if (characters.isEmpty() || characters.peek() != map.get(charAt)) {
                    return false;
                }
                characters.pop();
            } else {
                characters.push(s.charAt(i));
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        // 第一步：{ 进栈
        // 第二步：( 进栈
        // 第三步：[ 进栈
        // 第四步：] 发现存在于预设的map中，于是弹出前一个对比是否满足，如果满足就直接next，如果不满足直接return false
        System.out.println(isValid("{([]}]"));
    }

}
