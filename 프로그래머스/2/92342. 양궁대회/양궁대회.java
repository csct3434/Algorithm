class Solution {
    public int[] solution(int n, int[] info) {
        int shotMask = 0, maxDiff = 0;
        
        for(int mask=0; mask < (1 << info.length); mask++) {
            int arrows = 0;
            
            for(int i=0; i < info.length; i++) {
                if((mask & (1 << i)) > 0) {
                    arrows += info[i] + 1;
                }
            }
            
            if(n < arrows) {
                continue;
            }
            
            int diff = calcDiff(info, mask);
            
            if(diff > maxDiff || (diff == maxDiff && mask > shotMask)) {
                shotMask = mask;
                maxDiff = diff;
            }
        }
        
        if(maxDiff == 0) {
            return new int[]{-1};
        }
        
        int[] temp = new int[info.length];
        int remains = n;
        for(int i=0; i<info.length; i++) {
            if((shotMask & (1 << i)) > 0) {
                temp[i] = info[i] + 1;
                remains -= temp[i];
            }
        }
        temp[temp.length - 1] += remains;
        
        return temp;
    }
    
    private int calcDiff(int[] info, int mask) {
        int apeach = 0, lion = 0;
        
        for(int i=0; i<info.length; i++) {
            if((mask & (1 << i)) > 0) {
                lion += 10 - i;
                continue;
            }
            if(info[i] > 0) {
                apeach += 10 - i;
            }
        }
        
        return lion - apeach;
    }
}