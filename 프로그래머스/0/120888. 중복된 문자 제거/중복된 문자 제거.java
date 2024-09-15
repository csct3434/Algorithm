class Solution {
    public String solution(String my_string) {
        boolean[] duplicated = new boolean[128];
        StringBuilder ans = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if(duplicated[c]) continue;
            ans.append(c);
            duplicated[c] = true;
        }
        return ans.toString();
    }
}