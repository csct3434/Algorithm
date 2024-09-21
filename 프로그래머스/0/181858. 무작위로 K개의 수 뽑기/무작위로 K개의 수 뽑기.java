import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] temp = Arrays.stream(arr).distinct().toArray();
        int[] answer = new int[k];
        for(int i=0; i<k; i++) answer[i] = i < temp.length ? temp[i] : -1;
        return answer;
    }
}