
// 接雨水 双指针(唯一)
public class MaxArea {

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i <= j;) {
            int area = Math.abs(j - i) * Math.min(height[j], height[i]);
            max = Math.max(area, max);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }
}
