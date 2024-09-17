import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> temp = new ArrayList<>();
        for(int i=0; i<rank.length; i++) if(attendance[i]) temp.add(new int[]{i, rank[i]});
        Collections.sort(temp, (a, b) -> a[1] - b[1]);
        int answer = 0;
        for(int i=0; i<3; i++) {
            answer = answer * 100 + temp.get(i)[0];
        }
        return answer;
    }
}