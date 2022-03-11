package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int toValue = target - nums[i];
            if (map.containsKey(toValue) && map.get(toValue) != i) {
                return new int[]{map.get(toValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-3, 4, 3, 90}, 0)));
    }
}
