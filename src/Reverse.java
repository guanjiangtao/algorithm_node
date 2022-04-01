import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse {

    public static int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean isFu = x < 0;
        Stack<Integer> queue = new Stack<>();
        int temp = isFu ? Math.abs(x) : x;
        while (temp > 0) {
            queue.push((temp % 10));
            temp = temp / 10;
        }
        int i = 0;
        long count = 0;
        while (!queue.isEmpty()) {
            count += queue.pop() * Math.pow(10, i++);
        }
        if (count > max || -count < min) {
            return 0;
        }
        return (int) (isFu ? -count : count);
    }

    public static int reverse1(int x) {
        boolean isFu = x < 0;
        int temp = isFu ? Math.abs(x) : x;
        long count = 0;
        while (temp > 0) {
            count += temp % 10;
            temp = temp / 10;
            if (temp == 0) {
                break;
            }
            count = count * 10;

        }
        if (count > Integer.MAX_VALUE || -count < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (isFu ? -count : count);
    }


    public static void main(String[] args) {
        System.out.println(Reverse.reverse1(-321));;
    }
}
