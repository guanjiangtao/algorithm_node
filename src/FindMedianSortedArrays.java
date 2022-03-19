import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 有问题
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newNums = new int[nums1.length + nums2.length];
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        Collections.sort(list);

        int mid = newNums.length / 2;
        if (newNums.length % 2 != 0) {
            return list.get(mid);
        } else {
            return ((double)(list.get(mid - 1) + list.get(mid)) / 2);
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] newNums = new int[nums1.length + nums2.length];
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        Collections.sort(list);

        int mid = newNums.length / 2;
        if (newNums.length % 2 != 0) {
            return list.get(mid);
        } else {
            return ((double)(list.get(mid - 1) + list.get(mid)) / 2);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(new int[]{4,5}, new int[]{1,2,3}));;
    }
}
