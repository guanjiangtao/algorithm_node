package doublepoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            maps.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            int res = target - numbers[i];
            if (maps.get(res) == null) {
                continue;
            }
            int index = maps.get(res);
            if (index != i) {
                return new int[]{index, i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{5, 25, 75}, 100)));
    }
}
