package doublepoint;

import java.util.Arrays;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortedSquares s = new SortedSquares();
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, -3, -1, 0, 3, 4, 5})));
    }

}
