class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        for(String number : Integer.toString(n, k).split("0")) {
            if(!number.equals("") && isPrime(Long.valueOf(number))) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isPrime(long n) {
        if(n == 1) return false;
        
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}