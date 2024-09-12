class Solution {
    public int solution(int[] num_list) {
        String[] a = new String[]{"", ""};
        for(int n : num_list) a[n % 2] += n;
        return Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
    }
}