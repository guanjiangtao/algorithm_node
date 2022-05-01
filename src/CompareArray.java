import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 以上都是最差的情况，也就是遍历到最后一刻才发现不一样
 */
public class CompareArray {

    /**
     * 解法1：直接hash一波，如果是相同的数组hash值一定一样的
     * 耗时 6s
     */
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        return Arrays.hashCode(arr1) == Arrays.hashCode(arr2);
    }

    /**
     * 解法2：暴力遍历法
     * 耗时 342 s
     */
    public static boolean compareArrays1(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            sets.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            // 如果出现不包含的情况就一定是不同的
            if (!sets.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 先排序，直接遍历比较
     * 耗时：281s
     */
    public static boolean compareArrays2(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        // 排序 底层是：DualPivotQuicksort，排序耗时279s，迭代耗时2s
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1 != arr2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 直接利用Set的不可重复性解决
     * 原理：底层其实还是hashmap，但是这个hash比上面的hash快的原因是hashmap的hash走的是native的工具方法，c++实现会比上面Array.hashcode快
     * 耗时 1s
     */
    public static boolean compareArrays3(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        Set<int[]> set = new HashSet<>(List.of(arr1));
        set.add(arr2);
        return set.size() == 1;
    }

    /**
     * 分治 不过为个人不太不认为这个效率会很高，因始终我们需要确保数组是否想等，我们就必须走完所有的
     * 分片  + 多线程
     * 耗时 196s（使用HashMap）
     * 耗时 115s（使用Set）
     */
    public static boolean compareArrays4(int[] arr1, int[] arr2) {
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        final boolean[] flag = {true};
        for (int i = 0; i < 10000; i++) {
            int start = i * 100;
            int end = (i + 1) * 100;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    for (int i = start; i < end; i++) {
//                        if (map.containsKey(arr1[i])) {
//                            map.put(arr1[i], map.get(arr1[i]) + 1);
//                        } else {
//                            map.put(arr1[i], 1);
//                        }
                        set.add(arr1[i]);
                    }
                }
            };
            r.run();
        }

        for (int i = 0; i < 10000; i++) {
            int start = i * 100;
            int end = (i + 1) * 100;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    for (int i = start; i < end; i++) {
                        // 如果出现不包含的情况就一定是不同的
                        if (!set.contains(arr2[i])) {
                            flag[0] = false;
                            return;
                        }
                    }
                }
            };
            r.run();
        }
        return flag[0];
    }


    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = r.nextInt(1000000);
        }
        int[] arr2 = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr2[i] = r.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        System.out.println(compareArrays(arr, arr));
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end -start) + "s");

        long start1 = System.currentTimeMillis();
        System.out.println(compareArrays1(arr, arr));
        long end1 = System.currentTimeMillis();
        System.out.println("耗时:" + (end1 -start1) + "s");

        long start2 = System.currentTimeMillis();
        System.out.println(compareArrays2(arr, arr));
        long end2 = System.currentTimeMillis();
        System.out.println("耗时:" + (end2 -start2) + "s");

        long start3 = System.currentTimeMillis();
        System.out.println(compareArrays3(arr, arr2));
        long end3 = System.currentTimeMillis();
        System.out.println("耗时:" + (end3 - start3) + "s");

        long start4 = System.currentTimeMillis();
        System.out.println(compareArrays4(arr, arr));
        long end4 = System.currentTimeMillis();
        System.out.println("耗时:" + (end4 - start4) + "s");
    }
}
