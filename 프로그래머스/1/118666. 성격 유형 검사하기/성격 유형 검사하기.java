class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] score = new int[26];
        for(int i=0; i<survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];
            if(choice == 4) continue;
            score[type.charAt(choice / 4) - 'A'] += Math.abs(4 - choice);
        }
        for(String type : new String[]{"RT", "CF", "JM", "AN"}) {
            answer.append(score[type.charAt(0) - 'A'] >= score[type.charAt(1) - 'A'] ? type.charAt(0) : type.charAt(1));
        }
        return answer.toString();
    }
}