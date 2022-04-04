import java.util.Arrays;

public class NumArray {

    private int[] numArr;
    private int[] buket;
    private int update;

    public NumArray(int[] nums) {
        numArr = nums;
    }

    public void update(int index, int val) {
        if (index < numArr.length) {
            numArr[index] = val;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numArr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(10));
    }
}
