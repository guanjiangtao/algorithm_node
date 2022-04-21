import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
           int value1 = map.get(s.charAt(i));
           // 如果下一个比前一个大，则当前这个为负的，反之为正
           if (i + 1 < s.length() && value1 < map.get(s.charAt(i + 1))) {
               val-=value1;
           } else {
               val+=value1;
           }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
