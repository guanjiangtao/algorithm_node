package BaseDataStruct.sort;

public class Utils {

    public static void  swap(int[] arr, int i, int j) {
        int param = arr[i];
        arr[i] = arr[j];
        arr[j] = param;
    }

    public static int[] initIntArr() {
        return new int[]{3,4,3,2,1,4,-1,9,0};
    }
}
