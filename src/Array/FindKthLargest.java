package Array;

import BaseDataStruct.sort.Utils;

import java.util.Arrays;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
//        int pos = nums.length - k;
        // 冒泡排序
//        for (int i = nums.length - 1; i >0 ; i--) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                   int temp = nums[j + 1];
//                   nums[j + 1] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//            if (i == pos) {
//                break;
//            }
//        }
// 选择排序
//        for (int i = 0; i < nums.length - 1; i++) {
//            int maxIndex = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                maxIndex = nums[maxIndex] < nums[j] ? j : maxIndex;
//            }
//            int param = nums[i];
//            nums[i] = nums[maxIndex];
//            nums[maxIndex] = param;
//            System.out.println(Arrays.toString(nums));
//            if (i == k - 1) {
//                break;
//            }
//        }
        // 拒绝花里胡哨
//        Arrays.sort(nums);
        return nums[k-1];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
