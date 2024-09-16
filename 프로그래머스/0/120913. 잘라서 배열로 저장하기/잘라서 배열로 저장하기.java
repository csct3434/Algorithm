class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[((my_str.length() - 1) / n) + 1];
        for(int i=0; i<answer.length; i++) {
            answer[i] = my_str.substring(i * n, Math.min((i + 1) * n, my_str.length()));
        }
        return answer;
    }
}