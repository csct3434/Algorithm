class Solution {

    public long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long) d * d;
        
        for (long x = 0; x <= d; x += k) {
            answer += 1 + ((int) Math.sqrt(dSquare - x * x) / k);
        }

        return answer;
    }
}
