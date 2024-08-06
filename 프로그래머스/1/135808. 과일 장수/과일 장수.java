class Solution {
    public int solution(int k, int m, int[] score) {
        int[] count = new int[k+1];
        for(int s : score) {
            count[s]++;
        }
        int answer = 0, remainder = 0;
        for(int s=k; s>=1; s--) {
            if(remainder > 0) {
                if(count[s] < m - remainder) {
                    remainder += count[s];
                    continue;
                }
                count[s] -= m - remainder;
                answer += s * m;
                remainder = 0;
            }
            answer += (count[s] / m) * s * m;
            remainder = count[s] % m;
        }
        return answer;
    }
}