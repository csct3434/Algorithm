class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int len = num_list.length;
        for(int i=0; i < len - n; i++) {
            answer[i] = num_list[n + i];
        }
        for(int i=0; i<n; i++) {
            answer[len - n + i] = num_list[i];
        }
        return answer;
    }
}