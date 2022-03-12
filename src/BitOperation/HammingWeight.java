package BitOperation;

public class HammingWeight {

    public int hammingWeight1(int n) {
        int ret = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                ret++;
            }
        }
        return ret;
    }

    /**
     * 位运算：& 01 & 01 = 1 1++;
     */
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret ++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight1(00000000000000000000000000001011));

        System.out.println(1 << 1);
    }
}
