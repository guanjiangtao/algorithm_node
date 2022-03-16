public class CountOdds {

    // 1.正儿八经累加（bad solution）
    public int countOdds(int low, int high) {
        if (low % 2 == 1 && low == high ) {
            return 1;
        }
        if (low % 2 == 0 && low == high ) {
            return 0;
        }
        int count = 0, current = 0;
        // 奇数
        if (low % 2 == 1 && high % 2 == 1) {
            current = low;
            count = 1; // 初始(low是奇数)
            while (current < high) {
                current +=2;
                count++;
            }

        } else if (low % 2 == 0 && high % 2 == 1) {
            current = low + 1; // 开始
            count = 1; // 初始
            while (current < high) {
                current +=2;
                count++;
            }
        } else if (low % 2 == 1 && high % 2 == 0) {
            current = low; // 开始
            count = 1; // 初始
            while (current < high) {
                current +=2;
                if (current > high) {
                    break;
                }
                count++;
            }
        } else {
            current = low + 1; // 开始
            count = 1; // 初始
            while (current < high) {
                current +=2;
                if (current > high) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    // 2.较好（Good solution）
    public int countOdds1(int low, int high) {
        int sum = 0;
        if(low%2==0 && high%2==0)
        {
            sum = (high - low)/2;
            return sum;
        }
        sum = (high - low)/2 + 1;
        return sum;
    }

    public static void main(String[] args) {
        CountOdds countOdds = new CountOdds();
        int res = countOdds.countOdds(3, 7);
        int res1 = countOdds.countOdds(4, 7);
        int res2 = countOdds.countOdds(3, 6);
        int res3 = countOdds.countOdds(4, 6);
        int res4 = countOdds.countOdds(2, 2);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}
