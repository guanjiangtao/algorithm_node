package BaseDataStruct.sort;

import java.util.Arrays;

public class Selection {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            Utils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.initIntArr();
        Selection selection = new Selection();
        selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
