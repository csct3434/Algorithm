class Solution {
    public int solution(int[] money) {
        int answer = 0, n = money.length;
        
        int a0 = 0, a1 = money[1], t0, t1; 
        for(int i=2; i<n; i++) {
            t0 = Math.max(a0, a1);
            t1 = money[i] + a0;
            a0 = t0; a1 = t1;
        }
        answer = Math.max(a0, a1);
        
        a0 = a1 = money[0];
        for(int i=2; i<n; i++) {
            t0 = Math.max(a0, a1);
            t1 = money[i] + a0;
            a0 = t0; a1 = t1;
        }
        
        return Math.max(answer, a0);
    }
}