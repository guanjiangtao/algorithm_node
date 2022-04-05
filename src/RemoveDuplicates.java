import BaseDataStruct.sort.Utils;

import java.util.Arrays;
// *
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            // 快慢指针，如果不相同，则快指针前移
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(RemoveDuplicates.removeDuplicates(new int[]{1, 1, 2}));
    }
}
