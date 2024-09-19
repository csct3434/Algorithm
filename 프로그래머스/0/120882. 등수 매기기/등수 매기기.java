import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int[][] temp = new int[score.length][3];
        for(int i=0; i<score.length; i++) {
            temp[i][0] = i;
            temp[i][1] = score[i][0] + score[i][1];
        }
        Arrays.sort(temp, (a, b) -> b[1] - a[1]);
        temp[0][2] = 1;
        for(int i=1; i<temp.length; i++) {
            temp[i][2] = temp[i][1] == temp[i-1][1] ? temp[i-1][2] : i+1;
        }
        int[] answer = new int[temp.length];
        for(int i=0; i<temp.length; i++) {
            answer[temp[i][0]] = temp[i][2];
        }
        return answer;
    }
}