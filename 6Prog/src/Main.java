import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 10));
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give N from 1 to 10: ");
        int N = scanner.nextInt(), k=0;
        for(int i=0; i<array.length; i++){
            if(array[i]==N){
                k++;
                System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
            }
            if (array[i]==N) i--;
        }
        int[] array2 = new int[array.length-k];
        System.arraycopy(array, 0, array2, 0, array2.length);
        for (int j : array2) {
            System.out.print(j);
            System.out.print(' ');
        }
    }
}
