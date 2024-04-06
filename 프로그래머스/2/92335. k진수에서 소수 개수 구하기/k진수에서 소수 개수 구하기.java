class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        for(String number : toDigit(n, k).split("0")) {
            if(!number.equals("") && isPrime(Long.valueOf(number))) {
                answer++;
            }
        }
        return answer;
    }
    
    private String toDigit(int decimalNumber, int digit) {
        StringBuilder result = new StringBuilder();
        while(decimalNumber > 0) {
            result.insert(0, decimalNumber % digit);
            decimalNumber /= digit;
        }
        return result.toString();
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