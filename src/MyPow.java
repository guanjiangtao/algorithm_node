public class MyPow {
    // todo
    public static double myPow(double x, int n) {
        double v = x;
        if (n == 0 || x == 1) {
            return 1;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        System.out.println(n * -1);
        for (int i = 1; i < Math.abs(n); i++) {
            v *= x;
        }

        if (n < 0) {
            v = 1 / v;
        }
        return v;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(2, 10));
//        System.out.println(myPow(2.1, 3));
//        System.out.println(myPow(2.0, -3));
//        System.out.println(myPow(0.44528, 0));
//        System.out.println(myPow(-1, -2));
        System.out.println(myPow(2, -2147483648));
    }
}
