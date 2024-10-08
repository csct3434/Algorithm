class Solution {
    public int solution(String s) {
        int answer = 1, idx = 0, count = 1;
        char c = s.charAt(0);
        while(++idx < s.length()) {
            if( (count += s.charAt(idx) != c ? -1 : 1) == 0 ) {
                if(idx == s.length() - 1) break;
                count = 1;
                c = s.charAt(++idx);
                answer++;
            }
        }
        return answer;
    }
}