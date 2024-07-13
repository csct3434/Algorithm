import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println( ( (H - 1) / (N + 1) + 1) * ( (W - 1) / (M + 1) + 1) );
    }
}