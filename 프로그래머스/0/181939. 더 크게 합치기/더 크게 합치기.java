class Solution {
    public int solution(int a, int b) {
        int ab = Integer.parseInt(String.format("%d%d",a,b));
        int ba = Integer.parseInt(String.format("%d%d",b,a));
        return ab > ba ? ab : ba;
    }
}