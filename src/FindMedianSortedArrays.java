import java.util.Arrays;

// 有问题
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newNums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        // 归并
        while (i < nums1.length || j < nums2.length) {
            Integer a = null, b = null, before = null;
            if (i < nums1.length) {
                a = nums1[i];
                i++;
            }
            if (j < nums2.length) {
                b = nums2[j];
                j++;
            }
            if (k - 1 >= 0) {
                before = newNums[k - 1];
            }

            if (a == null && b != null) {
                if (before != null) {
                    if (b < before) {
                        newNums[k - 1] = b;
                        newNums[k++] = before;
                    } else {
                        newNums[k++] = b;
                    }
                } else {
                    newNums[k++] = b;
                }

            } else if (a != null && b == null) {
                if (before != null) {
                    if (a < before) {
                        newNums[k - 1] = a;
                        newNums[k++] = before;
                    } else {
                        newNums[k++] = a;
                    }
                } else {
                    newNums[k++] = a;
                }

            } else if (a != null && b != null) {
                if (a < b) {
                    if (before != null) {
                        if (before < b && before > a) {
                            newNums[k - 1] = a;
                            newNums[k++] = before;
                            newNums[k++] = b;
                        } else if (before > b){
                            newNums[k - 1] = a;
                            newNums[k++] = b;
                            newNums[k++] = before;
                        } else {
                            newNums[k++] = a;
                            newNums[k++] = b;
                        }
                    } else {
                        newNums[k++] = a;
                        newNums[k++] = b;
                    }
                } else {
                    // b < a
                    if (before != null) {
                        if (before < a && before > b) {
                            newNums[k - 1] = b;
                            newNums[k++] = before;
                            newNums[k++] = a;
                        } else if (before > a){
                            newNums[k - 1] = b;
                            newNums[k++] = a;
                            newNums[k++] = before;
                        } else {
                            newNums[k++] = b;
                            newNums[k++] = a;
                        }
                    } else {
                        newNums[k++] = b;
                        newNums[k++] = a;
                    }
                }
            }
        }
        int mid = newNums.length / 2;
        if (newNums.length % 2 != 0) {
            return newNums[mid];
        } else {
            return ((double)(newNums[mid-1] + newNums[mid]) / 2);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(new int[]{4,5}, new int[]{1,2,3}));;
    }
}
