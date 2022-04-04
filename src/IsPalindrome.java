public class IsPalindrome {
    /**
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] x1 = String.valueOf(x).toCharArray();
        for (int i = 0; i < x1.length; i++) {
            if (x1[i] != x1[x1.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        // 如果x为负，则一定不是回文数
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        // 数字反转，个位数变十位数，十位数变个位数
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        System.out.println(IsPalindrome.isPalindrome1(121));
    }
}
