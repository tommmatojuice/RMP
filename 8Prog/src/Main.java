import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 25));
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give K: ");
        int K = scanner.nextInt(), k, c=0;
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            k=0;
            for(int j=i+1; j< array.length-1; j++)
                if(array[i]==array[j]) k++;
            if(!numbers.containsKey(array[i])) numbers.put(array[i], k+1);
        }
        Map<Integer, Integer> result = numbers.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry entry : result.entrySet()) {
            if(c==K) break;
            System.out.println("Number: " + entry.getKey() + " Count: " + entry.getValue());
            c++;
        }
    }
}
