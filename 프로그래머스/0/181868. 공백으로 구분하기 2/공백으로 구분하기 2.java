import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        String[] answer = new String[st.countTokens()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = st.nextToken();
        }
        return answer;
    }
}