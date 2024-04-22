class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        answer += calc(stations[0] - w - 1, w);
        for(int i = 1; i < stations.length; i++) {
            answer += calc((stations[i] - w) - (stations[i-1] + w) - 1, w);
        }
        answer += calc(n - (stations[stations.length - 1] + w), w);
        
        return answer;
    }
    
    private int calc(int distance, int w) {
        int range = 2 * w + 1;
        return distance <= 0 ? 0 : (distance / range) + (distance % range > 0 ? 1 : 0);
    }
}