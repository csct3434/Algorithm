import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int left = 0, right = B.length - 1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = A.length - 1; i >= 0 && left <= right; i--) {
            if(A[i] < B[right]) {
                answer++;
                right--;
            } else {
                left++;
            }
        }
        
        return answer;
    }
}