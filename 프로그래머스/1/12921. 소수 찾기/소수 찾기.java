class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n+1];
        for(int i=2; i<n; i++) {
            for(int j=2; i * j <= n; j++) {
                isNotPrime[i*j] = true;
            }
        }
        int count = 0;
        for(int i=2; i<=n; i++) {
            if(!isNotPrime[i]) count++;
        }
        return count;
    }
}