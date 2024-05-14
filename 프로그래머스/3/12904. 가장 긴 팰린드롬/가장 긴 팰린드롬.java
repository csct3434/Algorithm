class Solution {

    public int solution(String s) {
        int answer = 1, len = s.length();

        for (int i=0; i < len; i++) {
            for (int j=1; i-j >= 0 && i+j < len; j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    answer = Math.max(answer, j * 2 + 1);
                } else {
                    break;
                }
            }
        }
        
        for(int i=0; i<len; i++) {
            for(int j=1; i-j+1 >=0 && i+j < len; j++) {
                if(s.charAt(i-j+1) == s.charAt(i+j)) {
                    answer = Math.max(answer, j * 2);
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}