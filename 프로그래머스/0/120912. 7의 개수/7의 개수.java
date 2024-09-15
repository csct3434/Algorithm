class Solution {
    public int solution(int[] array) {
        int ans = 0;
        for(int num : array) {
            while(num > 0) {
                if(num % 10 == 7) ans++;
                num /= 10;
            }
        }
        return ans;
    }
}