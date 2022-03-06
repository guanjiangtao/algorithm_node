package day1;

public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] > target) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                end = index - 1;
            } else if (nums[index] < target) {
                start = index + 1;
            }
        }
        return  target <= nums[start] ? start : start + 1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3, 5, 6}, 2));
    }
}
