package Array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder str = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            str.append(nums[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
    }


}
