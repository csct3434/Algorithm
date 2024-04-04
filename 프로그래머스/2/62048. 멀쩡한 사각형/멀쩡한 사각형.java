class Solution {

    public long solution(int w, int h) {
        long cut = 0;
        
        for(int y=1; y<=h; y++) {
            cut += Math.ceil(1d * w * y / h) - Math.floor(1d * w * (y - 1) / h);
        }
        
        return (long) w * h - cut;
    }
}