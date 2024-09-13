class Solution {
    public int solution(int[] num_list) {
        int[] a = new int[2];
        for(int i=0; i<num_list.length; i++) a[i%2] += num_list[i];
        return Math.max(a[0], a[1]);
    }
}