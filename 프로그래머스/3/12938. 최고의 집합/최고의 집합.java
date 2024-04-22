class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++) {
            answer[i] = s / n;
            if(i >= answer.length - (s % n)) answer[i]++;
        }
        return answer;
    }
}