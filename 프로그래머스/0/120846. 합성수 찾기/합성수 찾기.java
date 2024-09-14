class Solution {
    public int solution(int n) {
        boolean[] isComposite = new boolean[n+1];
        for(int i=2; i <= n; i++) {
            if(isComposite[i]) continue;
            for(int j=2; i*j <= n; j++) isComposite[i*j] = true;
        }
        int answer = 0;
        for(boolean flag : isComposite) if(flag) answer++;
        return answer;
    }
}