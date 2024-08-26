class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] countX = new int[10], countY = new int[10];
        for(int i=0; i<X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        for(int i=0; i<Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }
        for(int i=9; i>=1; i--) {
            answer.append(String.valueOf(i).repeat(Math.min(countX[i], countY[i])));
        }
        if(answer.length() == 0) {
            return Math.min(countX[0], countY[0]) == 0 ? "-1" : "0";
        }
        return answer.append("0".repeat(Math.min(countX[0], countY[0]))).toString();
    }
}