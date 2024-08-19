class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling) {
            if(word.contains("ayaaya") || word.contains("yeye") 
               || word.contains("woowoo") || word.contains("mama")) {
                continue;
            }
            if(word.replaceAll("aya|ma|ye|woo", " ").replace(" ", "").equals("")) answer++;
        }
        return answer;
    }
}