public class Main {
    public static void main(String[] args) {
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 30));
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println("\n" + "The first unique number: ");
        boolean f;
        for(int i=0; i< array.length; i++){
            f=true;
            for(int j=i+1; j< array.length-1; j++){
                if (array[i] == array[j]) {
                    f = false;
                    break;
                }
            }
            if(f) {
                System.out.print(array[i]);
                break;
            }
        }
    }
}
