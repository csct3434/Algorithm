class Solution {
    public int solution(int a, int b) {
        b /= gcm(a, b);
        while(b % 2 == 0) b /= 2;
        while(b % 5 == 0) b /= 5;
        return b == 1 ? 1 : 2;
    }
    
    private int gcm(int a, int b) {
        if(a % b == 0) return b;
        return gcm(b, a % b);
    }
}