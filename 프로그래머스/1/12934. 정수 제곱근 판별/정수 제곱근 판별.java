class Solution {
    public long solution(long n) {
        if(Math.sqrt(n) % 1 == 0) {
            long t = (long) Math.sqrt(n) + 1;
            return t * t;
        }
        return -1;
    }
}