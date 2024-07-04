class Solution {
    public long solution(long n) {
        int[] count = new int[10];
        while(n > 0) {
            count[(int)(n % 10)]++;
            n /= 10;
        }
        long answer = 0;
        for(int digit=9; digit>=0; digit--) {
            for(int i=0; i<count[digit]; i++) {
                answer = answer * 10 + digit;
            }
        }
        return answer;
    }
}