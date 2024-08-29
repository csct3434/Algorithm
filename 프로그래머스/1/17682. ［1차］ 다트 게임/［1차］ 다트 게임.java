class Solution {
    public int solution(String dartResult) {
        StringBuilder temp = new StringBuilder();
        temp.append(dartResult.charAt(0));
        for(int i=1; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(Character.isDigit(c) && !Character.isDigit(dartResult.charAt(i - 1))) temp.append(" ");
            temp.append(c);
        }
        String[] tokens = temp.toString().split(" ");
        int previousScore = 0, totalScore = 0;
        int[] bonus = new int[26];
        bonus['S' - 'A'] = 1;
        bonus['D' - 'A'] = 2;
        bonus['T' - 'A'] = 3;
        for(String token : tokens) {
            int score = token.charAt(1) == '0' ? 10 : token.charAt(0) - '0';
            int bIdx = score >= 10 ? token.charAt(2) : token.charAt(1);
            score = (int) Math.pow(score, bonus[bIdx - 'A']);
            if(token.contains("*")) {
                score *= 2;
                previousScore *= 2;
            } else if(token.contains("#")) {
                score *= -1;
            }
            totalScore += previousScore;
            previousScore = score;
        }
        return totalScore + previousScore;
    }
}