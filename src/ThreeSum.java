import java.util.*;

// *
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            // 第二个
            int L = i+1;
            // 末尾 - 1
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else R--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
