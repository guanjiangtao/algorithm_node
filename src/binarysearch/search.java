package binarysearch;

public class search {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            int num = nums[index];
            if (num == target) {
                return index;
            } else if (num > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
