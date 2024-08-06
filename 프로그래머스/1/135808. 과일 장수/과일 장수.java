class Solution {
    public int solution(int k, int m, int[] score) {
        int[] count = new int[k+1];
        for(int s : score) {
            count[s]++;
        }
        int answer = 0;
        for(int s=k; s>=1; s--) {
            answer += (count[s] / m) * s * m;
            count[s-1] += count[s] % m;
        }
        return answer;
    }
}