import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(target -> target[1]));

        answer++;
        int lastPos = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if (s >= lastPos) {
                lastPos = e;
                answer++;
            }
        }

        return answer;
    }
}