package day2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MoveZeroes {
    public static void moveZeroes1(int[] nums) {
        IntStream str = Arrays.stream(nums).filter(num -> num != 0);
        int[] arr = str.toArray();
        for (int i = 0; i < nums.length; i++) {
            if (i < arr.length) {
                nums[i] = arr[i];
            } else {
                nums[i] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newNums[index++] = nums[i];
            }
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeroes3(new int[]{1});
    }
}
