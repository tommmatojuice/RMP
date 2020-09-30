public class Main {
    public static void sort(int[] arr) {
        for (int min = 0; min < arr.length; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least])
                    least = j;
            }
            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }
    }

    public static void main(String[] args){
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 10000));
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
        sort(array);
        for (int j : array) {
            System.out.print(j);
            System.out.print(' ');
        }
    }
}
