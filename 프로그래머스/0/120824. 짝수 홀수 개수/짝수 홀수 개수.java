class Solution {
    public int[] solution(int[] num_list) {
        int[] ans = new int[2];
        for(int num : num_list) ans[num % 2]++;
        return ans;
    }
}