class Solution {
    public boolean solution(int x) {
        int t = x, s = 0;
        while(t > 0) {
            s += t % 10;
            t /= 10;
        }
        return x % s == 0;
    }
}