class Solution {
    public int solution(int price) {
        return price * (price < 100000 ? 100 : price < 300000 ? 95 : price < 500000 ? 90 : 80) / 100;
    }
}