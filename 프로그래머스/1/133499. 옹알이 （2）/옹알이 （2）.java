class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] units = new String[]{"aya", "ye", "woo", "ma"};
        for(String word : babbling) {
            int idx = 0;
            String lastUnit = "";
            boolean success = true;
            while(idx < word.length()) {
                boolean matched = false;
                for(String unit : units) {
                    if(!lastUnit.equals(unit) 
                       && idx + unit.length() <= word.length() 
                       && word.substring(idx, idx + unit.length()).equals(unit)
                      ) {
                        lastUnit = unit;
                        idx += unit.length();
                        matched = true;
                        break;
                    }
                }
                if(!matched) {
                    success = false;
                    break; 
                }
            }
            if(success) answer++;
        }
        return answer;
    }
}