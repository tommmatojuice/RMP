import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give N: ");
        int N = scanner.nextInt();
        int[] array = new int[N];
        array[0]=0;
        array[1]=1;
        IntStream.range(2, N).forEach(i -> array[i] = array[i - 2] + array[i - 1]);
        System.out.print(N+": " + array[N-1]);
    }
}
