import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0, sum = 0;
        int[] answer = new int[]{0, sequence.length - 1};
        
        while(true) {
            if(sum >= k) {
                if(sum == k && right - left < answer[1] - answer[0] + 1) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left++];
            } else {
                if(right == sequence.length) break;
                sum += sequence[right++];
            }
        }
        
        return answer;
    }
}