public class SearchMatrix {

    //    public static boolean searchMatrix(int[][] matrix, int target) {
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][matrix[i].length - 1] < target) {
//                continue;
//            }
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] > target) {
//                    break;
//                }
//                if (i == matrix.length - 1 && matrix[i][j] > target) {
//                    break;
//                }
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            // 满足条件直接break
            if (matrix[x][y] == target) {
                return true;
            }
            // 如果当前值小于target则指针向下移一位，如果大于target则指针想后移动一位
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(SearchMatrix.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }
}
