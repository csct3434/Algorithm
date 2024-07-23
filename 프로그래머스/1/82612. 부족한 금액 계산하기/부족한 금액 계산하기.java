class Solution {
    public long solution(int price, int money, int count) {
        long cost = (long) price * ((1 + count) * count / 2); 
        return money < cost ? cost - money : 0;
    }
}