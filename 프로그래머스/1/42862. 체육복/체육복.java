class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] isLost = new boolean[n+2];
        boolean[] isReserve = new boolean[n+2];
        
        for(int l : lost)   isLost[l] = true;
        for(int r : reserve)    isReserve[r] = true;
        
        for(int i=1; i<=n; i++) {
            if(!isLost[i]) {
                answer++;
                continue;
            }
            
            if(isReserve[i]) {
                isReserve[i] = false;
                answer++;
                continue;
            }
            
            if(isReserve[i - 1]) {
                answer++;
                continue;
            }
            
            if(!isLost[i+1] && isReserve[i+1]) {
                isReserve[i+1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}