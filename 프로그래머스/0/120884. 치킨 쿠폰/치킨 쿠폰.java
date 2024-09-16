class Solution {
    public int solution(int chicken) {
        int ans = 0, coupon = chicken;
        while(coupon >= 10) {
            ans += coupon / 10;
            coupon = (coupon / 10) + (coupon % 10);
        }
        return ans;
    }
}