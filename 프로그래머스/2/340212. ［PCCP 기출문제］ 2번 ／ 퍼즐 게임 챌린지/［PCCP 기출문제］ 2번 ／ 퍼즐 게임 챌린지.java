class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        int l = 1, r = 100000;
        while(l <= r) {
            int m = (l + r) / 2;
            if(check(m, diffs, times, limit)) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }
    
    private boolean check(int level, int[] diffs, int[] times, long limit) {
        long time = times[0];
        for(int i=1; i<diffs.length; i++) {
            time += Math.max(diffs[i] - level, 0) * (times[i - 1] + times[i]) + times[i];
            if(time > limit) return false;
        }
        return true;
    }
}