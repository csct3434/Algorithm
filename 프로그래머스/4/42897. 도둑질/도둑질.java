class Solution {
    public int solution(int[] money) {
        int answer = 0, n = money.length;
        
        int a0 = 0, a1 = money[1], t0, t1; 
        for(int i=2; i<n; i++) {
            t0 = a0 > a1 ? a0 : a1; 
            t1 = money[i] + a0;
            a0 = t0; a1 = t1;
        }
        answer = a0 > a1 ? a0 : a1;
        
        a0 = a1 = money[0];
        for(int i=2; i<n; i++) {
            t0 = a0 > a1 ? a0 : a1; 
            t1 = money[i] + a0;
            a0 = t0; a1 = t1;
        }
        
        return answer > a0 ? answer : a0;
    }
}