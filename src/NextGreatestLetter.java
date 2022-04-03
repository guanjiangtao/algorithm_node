public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end =letters.length;
        /**
         * 二分查找，往大了找。
         */
        while (start < end) {
            int index = (start + end) / 2;
            // 1.计算当前这个index是否符合条件，且不能越界，
            if (letters[index] == target && index + 1 < letters.length && letters[index + 1] != target) {
                return letters[index + 1];
            } else {
                if (letters[index] > target) {
                    end = index;
                } else if (letters[index] <= target) {
                    start = index + 1;
                }
            }
        }
        // 如果最后一个，则自动回去找第一个字符
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(NextGreatestLetter.nextGreatestLetter(new char[]{'e','e','e','k','q','q','q','v','v','y'}, 'q'));
    }
}
