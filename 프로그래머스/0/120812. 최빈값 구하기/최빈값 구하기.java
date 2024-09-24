class Solution {
    public int solution(int[] array) {
        int[] count = new int[1000];
        for(int n : array) count[n]++;
        int maxCount = 0, answer = -1;
        for(int n=0; n<1000; n++) {
            if(count[n] > maxCount) {
                maxCount = count[n];
                answer = n;
            }
            else if(count[n] == maxCount) {
                answer = -1;
            }
        }
        return answer;
    }
}