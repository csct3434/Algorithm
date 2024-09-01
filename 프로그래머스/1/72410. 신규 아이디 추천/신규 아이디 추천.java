class Solution {
    public String solution(String new_id) {
        boolean[] valid = new boolean[128];
        for(char c = 'a'; c <= 'z'; c++) {
            valid[c] = true;
        }
        for(char c : new char[]{'.', '-', '_'}) {
            valid[c] = true;
        }
        for(char c='0'; c <= '9'; c++) {
            valid[c] = true;
        }

        // step1
        new_id = new_id.toLowerCase();

        // step2
        StringBuilder answer = new StringBuilder();
        for(char c : new_id.toCharArray()) {
            if(valid[c]) answer.append(c);
        }

        // step3
        StringBuilder temp = new StringBuilder();
        boolean duplicated = false;
        for(int i=0; i<answer.length(); i++) {
            if(answer.charAt(i) == '.' && duplicated) continue;
            temp.append(answer.charAt(i));
            duplicated = answer.charAt(i) == '.';
        }
        answer = temp;
        
        // step4
        if(answer.length() > 0 && answer.charAt(0) == '.') answer.deleteCharAt(0);
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);

        // step5
        if(answer.length() == 0) answer.append('a');

        // step6
        if(answer.length() > 15) {
            answer = new StringBuilder(answer.substring(0, 15));
            if(answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);
        }
        
        // step7
        if(answer.length() <= 2) {
            answer.append(String.valueOf(answer.charAt(answer.length() - 1)).repeat(3 - answer.length()));
        }

        return answer.toString();
    }
}