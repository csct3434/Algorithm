class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1r1 = 1L * r1 * r1;
        long r2r2 = 1L * r2 * r2;
                
        for(long x = 1; x <= r2; x++) {
            double y1 = Math.ceil(Math.sqrt(Math.max(0, r1r1 - x * x)));
            double y2 = Math.floor(Math.sqrt(r2r2 - x * x));
            answer += y2 - y1 + 1;
        }
    
        return answer * 4;
    }
}