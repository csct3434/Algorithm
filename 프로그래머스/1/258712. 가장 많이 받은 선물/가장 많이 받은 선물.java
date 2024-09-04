import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int[] giftPoint = new int[N];
        int[][] giftCount = new int[N][N];
        Map<String, Integer> index = new HashMap<>();
        for(int i=0; i<N; i++) index.put(friends[i], i);
        for(String g : gifts) {
            String[] token = g.split(" ");
            int from = index.get(token[0]);
            int to = index.get(token[1]);
            giftPoint[from]++;
            giftPoint[to]--;
            giftCount[from][to]++;
        }
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(giftCount[i][j] == giftCount[j][i]) {
                    if(giftPoint[i] > giftPoint[j]) {
                        answer[i]++;
                    } else if(giftPoint[i] < giftPoint[j]) {
                        answer[j]++;
                    }
                } else {
                    if(giftCount[i][j] > giftCount[j][i]) {
                        answer[i]++;
                    } else {
                        answer[j]++;
                    }
                }
            }
        }
        return Arrays.stream(answer).max().orElse(0);
    }
}