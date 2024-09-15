class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31];
        for(String str : strArr) count[str.length()]++;
        int ans = 0;
        for(int c : count) ans = Math.max(ans, c);
        return ans;
    }
}