class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()], lastIdx = new int[26];
        for(int i=0; i<26; i++) lastIdx[i] = -1;
        for(int i=0; i<s.length(); i++) {
            int li = lastIdx[s.charAt(i) - 'a'];
            result[i] = li == -1? -1 : i - li;
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        return result;
    }
}