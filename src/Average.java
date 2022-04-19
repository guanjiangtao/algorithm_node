public class Average {
    // 计算平均数
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int total = 0;
        for (int i = 0; i < salary.length; i++) {
            if (max < salary[i]) {
                max = salary[i];
            }

            if (min > salary[i]) {
                min = salary[i];
            }
            total += salary[i];
        }
        return ((double)(total - max - min) / (salary.length - 2));
    }

    public static void main(String[] args) {
        Average average = new Average();
        double ave = average.average(new int[]{4000,3000,1000,2000});
        System.out.println(ave);
    }
}
