class Solution {
    public int[] solution(int[] num_list) {
        int[] ans = new int[num_list.length];
        for(int i=0, n = num_list.length; i<n; i++) ans[n - 1 - i] = num_list[i];
        return ans;
    }
}