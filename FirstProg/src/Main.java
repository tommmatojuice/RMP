public class Main {
    public static void main(String[] args){
        int[] array = new int[50];
        int max, min, sum=0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 10000) - 5000);
            System.out.println(array[i]);
        }
        max = array[0];
        min = max;
        for (int j : array) {
            if (max < j) max = j;
            if (min > j) min = j;
            sum += j;
        }
        System.out.println("Min=" + min + "\n" + "Max=" + max + "\n" + "Avg=" + (float)sum/array.length);
    }
}
