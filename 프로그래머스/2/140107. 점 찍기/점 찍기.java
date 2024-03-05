class Solution {

    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            answer += 1 + ((int) Math.sqrt(1D * d * d - 1D * x * x) / k);
        }

        return answer;
    }
}
