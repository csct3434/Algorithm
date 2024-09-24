class Solution {
    public int[] solution(int num, int total) {
        int base = (total - (num * num + num) / 2) / num;
        int[] answer = new int[num];
        for(int i=0; i<num; i++) answer[i] = base + i + 1;
        return answer;
    }
}