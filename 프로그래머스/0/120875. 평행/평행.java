class Solution {
    public int solution(int[][] dots) {
        int[] a1, a2, b1, b2;
        a1 = a2 = b1 = b2 = null;
        for(int i=0; i<4; i++) {
            for(int j=i+1; j<4; j++) {
                for(int k=0; k<4; k++) {    
                    if(k == i) {
                        a1 = dots[k];
                    } else if(k == j) {
                        a2 = dots[k];
                    } else {
                        if(b1 == null) b1 = dots[k];
                        else b2 = dots[k];
                    }
                }
                int adx = a1[0] - a2[0], ady = a1[1] - a2[1];
                int bdx = b1[0] - b2[0], bdy = b1[1] - b2[1];
                if(adx == 0 || bdx == 0) {
                    if(adx + bdx == 0) return 1;
                    continue;
                }
                if (ady * bdx == adx * bdy) return 1;
                b1 = null;
            }
        }
        return 0;
    }
}