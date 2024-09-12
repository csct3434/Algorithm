class Solution {
    public int solution(int n, String control) {
        int[] a = {1, -1, 10, -10};
        for(char c : control.toCharArray()) n += a["wsda".indexOf(c)];
        return n;
    }
}