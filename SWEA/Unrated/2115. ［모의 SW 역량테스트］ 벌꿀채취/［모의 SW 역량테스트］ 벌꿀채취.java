import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()), N, M, C;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j + M <= N; j++) {
                    int[] temp = new int[M];
                    System.arraycopy(arr[i], j, temp, 0, M);
                    int value = 0;
                    for (int k = 0; k < (1 << M); k++) {
                        int w = 0, v = 0;
                        for (int l = 0; l < M; l++) {
                            if ((k & (1 << l)) != 0) {
                                w += temp[l];
                                v += temp[l] * temp[l];
                            }
                        }
                        if (w <= C) {
                            value = Math.max(value, v);
                        }
                    }
                    pq.add(new int[]{i, j, value});
                }
            }
            int[][] works = new int[pq.size()][];
            int idx = 0;
            while (!pq.isEmpty()) {
                works[idx++] = pq.remove();
            }
            int ans = 0;
            for (int i = 0; i < works.length; i++) {
                int[] work = works[i];
                boolean flag = false;
                int sum = work[2];
                for (int j = i + 1; j < works.length; j++) {
                    if (work[0] != works[j][0] || Math.abs(work[1] - works[i][1]) >= M) {
                        flag = true;
                        sum += works[j][2];
                    }
                    if (flag) break;
                }
                ans = Math.max(ans, sum);
            }
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }
}