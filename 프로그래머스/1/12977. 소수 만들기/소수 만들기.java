class Solution {
    public int solution(int[] nums) {
        int len = nums.length, count = 0;;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=j+1; k<len; k++) {
                    if  (isPrime(nums[i] + nums[j] + nums[k])) count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPrime(int num) {
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}