import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        for(int stage : stages) {
            count[stage]++;
        }
        int total = stages.length;
        List<int[]> failRate = new ArrayList<>();
        for(int stage = 1; stage <= N; stage++) {
            failRate.add(new int[]{stage, count[stage], total});
            total -= count[stage];
        }
        failRate.sort((a, b) -> {
            if(b[2] == 0) {
                if(a[2] == 0) return a[0] - b[0];
                return -1;
            }
            if((long) a[1] * b[2] == (long) b[1] * a[2]) return a[0] - b[0];
            return (long) a[1] * b[2] > (long) b[1] * a[2] ? -1 : 1;
        });
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = failRate.get(i)[0];
        }
        return answer;
    }
}