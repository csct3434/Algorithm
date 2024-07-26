class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, n / gcd * m};
    }
    
    private int gcd(int n, int m) {
        if(m == 0) return n;
        return gcd(m, n % m);
    }
}