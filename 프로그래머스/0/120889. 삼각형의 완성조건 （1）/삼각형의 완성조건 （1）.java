class Solution {
    public int solution(int[] sides) {
        int a = 0, b = 0;
        for(int side : sides) {
            a = Math.max(a, side);
            b += side;
        }
        return a < b - a ? 1 : 2;
    }
}