class Solution {
    public int[] solution(String my_string) {
        int[] ans = new int[52];
        for(char c : my_string.toCharArray()) {
            if(c < 'a') ans[c - 'A']++;
            else ans[26 + c - 'a']++;
        }
        return ans;
    }
}