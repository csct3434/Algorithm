import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[20];
        for(int i=1; i<=T; i++) {
            int count = 0;
            sc.nextInt();
            for(int j=0; j<20; j++) {
                arr[j] = sc.nextInt();
            }
            int idx, temp;
            for(int j=1; j<20; j++) {
                idx = j;
                while(idx - 1 >= 0 && arr[idx - 1] > arr[idx]) {
                    temp = arr[idx - 1];
                    arr[idx - 1] = arr[idx];
                    arr[idx] = temp;
                    idx--;
                    count++;
                }
            }
            System.out.printf("%d %d\n", i, count);
        }
    }
}