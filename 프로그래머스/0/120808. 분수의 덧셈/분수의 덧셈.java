class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int a = numer1 * denom2 + numer2 * denom1;
        int b = denom1 * denom2;
        int gcm = gcm(a, b);
        return new int[]{a / gcm, b / gcm};
    }
    
    private int gcm(int a, int b) {
        if(b == 0) return a;
        return gcm(b, a % b);
    }
}