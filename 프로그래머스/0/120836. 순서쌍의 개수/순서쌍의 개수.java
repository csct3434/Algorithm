class Solution {
    public int solution(int n) {
        int ans = 0;
        for(int i=1; i * i <= n; i++) {
            if(n % i != 0) continue;
            ans += i * i == n ? 1 : 2;
        }
        return ans;
    }
}