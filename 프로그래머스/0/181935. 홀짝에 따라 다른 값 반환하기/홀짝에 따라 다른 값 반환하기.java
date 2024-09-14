class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n % 2 == 1) ans = (n + 1) / 2 * (n + 1) / 2;
        else for(int i=2; i<=n; i+=2) ans += i * i;
        return ans;
    }
}