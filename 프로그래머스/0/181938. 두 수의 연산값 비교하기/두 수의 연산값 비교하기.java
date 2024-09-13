class Solution {
    public int solution(int a, int b) {
        int c = Integer.parseInt(String.format("%d%d",a,b));
        int d = 2 * a * b;
        return c > d ? c : d;
    }
}