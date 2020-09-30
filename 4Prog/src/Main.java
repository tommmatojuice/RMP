public class Main {
    public static void main (String[] args) {
        boolean f;
        System.out.println("Prime numbers: ");
        for (int i=2; i<=100; i++) {
            f = true;
            for (int j=2; j<i; j++) {
                if ((i % j) == 0) {
                    f = false;
                    break;
                }
            }
            if (f) System.out.println(i);
        }
    }
}
