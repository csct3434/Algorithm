import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int targetIdx = -1;
        int[][] diff = new int[n][n];
        
        for(int i=0; i<n; i++) {
            if(words[i].equals(target)) {
                targetIdx = i;
            }
            
            for(int j=i+1; j<n; j++) {
                diff[i][j] = diff[j][i] = countDiff(words[i], words[j]);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(countDiff(begin, words[i]) == 1) {
                visited[i] = true;
                queue.add(new int[]{i, 1});
            }
        }
        
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int wordIdx = info[0];
            int count = info[1];
            
            if(wordIdx == targetIdx) {
                return count;
            }
            
            for(int i=0; i<n; i++) {
                if(!visited[i] && diff[wordIdx][i] == 1) {
                    queue.add(new int[]{i, count + 1});
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    private int countDiff(String w1, String w2) {
        int diff = 0;

        char[] wc1 = w1.toCharArray();
        char[] wc2 = w2.toCharArray();

        for(int i=0; i < wc1.length; i++) {
            if(wc1[i] != wc2[i]) {
                diff++;
            }
        }
        
        return diff;
    }
}