import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        while (true) {
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }
            if (arr[0] + arr[1] + arr[2] == 0) break;
            Arrays.sort(arr);
            if (arr[0] + arr[1] > arr[2]) {
                if (arr[0] == arr[1] && arr[1] == arr[2]) {
                    System.out.println("Equilateral");
                } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            } else {
                System.out.println("Invalid");
            }
        }
    }
}