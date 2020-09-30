import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give N: ");
        int N = scanner.nextInt();
        System.out.print("Please give power: ");
        int k = scanner.nextInt(), sum=0;
        for(int i=1; i<N+1; i++){
            sum+=Math.pow(i, k);
        }
        System.out.print("Sum = " + sum);
    }
}
