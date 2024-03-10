import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] numbers = new int[][]{{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<3; j++) {
                if(answers[i] == numbers[j][i % numbers[j].length]) {
                    score[j]++;
                }
            }
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answer = new LinkedList<>();
        for(int i=0; i<3; i++) {
            if(maxScore == score[i]) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}