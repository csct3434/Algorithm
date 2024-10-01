class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n-- > 0) while(++ans % 3 == 0 || String.valueOf(ans).contains("3"));
        return ans;
    }
}