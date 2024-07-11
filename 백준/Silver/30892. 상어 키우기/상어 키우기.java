import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        long size;
        N = sc.nextInt();
        K = sc.nextInt();
        size = sc.nextLong();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        list.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < K; i++) {
            int idx = binarySearch(list, size);
            if(idx == -1) {
                System.out.println(size);
                return;
            }
            size += list.remove(idx);
        }
        System.out.println(size);
    }

    private static int binarySearch(List<Integer> list, long size) {
        int l = 0, r = list.size() - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if(list.get(m) < size) l = m + 1;
            else r = m - 1;
        }
        if(l < 0) return -1;
        if(list.get(l) >= size) return l-1;
        return l;
    }

}
