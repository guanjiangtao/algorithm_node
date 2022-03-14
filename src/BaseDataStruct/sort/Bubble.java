package BaseDataStruct.sort;

import java.util.Arrays;

public class Bubble {

    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.initIntArr();
        Bubble bubble = new Bubble();
        bubble.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
