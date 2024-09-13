class Solution {
    public int solution(int[] box, int n) {
        int a = 1;
        for(int i=0; i<3; i++) a *= box[i] / n;
        return a;
    }
}