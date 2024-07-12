import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int idx;
        for (idx = 1;  idx < arr.length; idx++) {
            if (arr[0] != arr[idx]) break;
        }
        if (idx == arr.length) {
            System.out.println(arr.length);
            return;
        }
        int[] a = {arr[0], idx}, b = {arr[idx], 1};
        int answer = a[1] + b[1], t;
        for (int i = idx + 1; i < arr.length; i++) {
            t = arr[i];
            if (t == a[0]) {
                a[1]++;
                answer = Math.max(answer, a[1] + b[1]);
            } else if (t == b[0]) {
                b[1]++;
                answer = Math.max(answer, a[1] + b[1]);
            } else {
                a = new int[]{arr[i - 1], 0};
                b = new int[]{t, 1};
                idx = i - 1;
                while (idx >= 0 && arr[idx--] == a[0]) a[1]++;
            }
        }
        answer = Math.max(answer, a[1] + b[1]);
        System.out.println(answer);
    }
}
