package BitOperation;

/**
 * 二次幂
 */
public class PowerOfTwo {
    // 原始做法
    public  static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    // 简单来说就是取余为0就行
    public  static boolean isPowerOfTwo2(int n) {
        return n > 0 && (1 << 30) % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
    }
}
