class Solution {
    public int solution(int a, int b) {
        return (a + b) % 2 == 1 ? 2 * (a + b) : (a % 2 == 0 ? Math.abs(a - b) : a * a + b * b);
    }
}