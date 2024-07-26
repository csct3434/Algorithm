class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        for(int idx = 0, pLen = p.length(), tLen = t.length(); idx + pLen <= tLen; idx++) {
            if(Long.parseLong(t.substring(idx, idx + pLen)) <= pValue) answer++;
        }
        return answer;
    }
}